package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.Category;

/**2018年5月21日*/
public interface ICategoryService {
	 //01.写一个获取所有分类的方法
	  public List<Category> findAllCategories() throws Exception;
}
