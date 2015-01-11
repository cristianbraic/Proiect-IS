package beans;

public class AccountDetail {
private String username;
private int accno;
private double amount;
private String gender;
private String address;
private String status;
private String emailid;
private String phoneno;

public AccountDetail(String username, int accno, double amount, String gender,
		String address, String status, String emailid, String phoneno) {
	super();
	this.username = username;
	this.accno = accno;
	this.amount = amount;
	this.gender = gender;
	this.address = address;
	this.status = status;
	this.emailid = emailid;
	this.phoneno = phoneno;
}
public AccountDetail() {
	super();
}
public AccountDetail(String username, double amount, String gender,
		String address, String status, String emailid, String phoneno) {
	super();
	this.username = username;
	this.amount = amount;
	this.gender = gender;
	this.address = address;
	this.status = status;
	this.emailid = emailid;
	this.phoneno = phoneno;
}
public AccountDetail(int accno) {
	super();
	this.accno = accno;
}

public AccountDetail(double amount) {
	super();
	this.amount = amount;
}

public AccountDetail(String status) {
	super();
	this.status = status;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}

}
