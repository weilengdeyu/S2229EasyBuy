package cn.mysqltools;

/**
 * JDBC方法
 *
 * Created by Shinelon on 2017/7/23.
 */
public class TableOperate {
    /**
     * 添加路径，将数据库中的表转换成类
     * @param path 生成类的路径
     * @throws Exception
     */
    public void tableToClass(String path) throws Exception{
        TableToClass.tableToClass(path);
    }


}
