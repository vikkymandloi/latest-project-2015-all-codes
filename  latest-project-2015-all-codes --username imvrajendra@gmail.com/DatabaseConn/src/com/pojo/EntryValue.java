package com.pojo;

public class EntryValue {
	private String username;
	private String entryvalue;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEntryvalue() {
		return entryvalue;
	}
	public void setEntryvalue(String entryvalue) {
		this.entryvalue = entryvalue;
	}
	@Override
	public String toString() {
		return "EntryValue [username=" + username + ", entryvalue="
				+ entryvalue + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entryvalue == null) ? 0 : entryvalue.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		EntryValue other = (EntryValue) obj;
		if (entryvalue == null) {
			if (other.entryvalue != null)
				return false;
		} else if (!entryvalue.equals(other.entryvalue))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
