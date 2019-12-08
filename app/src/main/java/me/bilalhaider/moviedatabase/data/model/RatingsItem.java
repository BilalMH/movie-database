package me.bilalhaider.moviedatabase.data.model;

public class RatingsItem{
	private String value;
	private String source;

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}
}
