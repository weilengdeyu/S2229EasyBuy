package  eb.easybuy_order.entity;
import java.util.Date;


public class Easybuy_order{
private int id; //����
private int userid; //�û�����
private String loginname; //
private String useraddress; //�û���ַ
private Date createtime; //����ʱ��
private int cost; //������
private String serialnumber; //������
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