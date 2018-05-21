package cn.easybuy.entity;

import java.util.ArrayList;
import java.util.List;

/**2018年5月21日*/
//商品分类实体
public class Category {
  private int id;
  private String name;
  private int parentId;  //父分类编号
  private int type;  
  private String iconClass;//类型图片
  private List<Category> children=new ArrayList<Category>(); //子分类集合
  
public List<Category> getChildren() {
	return children;
}
public void setChildren(List<Category> children) {
	this.children = children;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getParentId() {
	return parentId;
}
public void setParentId(int parentId) {
	this.parentId = parentId;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getIconClass() {
	return iconClass;
}
public void setIconClass(String iconClass) {
	this.iconClass = iconClass;
}
  
}
