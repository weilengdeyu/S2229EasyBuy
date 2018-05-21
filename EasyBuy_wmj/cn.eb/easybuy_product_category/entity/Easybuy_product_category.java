package  eb.easybuy_product_category.entity;

public class Easybuy_product_category{
private int id; //主键
private String name; //名称
private int parentid; //父级目录id
private int type; //级别(1:一级 2：二级 3：三级)
private String iconclass; //图标
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public String getName(){return name;}
public void setName(String name){
this.name=name;}
public int getParentid(){return parentid;}
public void setParentid(int parentid){
this.parentid=parentid;}
public int getType(){return type;}
public void setType(int type){
this.type=type;}
public String getIconclass(){return iconclass;}
public void setIconclass(String iconclass){
this.iconclass=iconclass;}

}