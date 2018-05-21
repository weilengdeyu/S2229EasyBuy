package cn.easybuy.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDAO;
import cn.easybuy.dao.ICategoryDAO;
import cn.easybuy.entity.Category;

/**2018Äê5ÔÂ21ÈÕ*/
public class CategoryDAOImpl extends BaseDAO implements ICategoryDAO{

	@Override
	public List<Category> findAllCategories() throws Exception {
		List<Category> list=new ArrayList<Category>();
		String sql="select * from easybuy_product_category";
		ResultSet rs = executeQuery(sql);
		while(rs.next()){
			Category category=new Category();
			category.setName(rs.getString("name"));
			category.setId(rs.getInt("id"));
			category.setParentId(rs.getInt("parentId"));
			list.add(category);
		}
		return list;
	}

}
