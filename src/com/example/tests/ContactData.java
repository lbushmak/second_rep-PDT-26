package com.example.tests;

public class ContactData implements Comparable<ContactData> {

	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public GroupData group;
	public String address2;
	public String phone2;

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
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", home="
				+ home + ", mobile=" + mobile + ", work=" + work + ", email=" + email + ", email2=" + email2 + ", bday="
				+ bday + ", bmonth=" + bmonth + ", byear=" + byear + ", group=" + group + ", address2=" + address2
				+ ", phone2=" + phone2 + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		int result = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		if (result == 0) {
			result = this.lastname.compareTo(other.lastname.toLowerCase());
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

}