package DTOPackage;

public class Admin {

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", admincontact=" + admincontact
				+ ", adminmail=" + adminmail + ", adminpass=" + adminpass + "]";
	}
	private int adminid;
	private String adminname;
	private long admincontact;
	private String adminmail;
	private String adminpass;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public long getAdmincontact() {
		return admincontact;
	}
	public void setAdmincontact(long admincontact) {
		this.admincontact = admincontact;
	}
	public String getAdminmail() {
		return adminmail;
	}
	public void setAdminmail(String adminmail) {
		this.adminmail = adminmail;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	
	
	
}
