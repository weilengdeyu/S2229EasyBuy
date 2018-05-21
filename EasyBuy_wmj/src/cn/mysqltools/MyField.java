package cn.mysqltools;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

/**
 * 提取传入对象的属性，属性名和属性值
 *
 * Created by Shinelon on 2017/7/24.
 */
public class MyField {
    /**
     * 获取传入对象的数据类型
     * @param object 传入对象
     * @return 数据类型集合
     */
    static  String [] getFieldTypes(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        String [] fieldTypes = new String[fields.length];
        for(int i = 0;i<fields.length;i++){
            String str = fields[i].getType().toString();
            int index1 = str.lastIndexOf(".");
            str = str.substring(index1+1,str.length()); // 获取数据类型
            fieldTypes[i] = str;
        }
        return fieldTypes;
    }

    /**
     * 获取传入对象的数据名集合
     * @param object 传入的对象
     * @return 数据名
     */
    static  String [] getFieldNames(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        String [] fieldNames = new String[fields.length];
        for(int i = 0;i<fields.length;i++) {
            fieldNames[i] = fields[i].getName(); // 将数据名保存到数组中
        }
        return fieldNames;
    }

    /**
     * 获取传入对象的数据值集合
     * @param object 传入的对象
     * @return 数据值集合
     */
    static  Object [] getFieldValues(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        String [] fieldType = new String[fields.length];
        Object [] fieldValues = new Object[fields.length];
        for(int i = 0;i<fields.length;i++){
            String str = fields[i].getType().toString();
            int index1 = str.lastIndexOf(".");
            str = str.substring(index1+1,str.length()); // 获取数据类型
            fieldType[i] = str;
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(object);
                if(fieldType[i].equals("Date")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String str1 = simpleDateFormat.format(o);
                    fieldValues[i]=str1;
                }else{
                    fieldValues[i]=o;
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return fieldValues;
    }
}
