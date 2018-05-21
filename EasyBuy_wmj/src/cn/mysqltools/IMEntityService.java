package cn.mysqltools;

//import 1;
import java.util.List;

public interface IMEntityService {
	   public List<MEntity> findAll() throws Exception;

	   public boolean addMEntity(MEntity mEntity) throws Exception;
}
