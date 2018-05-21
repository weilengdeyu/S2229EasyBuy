package cn.mysqltools;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * 将数据库中表转换成java类的方法
 * Created by Shinelon on 2017/7/23.
 */
public class TableToClass {
    private static BaseDAO baseDao = new BaseDAO();
    private static ArrayList<Column> columnArray = new ArrayList<Column>();   // 存放列的集合，以此来建立类中的属性
    private static ArrayList<String> tableNames = new ArrayList<String>();
    private static TypeChange typeChange = new TypeChange();
    private static IOStream ioStream = new IOStream();
    /**
     * 从数据库中获取表，创建类，并把表中的列转化成类的属性
     * @throws Exception
     */
    public static void tableToClass(String path) throws Exception{
        String namePackage = 	TableToClass.class.getPackage().getName(); // 得到所在包的包名
        namePackage = "package "+namePackage;
        // 传来路径之后先判断路径是否存在，如果不存在，则先建路径
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        Connection connection = baseDao.getConn();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String m_TableName="";
        ResultSet tableRet = databaseMetaData.getTables(null, "%", m_TableName, new String[]{"TABLE"});
        while(tableRet.next()) {
            columnArray.clear();
            String tableName=tableRet.getString("TABLE_NAME"); // 获得表名
            // 得到表名后，根据表名建立整个dao层结构
            String tablePath = path+"/"+tableName;
            File tableFile = new File(tablePath);
            String daoPath = path+"/"+tableName+"/dao";
            File daoFile = new File(daoPath);
            String daoImplPath = path+"/"+tableName+"/dao/impl";
            File daoImplFile = new File(daoImplPath);
            String entityPath = path+"/"+tableName+"/entity";
            File entityFile = new File(entityPath);
            String servicePath = path+"/"+tableName+"/service";
            File serviceFile = new File(servicePath);
            String serviceImplPath = path+"/"+tableName+"/service/impl";
            File serviceImplFile = new File(serviceImplPath);
            tableFile.mkdir();
            daoFile.mkdir();
            daoImplFile.mkdir();
            entityFile.mkdir();
            serviceFile.mkdir();
            serviceImplFile.mkdir();
            // 向各个包中添加类
            // 1.BaseDAO类以及database.properties文件
            String thispath = BaseDAO.class.getResource("").getPath();
            thispath = thispath + "TableToClass.java"; // 配置文件路径
            String newpath = TableToClass.class.getResource("").getPath();
            String myeclpath = TableToClass.class.getResource("").getPath();
            myeclpath = myeclpath.replace("bin", "src");
            myeclpath = myeclpath.replace("WebRoot/WEB-INF/classes", "src");
            // 将得到的class文件路径改变为java文件路径
            ArrayList arrayList11 = new ArrayList();
            for(int j =0;j<newpath.length();j++){
                if("/".equals(newpath.subSequence(j,j+1))){
                    arrayList11.add(j);
                }
            }
            int k = newpath.indexOf("out/production");
            int m = k+3;
            int n = 0;
            for(int j = 0;j<arrayList11.size();j++){
                if(arrayList11.get(j).equals(m)){
                    n = j;
                }
            }
            StringBuffer sb = new StringBuffer(newpath);
            sb.insert(Integer.valueOf(((arrayList11.get(n+2)).toString()))+1,"src/");
            newpath = sb.toString();
            newpath = newpath.replace("/out/production","");// /E:/IdealWorkSpace/T14-06/MysqlTools/src/cn/mysqltools/
            File file1 = new File(newpath+"BaseDAO.java");
            File file2 = new File(myeclpath+"BaseDAO.java");
            String baseDAOstr = "";
            if(file1.exists()){ // 如果传入的是Idea中的路径
               baseDAOstr = ioStream.inputStream(newpath+"BaseDAO.java");
            }
            if(file2.exists()){ // 如果传入的是MyEclipse的路径
                baseDAOstr = ioStream.inputStream(myeclpath+"BaseDAO.java");
            }
            String packageNmae = changePathToPac(daoPath);
            packageNmae = "package "+packageNmae;
            baseDAOstr = baseDAOstr.replace(namePackage,packageNmae);
            baseDAOstr = baseDAOstr.replace("cn/mysqltools/database.properties",packageNmae.replace(".","/")+"/database.properties");
            ioStream.outPutStream(daoPath + "/BaseDAO.java",baseDAOstr);
            File file3 = new File(newpath+"database.properties");
            File file4 = new File(myeclpath+"database.properties");
            String proStr = "";
            if(file3.exists()){ // 如果传入的是Idea中的路径
               proStr = ioStream.inputStream(newpath+"database.properties");
            }
            if(file4.exists()){ // 如果传入的是MyEclipse的路径
               proStr = ioStream.inputStream(myeclpath+"database.properties");
            }
            ioStream.outPutStream(daoPath + "/database.properties", proStr);
            // 2、向entity包中添加实体类
            tableNames.add(tableName);
            String tableWord = changeTableToClass(tableName); // 将表名转化成创建类的语句
            ResultSet colRet = databaseMetaData.getColumns(null, "%", m_TableName, "%");

            while(colRet.next()){
                String columnName=colRet.getString("COLUMN_NAME").toLowerCase(); // 列名
                String columnType = colRet.getString("TYPE_NAME").toLowerCase(); // 列类型
                String columTable=(String)colRet.getObject(3); // 所在的表名
                String columnRemarks = colRet.getString("REMARKS"); // 得到备注
                if(columTable.equals(tableName)) {
                    Column column = new Column(null, tableName, columnName, columnType, columnRemarks);
                    columnArray.add(column);
                }
            }
            boolean flagDate = false;  // 判断是否存在Date类型的数据
            Iterator it = typeChange.typeChange(columnArray).iterator();
            while (it.hasNext()) {
                Column column = (Column) it.next();

                if (column.getColumnType().equals("Date")) {
                    flagDate = true;
                }
            }

            String columnWord = changeColumn(columnArray); // 生成属性语句
            String getAndSet = createGetAndSet(columnArray);  // 生成get,set方法语句
            //所有建java类的语句合并到一起
            // 获得包名
            int index = path.indexOf("src");
            String classPackage = path.substring(index+4,path.length());
            classPackage="package  "+changePathToPac(entityPath)+";";
            if(flagDate){
                classPackage = classPackage.concat("\r\nimport java.util.Date;\r\n");

            }
            String conToClass =classPackage+"\r\n\r\n"+tableWord+"{\r\n"+columnWord+getAndSet+"\r\n}";
            String newPath = entityPath+"/"+typeChange.firstAlphToUp(tableName)+".java";
            ioStream.outPutStream(newPath,conToClass);
            System.out.println(tableName+"类生成成功!");


            // 3.向dao包中添加IEntityDAO接口
            File iEntityDaoFile = new File(newpath+"IEntityDAO.java");
            File myEntityDaoFile = new File(myeclpath+"IEntityDAO.java");
            String iEntityBaseDAOStr = "";
            if(iEntityDaoFile.exists()){ // 如果传入的是Idea中的路径
                iEntityBaseDAOStr = ioStream.inputStream(newpath+"IEntityDAO.java");
            }
            if(myEntityDaoFile.exists()){ // 如果传入的是MyEclipse的路径
                iEntityBaseDAOStr = ioStream.inputStream(myeclpath+"IEntityDAO.java");
            }
            iEntityBaseDAOStr = iEntityBaseDAOStr.replace(namePackage,packageNmae);
            iEntityBaseDAOStr = iEntityBaseDAOStr.replace("//import 1","import " + changePathToPac(entityPath) + "." + typeChange.firstAlphToUp(tableName));
            String iEntityBaseDAOName = "I" +typeChange.firstAlphToUp(tableName)+"DAO";
            iEntityBaseDAOStr=iEntityBaseDAOStr.replace("IEntityDAO",iEntityBaseDAOName);
            iEntityBaseDAOStr = iEntityBaseDAOStr.replace("MEntity",typeChange.firstAlphToUp(tableName));
            iEntityBaseDAOStr = iEntityBaseDAOStr.replace("mEntity",tableName);
            iEntityBaseDAOStr = iEntityBaseDAOStr.replace("addMEntity","add"+typeChange.firstAlphToUp(tableName));
            ioStream.outPutStream(daoPath + "/"+iEntityBaseDAOName+".java",iEntityBaseDAOStr);


            // 4、向dao.impl包中添加EntityDAOImpl类
            File iEntityDAOImpl = new File(newpath+"MEntityDAOImpl.java");
            File myEntityDAOImpl = new File(myeclpath+"MEntityDAOImpl.java");
            String entityDAOImpl = "";
            if(iEntityDAOImpl.exists()){ // 如果传入的是Idea中的路径
                entityDAOImpl = ioStream.inputStream(newpath+"MEntityDAOImpl.java");
            }
            if(myEntityDAOImpl.exists()){ // 如果传入的是MyEclipse的路径
                entityDAOImpl = ioStream.inputStream(myeclpath+"MEntityDAOImpl.java");
            }
            String entityDAOImplPackage = "package " + typeChange.pathChangeToPackage(daoImplPath);
            entityDAOImpl = entityDAOImpl.replace(namePackage,entityDAOImplPackage);
            String import1 = "import "+typeChange.pathChangeToPackage(daoPath)+"."+iEntityBaseDAOName;
            entityDAOImpl = entityDAOImpl.replace("//import 1",import1);
            String import2 = "import "+typeChange.pathChangeToPackage(entityPath)+"."+typeChange.firstAlphToUp(tableName);
            entityDAOImpl = entityDAOImpl.replace("//import 2",import2);
            String import3 = "import " +typeChange.pathChangeToPackage(daoPath) +".BaseDAO";
            entityDAOImpl = entityDAOImpl.replace("//import 3",import3);
            entityDAOImpl = entityDAOImpl.replace("MEntity",typeChange.firstAlphToUp(tableName));
            String finalDaoImplPath = daoImplPath + "/" + typeChange.firstAlphToUp(tableName)+"DAOImpl.java";
            entityDAOImpl = entityDAOImpl.replace("Entity",typeChange.firstAlphToUp(tableName));
            String sqlSelect = "select * from " + tableName ;
            entityDAOImpl = entityDAOImpl.replace("select * from ******", sqlSelect);
            String setAttribute ="";
            for(int i = 0;i<columnArray.size();i++){
                String concatWord = "%s.set%s(rs.get%s(\"%s\"));";
                String type = columnArray.get(i).getColumnType();
                String name = columnArray.get(i).getColumnName();
                concatWord = String.format(concatWord,typeChange.firstAlphToUp(tableName),typeChange.firstAlphToUp(name),typeChange.firstAlphToUp(type),name);
                setAttribute = setAttribute.concat("m"+concatWord+"\r\n");
            }
            entityDAOImpl = entityDAOImpl.replace("String word1 = null;", setAttribute);
            String sqlInsert = "insert into "+tableName+"(";
            for(int i = 0;i<columnArray.size()-1;i++){
                sqlInsert=sqlInsert.concat(columnArray.get(i).getColumnName()+",");
            }
            sqlInsert = sqlInsert.concat(columnArray.get(columnArray.size() - 1).getColumnName() + ") values(");
            for(int i = 0;i<columnArray.size()-1;i++){
                sqlInsert=sqlInsert.concat("?,");
            }
            sqlInsert=sqlInsert.concat("?)");
            entityDAOImpl = entityDAOImpl.replace("insert into ******", sqlInsert);
            String parasWord = "";
            for(int i = 0;i<columnArray.size()-1;i++){
                String name = columnArray.get(i).getColumnName();
                parasWord=parasWord.concat("m"+typeChange.firstAlphToUp(tableName)+".get"+typeChange.firstAlphToUp(name)+"(),");
            }
            String lastName = columnArray.get(columnArray.size()-1).getColumnName();
            parasWord=parasWord.concat("m"+typeChange.firstAlphToUp(tableName)+".get"+typeChange.firstAlphToUp(lastName)+"()");
            entityDAOImpl = entityDAOImpl.replace("1.000000000001",parasWord);
            ioStream.outPutStream(finalDaoImplPath,entityDAOImpl);

            // 5、向service包中添加IEntityService类
            File iEntityService = new File(newpath+"MEntityDAOImpl.java");
            File myEntityService = new File(myeclpath+"MEntityDAOImpl.java");
            String entityService ="" ;
            if(iEntityService.exists()){ // 如果传入的是Idea中的路径
                entityService = ioStream.inputStream(newpath+"IMEntityService.java");
            }
            if(myEntityService.exists()){ // 如果传入的是MyEclipse的路径
                entityService = ioStream.inputStream(myeclpath+"IMEntityService.java");
            }
            String esPackage = "package " + typeChange.pathChangeToPackage(servicePath);
            entityService = entityService.replace(namePackage,esPackage);
            String esImport1 =  "import "+typeChange.pathChangeToPackage(entityPath)+"."+typeChange.firstAlphToUp(tableName);
            entityService = entityService.replace("//import 1",esImport1);
            String esEntity = typeChange.firstAlphToUp(tableName);
            entityService = entityService.replace("MEntity",esEntity);
            entityService = entityService.replace("mEntity",tableName);
            String entityServicePath = servicePath + "/I" + typeChange.firstAlphToUp(tableName)+"Service.java";
            ioStream.outPutStream(entityServicePath,entityService);


            // 6、向service.impl包中添加BookServiceImpl类
            File iEntityServiceImpl = new File(newpath+"MEntityDAOImpl.java");
            File myEntityServiceImpl = new File(myeclpath+"MEntityDAOImpl.java");
            String entityServiceImpl ="" ;
            if(iEntityServiceImpl.exists()){ // 如果传入的是Idea中的路径
                entityServiceImpl = ioStream.inputStream(newpath+"MEntityServiceImpl.java");
            }
            if(myEntityServiceImpl.exists()){ // 如果传入的是MyEclipse的路径
                entityServiceImpl = ioStream.inputStream(myeclpath+"MEntityServiceImpl.java");
            }
            String esiPackage = "package " + typeChange.pathChangeToPackage(serviceImplPath);
            entityServiceImpl = entityServiceImpl.replace(namePackage,esiPackage);
            String esiImport1 =  "import "+typeChange.pathChangeToPackage(daoPath)+"."+iEntityBaseDAOName;
            entityServiceImpl = entityServiceImpl.replace("//import 1",esiImport1);
            String esiImport2 =  "import "+typeChange.pathChangeToPackage(daoImplPath)+"."+typeChange.firstAlphToUp(tableName)+"DAOImpl";
            entityServiceImpl = entityServiceImpl.replace("//import 2",esiImport2);
            String esiImport3 =  "import "+typeChange.pathChangeToPackage(entityPath)+"."+typeChange.firstAlphToUp(tableName);
            entityServiceImpl = entityServiceImpl.replace("//import 3",esiImport3);
            String esiImport4 =  "import "+typeChange.pathChangeToPackage(servicePath)+".I"+typeChange.firstAlphToUp(tableName)+"Service";
            entityServiceImpl = entityServiceImpl.replace("//import 4",esiImport4);
            entityServiceImpl = entityServiceImpl.replace("MEntity",typeChange.firstAlphToUp(tableName));
            entityServiceImpl = entityServiceImpl.replace("IEntityDAO","I"+typeChange.firstAlphToUp(tableName)+"DAO");
            entityServiceImpl = entityServiceImpl.replace("mEntity",tableName);

            String entityServiceImplPath = serviceImplPath + "/" + typeChange.firstAlphToUp(tableName)+"ServiceImpl.java";
            ioStream.outPutStream(entityServiceImplPath,entityServiceImpl);

        }
        baseDao.closeAll();
    }
    private static String changePathToPac(String path){
        int index = path.indexOf("src");
        String packageName = path.substring(index + 4, path.length());
        packageName = packageName.replace("/",".");
        return packageName;
    }

