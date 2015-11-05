package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	private String groupname;
	private String header;
	private String footer;

	public GroupData() {

	}

	public GroupData(String groupname, String header, String footer) {
		this.groupname = groupname;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "GroupData [groupname=" + groupname + ", header=" + header + ", footer=" + footer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((groupname == null) ? 0 :
		// groupname.hashCode());
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
		GroupData other = (GroupData) obj;
		if (groupname == null) {
			if (other.groupname != null)
				return false;
		} else if (!groupname.equals(other.groupname))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.groupname.toLowerCase().compareTo(other.groupname.toLowerCase());
	}

	public GroupData withGroupname(String groupname) {
		this.groupname = groupname;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

}