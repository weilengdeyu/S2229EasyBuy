package cn.easybuy.entity;

import cn.mysqltools.TableOperate;

/**2018��5��17��*/
public class MyMain {

	public static void main(String[] args) throws Exception {
		
		TableOperate tool=new TableOperate();
		
		tool.tableToClass("src/cn.school");

	}

}
