package beans;

public class TransactionDetail {
private String username;
private int fromacct;
private int toacct;
private double transamount;
private String shwdate;
public TransactionDetail(String username, int fromacct, int toacct,
		double transamount, String shwdate) {
	super();
	this.username = username;
	this.fromacct = fromacct;
	this.toacct = toacct;
	this.transamount = transamount;
	this.shwdate = shwdate;
}
public TransactionDetail() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getFromacct() {
	return fromacct;
}
public void setFromacct(int fromacct) {
	this.fromacct = fromacct;
}
public int getToacct() {
	return toacct;
}
public void setToacct(int toacct) {
	this.toacct = toacct;
}
public double getTransamount() {
	return transamount;
}
public void setTransamount(double transamount) {
	this.transamount = transamount;
}
public String getShwdate() {
	return shwdate;
}
public void setShwdate(String shwdate) {
	this.shwdate = shwdate;
}

}
