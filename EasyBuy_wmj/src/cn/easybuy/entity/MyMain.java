package cn.easybuy.entity;

import cn.mysqltools.TableOperate;

/**2018Äê5ÔÂ17ÈÕ*/
public class MyMain {

	public static void main(String[] args) throws Exception {
		
		TableOperate tool=new TableOperate();
		
		tool.tableToClass("src/cn.school");

	}

}
