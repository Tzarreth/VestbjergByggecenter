package model;

public class Person {
	private String id;
	private String name;
	private String address;
	private String email;
	private String phone;
	
	public Person(String id, String name, String address, String email, String phone){
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return id;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phone;
	}
}
