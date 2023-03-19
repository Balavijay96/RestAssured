package com.RestAssured;

public class RequestChaining {
	
	String name;
	int age;
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public RequestChaining setName(String name) {
		this.name = name;
		return this;
	}


	public RequestChaining setAge(int age) {
		this.age = age;
		return this;
	}
	
	public void data() {
			System.out.println("Name is "+ name + " Age is "+ age + " Verified");
	}


	public static void main(String[] args) {
		
		RequestChaining r= new RequestChaining();
		//r.setAge(27);
		//r.setName("Balasubramaniyan");
		//r.data();
		
		r.setAge(27).setName("Bala").data();
		
		
	}

}
