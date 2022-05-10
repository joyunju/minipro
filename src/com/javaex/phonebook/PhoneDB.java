// 이름(name), 휴대전화(hp), 회사번호(company)

package com.javaex.phonebook;

public class PhoneDB {

	// 필드
	private String name;
	private String hp;
	private String company;

	// 생성자
	public PhoneDB() {
		super();
	}

	public PhoneDB(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	// 메소드 - gs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// 메소드 - 일반
	@Override
	public String toString() {
		return "Phonedb [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

}
