package  eb.easybuy_product_category.entity;

public class Easybuy_product_category{
private int id; //����
private String name; //����
private int parentid; //����Ŀ¼id
private int type; //����(1:һ�� 2������ 3������)
private String iconclass; //ͼ��
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