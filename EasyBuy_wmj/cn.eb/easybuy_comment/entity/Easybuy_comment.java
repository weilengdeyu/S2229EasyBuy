package  eb.easybuy_comment.entity;
import java.util.Date;


public class Easybuy_comment{
private int id; //
private String cname; //
private String comment; //
private Date ctime; //
private int productid; //
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public String getCname(){return cname;}
public void setCname(String cname){
this.cname=cname;}
public String getComment(){return comment;}
public void setComment(String comment){
this.comment=comment;}
public Date getCtime(){return ctime;}
public void setCtime(Date ctime){
this.ctime=ctime;}
public int getProductid(){return productid;}
public void setProductid(int productid){
this.productid=productid;}

}