package  eb.easybuy_user.entity;

public class Easybuy_user{
private int id; //主键
private String loginname; //登录名
private String username; //用户名
private String password; //密码
private int sex; //性别(1:男 0：女)
private String identitycode; //身份证号
private String email; //邮箱
private String mobile; //手机
private int type; //类型（1：后台 0:前台）
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