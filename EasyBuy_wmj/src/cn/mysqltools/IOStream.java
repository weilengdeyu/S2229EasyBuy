package cn.mysqltools;

import java.io.*;

/**
 * Created by Shinelon on 2017/7/23.
 */
public class IOStream {
    public String inputStream(String path){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte [] bytes = new byte[1024];
        int data= 0;
        try {
            data = fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer str = new StringBuffer();
        while(data !=-1){
             str = str.append(new String(bytes,0,data));
            try {
                data = fis.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
    public void outPutStream(String path,String words){
        OutputStream os = null;
        try {
            os = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte [] bytes = words.getBytes();
        try {
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
