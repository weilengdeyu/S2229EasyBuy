package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.ICategoryDAO;
import cn.easybuy.dao.impl.CategoryDAOImpl;
import cn.easybuy.entity.Category;
import cn.easybuy.service.ICategoryService;

/**2018年5月21日*/
public class CategoryServiceImpl implements ICategoryService {

	//植入DAO
	ICategoryDAO categoryDAO=new CategoryDAOImpl();
	@Override
	public List<Category> findAllCategories() throws Exception {
		return categoryDAO.findAllCategories();
	}

}
