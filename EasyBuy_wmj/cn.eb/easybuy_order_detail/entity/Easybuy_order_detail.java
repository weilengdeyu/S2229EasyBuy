package  eb.easybuy_order_detail.entity;

public class Easybuy_order_detail{
private int id; //主键
private int orderid; //订单主键
private int productid; //商品主键
private int quantity; //数量
private float cost; //消费
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