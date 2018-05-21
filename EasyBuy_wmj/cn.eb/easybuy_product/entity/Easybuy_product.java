package  eb.easybuy_product.entity;

public class Easybuy_product{
private int id; //主键
private String name; //名称
private String description; //描述
private int price; //价格
private int stock; //库存
private int categorylevel1id; //分类1
private int categorylevel2id; //分类2
private int categorylevel3id; //分类3
private String filename; //文件名称
private int isdelete; //是否删除(1：删除 0：未删除)
private int pic; //图片
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public String getName(){return name;}
public void setName(String name){
this.name=name;}
public String getDescription(){return description;}
public void setDescription(String description){
this.description=description;}
public int getPrice(){return price;}
public void setPrice(int price){
this.price=price;}
public int getStock(){return stock;}
public void setStock(int stock){
this.stock=stock;}
public int getCategorylevel1id(){return categorylevel1id;}
public void setCategorylevel1id(int categorylevel1id){
this.categorylevel1id=categorylevel1id;}
public int getCategorylevel2id(){return categorylevel2id;}
public void setCategorylevel2id(int categorylevel2id){
this.categorylevel2id=categorylevel2id;}
public int getCategorylevel3id(){return categorylevel3id;}
public void setCategorylevel3id(int categorylevel3id){
this.categorylevel3id=categorylevel3id;}
public String getFilename(){return filename;}
public void setFilename(String filename){
this.filename=filename;}
public int getIsdelete(){return isdelete;}
public void setIsdelete(int isdelete){
this.isdelete=isdelete;}
public int getPic(){return pic;}
public void setPic(int pic){
this.pic=pic;}

}