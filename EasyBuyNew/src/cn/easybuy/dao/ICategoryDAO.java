package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Category;

/**2018��5��21��*/
//����DAO
public interface ICategoryDAO {
  //01.дһ����ȡ���з���ķ���
  public List<Category> findAllCategories() throws Exception;
}
