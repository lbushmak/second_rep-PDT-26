package com.example.tests;

public class ContactData implements Comparable<ContactData> {

	public String firstname;
	public String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private GroupData group;
	private String address2;
	private String phone2;

	public ContactData() {

	}

	public ContactData(String firstname, String lastname, String address, String home, String mobile, String work,
			String email, String email2, String bday, String bmonth, String byear, GroupData group, String address2,
			String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group = group;
		this.address2 = address2;
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + getFirstname() + ", lastname=" + getLastname() + ", address=" + address
				+ ", home=" + home + ", mobile=" + mobile + ", work=" + work + ", email=" + email + ", email2=" + email2
				+ ", bday=" + bday + ", bmonth=" + bmonth + ", byear=" + byear + ", group=" + group + ", address2="
				+ address2 + ", phone2=" + phone2 + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		int result = this.getFirstname().toLowerCase().compareTo(other.getFirstname().toLowerCase());
		if (result == 0) {
			result = this.getLastname().compareTo(other.getLastname().toLowerCase());
		}

		return result;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((firstname == null) ? 0 :
		// firstname.hashCode());
		// result = prime * result + ((lastname == null) ? 0 :
		// lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (getFirstname() == null) {
			if (other.getFirstname() != null)
				return false;
		} else if (!getFirstname().equals(other.getFirstname()))
			return false;
		if (getLastname() == null) {
			if (other.getLastname() != null)
				return false;
		} else if (!getLastname().equals(other.getLastname()))
			return false;
		return true;
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAdress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withAdress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withGroup(GroupData group) {
		this.group = group;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public GroupData getGroup() {
		return group;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}