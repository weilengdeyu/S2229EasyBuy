package  eb.easybuy_order_detail.entity;

public class Easybuy_order_detail{
private int id; //����
private int orderid; //��������
private int productid; //��Ʒ����
private int quantity; //����
private float cost; //����
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public int getOrderid(){return orderid;}
public void setOrderid(int orderid){
this.orderid=orderid;}
public int getProductid(){return productid;}
public void setProductid(int productid){
this.productid=productid;}
public int getQuantity(){return quantity;}
public void setQuantity(int quantity){
this.quantity=quantity;}
public float getCost(){return cost;}
public void setCost(float cost){
this.cost=cost;}

}