package com.jtcindia.gpt03;


//LoginInfo class
class LoginInfo {

 int loginId;
 String uname;
 String pwd;

 // Constructor of LoginInfo
 public LoginInfo(int loginId, String uname, String pwd) {

     // Calls Object class constructor
     super();

     // Assign constructor values to instance variables
     this.loginId = loginId;
     this.uname = uname;
     this.pwd = pwd;
 }

 // Overrides Object.toString()
 @Override
 public String toString() {

     // Returns LoginInfo data in String form
     return "LoginInfi [loginId=" + loginId
             + ", uname=" + uname
             + ", pwd=" + pwd + "]";
 }
}


//Address class
class Address {

 String aid;
 String street;
 int pin;

 // Constructor of Address
 public Address(String aid, String street, int pin) {

     // Calls Object class constructor
     super();

     // Assign constructor values to instance variables
     this.aid = aid;
     this.street = street;
     this.pin = pin;
 }

 // Overrides Object.toString()
 @Override
 public String toString() {

     // Returns Address data in String form
     return "Address [aid=" + aid
             + ", street=" + street
             + ", pin=" + pin + "]";
 }
}


//Employee implements Cloneable
class Employee implements Cloneable {

 int eid;
 String name;

 // Employee constructor
 public Employee(int eid, String name) {

     super();

     this.eid = eid;
     this.name = name;

     System.out.println("---- Employee(int,String)----");
 }

 // Overrides Object.toString()
 @Override
 public String toString() {

     return "Employee [eid=" + eid
             + ", name=" + name + "]";
 }


 // Method to demonstrate cloning
 void showClone() throws CloneNotSupportedException {

     // clone() creates a new Employee object
     //
     // clone() returns Object
     // So we cast Object -> Employee
     Employee ep = (Employee) clone();

     // 'this' means the current/original Employee object
     System.out.println("this\t\t:" + this);

     // 'ep' means the newly cloned Employee object
     System.out.println("Cloned Obj\t:" + ep);

     // Compares references of original and cloned objects
     //
     // this → original object
     // ep   → cloned object
     //
     // They are different objects
     // Therefore output = false
     System.out.println(this == ep);
 }
}


//Student implements Cloneable
class Student implements Cloneable {

 int sid;
 String name;
 long phone;

 // Student contains a reference to Address object
 Address studAddress;

 // Student contains a reference to LoginInfo object
 LoginInfo login;


 // Student constructor
 public Student(
         int sid,
         String name,
         long phone,
         Address studAddress,
         LoginInfo login) {

     super();

     this.sid = sid;
     this.name = name;
     this.phone = phone;

     // Stores Address object reference
     this.studAddress = studAddress;

     // Stores LoginInfo object reference
     this.login = login;
 }


 // Overrides Object.toString()
 @Override
 public String toString() {

     return "Student [sid=" + sid
             + ", name=" + name
             + ", phone=" + phone
             + ", studAddress=" + studAddress
             + ", login=" + login + "]";
 }


 // Our own clone() method
 public Object clone() throws CloneNotSupportedException {

     // Initially obj contains null
     Object obj = null;


     // Checks whether current object implements Cloneable
     //
     // Student implements Cloneable,
     // so this condition is true.
     if (this instanceof Cloneable) {


         // Creates a NEW Address object.
         //
         // We are copying the values from the
         // ORIGINAL Address object.
         Address ad = new Address(
                 this.studAddress.aid,
                 this.studAddress.street,
                 this.studAddress.pin
         );


         // Creates a NEW LoginInfo object.
         //
         // We are copying the values from the
         // ORIGINAL LoginInfo object.
         LoginInfo info = new LoginInfo(
                 this.login.loginId,
                 this.login.uname,
                 this.login.pwd
         );


         // Creates a NEW Student object.
         //
         // sid, name and phone are copied.
         //
         // ad   = NEW Address
         // info = NEW LoginInfo
         //
         // Therefore this is DEEP CLONING.
         obj = new Student(
                 this.sid,
                 this.name,
                 this.phone,
                 ad,
                 info
         );

     } else {

         // If object is not Cloneable,
         // cloning is not allowed.
         throw new CloneNotSupportedException(
                 this.getClass().getName()
         );
     }


     // Return the newly created Student object
     return obj;
 }
}


//Main class
public class gpt03 {

 public static void main(String arg[])
         throws CloneNotSupportedException {


     // Create first Employee object
     Employee emp1 = new Employee(88, "Manish");

     // Call cloning method
     emp1.showClone();


     // Create LoginInfo object
     LoginInfo log = new LoginInfo(
             101,
             "somsree",
             "JTCIndia"
     );


     // Create Address object
     Address ad = new Address(
             "c-29",
             "Noida",
             201301
     );


     // Create Student object
     //
     // st contains references to:
     // studAddress → ad
     // login       → log
     Student st = new Student(
             999,
             "Som Prakash",
             6526668,
             ad,
             log
     );


     // Print original Student
     System.out.println(st);


     // Clone Student
     //
     // clone() returns Object
     // so we cast Object -> Student
     Student stud = (Student) st.clone();


     System.out.println(
             "\n*********After Cloning The Object***********"
     );


     // Compare original Student and cloned Student
     //
     // st   → original Student
     // stud → new Student
     //
     // Different objects → false
     System.out.println(st == stud);


     // Compare Address references
     //
     // st.studAddress   → original Address
     // stud.studAddress → NEW Address
     //
     // Different objects → false
     System.out.println(
             st.studAddress == stud.studAddress
     );


     // Compare LoginInfo references
     //
     // st.login   → original LoginInfo
     // stud.login → NEW LoginInfo
     //
     // Different objects → false
     System.out.println(
             st.login == stud.login
     );


     // Print original Student
     System.out.println(st);

     // Print cloned Student
     System.out.println(stud);


     System.out.println("====Modifying Data====");


     // Modify cloned Student's sid
     stud.sid = 90909;


     // Modify cloned Student's name
     stud.name = "Manish";


     // Modify cloned Student's phone
     stud.phone = 74587;


     // Modify the Address belonging to cloned Student
     //
     // Because cloned Student has its OWN Address,
     // original Student's Address is not affected.
     stud.studAddress.street = "Delhi";


     // Modify LoginInfo belonging to cloned Student
     //
     // Because cloned Student has its OWN LoginInfo,
     // original Student's LoginInfo is not affected.
     stud.login.uname = "Jtc User";


     // Print original Student
     System.out.println(st);

     // Print modified cloned Student
     System.out.println(stud);
 }
}