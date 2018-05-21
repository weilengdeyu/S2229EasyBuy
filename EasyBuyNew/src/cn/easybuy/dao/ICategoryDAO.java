package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Category;

/**2018年5月21日*/
//分类DAO
public interface ICategoryDAO {
  //01.写一个获取所有分类的方法
  public List<Category> findAllCategories() throws Exception;
}
