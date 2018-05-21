package cn.mysqltools;

//import 1;
//import 2;
//import 3;
//import 4;

import java.util.List;

public class MEntityServiceImpl implements IMEntityService{
	
	IEntityDAO dao=new MEntityDAOImpl();
	
	
	@Override
	public List<MEntity> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public boolean addMEntity(MEntity mEntity) throws Exception {
		return dao.addMEntity(mEntity);
	}

	
}
