package com.happgo.common.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable{
	
	private static final long serialVersionUID = -5583166689057373909L;
	
	private int id;
	private String text;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
