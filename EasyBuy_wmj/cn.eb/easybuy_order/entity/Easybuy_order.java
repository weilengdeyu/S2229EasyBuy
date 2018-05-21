package  eb.easybuy_order.entity;
import java.util.Date;


public class Easybuy_order{
private int id; //主键
private int userid; //用户主键
private String loginname; //
private String useraddress; //用户地址
private Date createtime; //创建时间
private int cost; //总消费
private String serialnumber; //订单号
private String phone; //
private String number; //
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public int getUserid(){return userid;}
public void setUserid(int userid){
this.userid=userid;}
public String getLoginname(){return loginname;}
public void setLoginname(String loginname){
this.loginname=loginname;}
public String getUseraddress(){return useraddress;}
public void setUseraddress(String useraddress){
this.useraddress=useraddress;}
public Date getCreatetime(){return createtime;}
public void setCreatetime(Date createtime){
this.createtime=createtime;}
public int getCost(){return cost;}
public void setCost(int cost){
this.cost=cost;}
public String getSerialnumber(){return serialnumber;}
public void setSerialnumber(String serialnumber){
this.serialnumber=serialnumber;}
public String getPhone(){return phone;}
public void setPhone(String phone){
this.phone=phone;}
public String getNumber(){return number;}
public void setNumber(String number){
this.number=number;}

}