package  eb.easybuy_user.entity;

public class Easybuy_user{
private int id; //����
private String loginname; //��¼��
private String username; //�û���
private String password; //����
private int sex; //�Ա�(1:�� 0��Ů)
private String identitycode; //���֤��
private String email; //����
private String mobile; //�ֻ�
private int type; //���ͣ�1����̨ 0:ǰ̨��
public int getId(){return id;}
public void setId(int id){
this.id=id;}
public String getLoginname(){return loginname;}
public void setLoginname(String loginname){
this.loginname=loginname;}
public String getUsername(){return username;}
public void setUsername(String username){
this.username=username;}
public String getPassword(){return password;}
public void setPassword(String password){
this.password=password;}
public int getSex(){return sex;}
public void setSex(int sex){
this.sex=sex;}
public String getIdentitycode(){return identitycode;}
public void setIdentitycode(String identitycode){
this.identitycode=identitycode;}
public String getEmail(){return email;}
public void setEmail(String email){
this.email=email;}
public String getMobile(){return mobile;}
public void setMobile(String mobile){
this.mobile=mobile;}
public int getType(){return type;}
public void setType(int type){
this.type=type;}

}