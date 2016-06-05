package easyrun.bean;

public class FreePicBean	//免费照片Bean
{
	private int eventID = -1;
	private String userID = "";
	private String picID = "";
	private int downloadCnt = 0;	//下载次数
	private long upTime = -1;
	private String userName = "";	//用户昵称
	private String eventName = "";	//赛事名
	private String headImgUrl =""; //上传该照片的用户头像链接
	
	public int getEventID() {return eventID; }

	public void setEventID(int eventID)
	{
		this.eventID = eventID;
	}

	public String getPicID()
	{
		return picID;
	}

	public void setPicID(String picID)
	{
		this.picID = picID;
	}

	public int getDownloadCnt()
	{
		return downloadCnt;
	}

	public void setDownloadCnt(int downloadCnt)
	{
		this.downloadCnt = downloadCnt;
	}

	public long getUpTime()
	{
		return upTime;
	}

	public void setUpTime(long upTime)
	{
		this.upTime = upTime;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public void setUserID(String userID){
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}
}
