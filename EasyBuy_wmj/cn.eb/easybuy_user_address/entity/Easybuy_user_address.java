package  eb.easybuy_user_address.entity;
import java.util.Date;


public class Easybuy_user_address{
private int id; //����id
private int userid; //�û�����
private String address; //��ַ
private Date createtime; //����ʱ��
private int isdefault; //�Ƿ���Ĭ�ϵ�ַ��1:�� 0��
private String remark; //��ע
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