    /**
     * 通过表名转化为public class 表名 语句
     * @param tableName
     * @return public class 表名
     */
    private static String changeTableToClass(String tableName){
        String word = null;
        // 通过表名提取出类名，并将类名的首字母改成大写
        String className=typeChange.firstAlphToUp(tableName); // 得到类名
        word = "public class "+className;
        return word;
    }

    /**
     * 生成实体类中的属性语句
     * @param columnArray
     * @return
     */
    private static String changeColumn(ArrayList<Column> columnArray){
        String wordColumn = null;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = typeChange.typeChange(columnArray).iterator();
        while (it.hasNext()){
            Column column =(Column) it.next();
            stringBuffer.append("private "+column.getColumnType()+" "+column.getColumnName()+"; //"+column.getRemarks()+"\r\n");
        }
        wordColumn = stringBuffer.toString();
        return  wordColumn;
    }

    /**
     * 生成实体类中的get set 方法语句
     * @param columnArray
     * @return
     */
    private static String createGetAndSet(ArrayList<Column> columnArray){
        String getSetWord = null;
        StringBuffer sb = new StringBuffer();
        TypeChange typeChange = new TypeChange();
        Iterator it = typeChange.typeChange(columnArray).iterator();
        while (it.hasNext()){
            Column column =(Column) it.next();
            sb.append("public "+column.getColumnType()+" get"+typeChange.firstAlphToUp(column.getColumnName())+"(){return "+column.getColumnName()+";}"+"\r\n");
            sb.append("public void set"+typeChange.firstAlphToUp(column.getColumnName())+"("+column.getColumnType()+" "+column.getColumnName()+"){\r\n");
            sb.append("this."+column.getColumnName()+"="+column.getColumnName()+";}\r\n");
        }
        getSetWord = sb.toString();
        return getSetWord;
    }
}
