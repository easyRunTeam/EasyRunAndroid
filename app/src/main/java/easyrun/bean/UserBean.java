package easyrun.bean;

import java.sql.Date;

public class UserBean
{
	public static enum Gender
	{
		male,female;
	}
	private String userID = "";
	private String headImgUrl =""; 	// �û�ͷ������
	private String userName = "";	//�ǳ�
	private String account = "";	//�û���
	private String password = "";	//����
	private String realName = "";	//��ʵ����
	private String celphone = "";
	private String email = "";
	private Date birth;
	private Gender gender;
	private String identityCard = "";	//���֤��
	private String identityPic = "";	//���֤�ϴ�ͼ�Ĵ洢·��
	private String bloodType = "";		//Ѫ��
	private String address = "";		//סַ��ʡ+��+��/��
	private float height;				//���
	private float weight;				//����
	private String urgencyContact = ""; //������ϵ������
	private String urgencyPhone = "";	//������ϵ�˵绰
	
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getBirth()
	{
		return birth;
	}
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	public Gender getGender()
	{
		return gender;
	}
	public void setGender(int gender)
	{
		this.gender = Gender.values()[gender];
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getCelphone()
	{
		return celphone;
	}
	public void setCelphone(String celphone)
	{
		this.celphone = celphone;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getIdentityPic() {
		return identityPic;
	}
	public void setIdentityPic(String identityPic) {
		this.identityPic = identityPic;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getUrgencyContact() {
		return urgencyContact;
	}
	public void setUrgencyContact(String urgencyContact) {
		this.urgencyContact = urgencyContact;
	}
	public String getUrgencyPhone() {
		return urgencyPhone;
	}
	public void setUrgencyPhone(String urgencyPhone) {
		this.urgencyPhone = urgencyPhone;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
