package com.jtcindia.wb03;

class LoginInfo{
	int loginId;
	String uname;
	String pwd;
	public LoginInfo(int loginId, String uname, String pwd) {
		super();
		this.loginId = loginId;
		this.uname = uname;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LoginInfi [loginId=" + loginId + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
}

class Address{
	String aid;
	String street;
	int pin;
	public Address(String aid, String street, int pin) {
		super();
		this.aid = aid;
		this.street = street;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", pin=" + pin + "]";
	}
	
}

class Employee implements Cloneable{
	int eid;
	String name;
	public Employee(int eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
		System.out.println("---- Employee(int,String)----");
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + "]";
	}
	
	void showClone() throws CloneNotSupportedException{
		Employee ep = (Employee) clone();
		System.out.println("this\t\t:"+this);
		System.out.println("Cloned Obj\t:"+ep);
		System.out.println(this==ep);
	}
}

class Student implements Cloneable{
	int sid;
	String name;
	long phone;
	Address studAddress;
	LoginInfo login;
	public Student(int sid, String name, long phone, Address studAddress, LoginInfo login) {
		super();
		this.sid = sid;
		this.name = name;
		this.phone = phone;
		this.studAddress = studAddress;
		this.login = login;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", phone=" + phone + ", studAddress=" + studAddress
				+ ", login=" + login + "]";
	}
	
	public Object clone() throws CloneNotSupportedException{
		Object obj = null;
		if(this instanceof Cloneable) {
			Address ad = new Address(this.studAddress.aid, this.studAddress.street, this.studAddress.pin);
			LoginInfo info = new LoginInfo(this.login.loginId, this.login.uname, this.login.pwd);
			obj = new Student(this.sid,this.name,this.phone,ad,info);
		}else {
			throw new CloneNotSupportedException(this.getClass().getName());
		}
		return obj;
	}
}
public class Jtc03{
	public static void main(String arg[]) throws CloneNotSupportedException {
		Employee emp1 = new Employee(88, "Manish");
		emp1.showClone();
		
		LoginInfo log = new LoginInfo(101, "somsree", "JTCIndia");
		
		Address ad = new Address("c-29", "Noida", 201301);
		
		Student st = new Student(999, "Som Prakash", 6526668, ad, log);
		System.out.println(st);
		Student stud = (Student)st.clone();
		System.out.println("\n*********After Cloning The Onject***********");
		System.out.println(st==stud);
		System.out.println(st.studAddress==stud.studAddress);
		System.out.println(st.login==stud.login);
		System.out.println(st);
		System.out.println(stud);
		
		System.out.println("====Modifying Data====");
		stud.sid=90909;
		stud.name="Manish";
		stud.phone=74587;
		stud.studAddress.street="Delhi";
		stud.login.uname="Jtc User";
		System.out.println(st);
		System.out.println(stud);
		
		
	}
}
