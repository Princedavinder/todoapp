package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	private int id;
	private String user;
	@Size(min=10,message="Enter At least 10 charachter")
	private String desc;
	private Date targetDate;
	private boolean isdone;
	
	
	public Todo() {
		super();
	}
	public Todo(int id, String user, String desc, Date targetDate, boolean isdone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isdone = isdone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isIsdone() {
		return isdone;
	}
	public void setIsdone(boolean isdone) {
		this.isdone = isdone;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate + ", isdone="
				+ isdone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
