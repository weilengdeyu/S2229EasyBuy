package  eb.easybuy_user_address.entity;
import java.util.Date;


public class Easybuy_user_address{
private int id; //主键id
private int userid; //用户主键
private String address; //地址
private Date createtime; //创建时间
private int isdefault; //是否是默认地址（1:是 0否）
private String remark; //备注
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public int getUserid(){return userid;}
public void setUserid(int userid){
this.userid=userid;}
public String getAddress(){return address;}
public void setAddress(String address){
this.address=address;}
public Date getCreatetime(){return createtime;}
public void setCreatetime(Date createtime){
this.createtime=createtime;}
public int getIsdefault(){return isdefault;}
public void setIsdefault(int isdefault){
this.isdefault=isdefault;}
public String getRemark(){return remark;}
public void setRemark(String remark){
this.remark=remark;}

}