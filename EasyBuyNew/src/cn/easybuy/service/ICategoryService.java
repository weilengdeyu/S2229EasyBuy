package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.Category;

/**2018��5��21��*/
public interface ICategoryService {
	 //01.дһ����ȡ���з���ķ���
	  public List<Category> findAllCategories() throws Exception;
}
