package Login;

public class User {
private String UserName,Password;
public String Name,phone,city_from,destination,num_seats;


public String getUserName() {
	return UserName;
}

public User(String Name, String phone, String city_from, String destination, String num_seats) {
	super();
	this.Name = Name;
	this.phone = phone;
	this.city_from = city_from;
	this.destination = destination;
	this.num_seats = num_seats;
}

public String getName() {
	return Name;
}

public void setName(String Name) {
	this.Name = Name;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getCity_from() {
	return city_from;
}

public void setCity_from(String city_from) {
	this.city_from = city_from;
}

public String getDestination() {
	return destination;
}

public void setDestination(String destination) {
	this.destination = destination;
}

public String getNum_seats() {
	return num_seats;
}

public void setNum_seats(String num_seats) {
	this.num_seats = num_seats;
}

public void setUserName(String UserName) {
	this.UserName = UserName;
}

public String getPassword() {
	return Password;
}
public void setPassword(String Password) {
	this.Password = Password;
}
public User(String UserName, String Password) {
	super();
	this.UserName = UserName;
	this.Password = Password;
}


}
