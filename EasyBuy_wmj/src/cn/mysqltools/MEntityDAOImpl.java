package cn.mysqltools;

//import 1;
//import 2;
//import 3;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MEntityDAOImpl extends BaseDAO implements IEntityDAO{

	@Override
	public List<MEntity> findAll() throws Exception {
		
		List<MEntity> list=new ArrayList<MEntity>();
		String sql="select * from ******";
		ResultSet rs = executeQuery(sql);
		while(rs.next()){
			MEntity mEntity=new MEntity();
			String word1 = null;
			list.add(mEntity);
		}
		closeAll();
		return list;
	}

	@Override
	public boolean addMEntity(MEntity mEntity) throws Exception {
		boolean flag=false;
		String sql="insert into ******";
		Object[] paras={1.000000000001};
		int count = executeUpdate(sql, paras);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

}
