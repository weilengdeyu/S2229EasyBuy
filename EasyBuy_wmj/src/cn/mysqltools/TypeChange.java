package cn.mysqltools;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 将集合中保存的数据类型进行转换
 * Created by Shinelon on 2017/7/23.
 */
public class TypeChange {
    public ArrayList<Column> typeChange(ArrayList<Column> columns){
        Iterator it = columns.iterator();
        while (it.hasNext()){
            Column column =(Column) it.next();
            if(column.getColumnType().equals("varchar")){ // 将varchar类型数据转换成char类型的数据
                column.setColumnType("String");
            }
            if(column.getColumnType().equals("char")){ // 将char类型数据转换成char类型的数据
                column.setColumnType("String");
            }
            if(column.getColumnType().equals("bigint")){
                column.setColumnType("int");
            }
            if(column.getColumnType().equals("datetime")){
                column.setColumnType("Date");
            }
            if(column.getColumnType().equals("date")){
                column.setColumnType("Date");
            }
            if(column.getColumnType().equals("decimal")){
                column.setColumnType("BigDecimal");
            }
        }
        return columns;
    }
    public String firstAlphToUp(String word){
        String firstAlph=word.substring(0,1).toUpperCase();
        word=firstAlph.concat(word.substring(1));
        return word;
    }
    public String pathChangeToPackage(String path){
        String newPackage = "";
        int index = path.indexOf("src");
        newPackage = path.substring(index+4,path.length());
        newPackage=newPackage.replace("/",".");
        return newPackage;
    }
}
