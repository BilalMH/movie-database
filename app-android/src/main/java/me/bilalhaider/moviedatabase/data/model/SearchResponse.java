package me.bilalhaider.moviedatabase.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResponse{
	@SerializedName("Response")
	private String response;
	@SerializedName("totalResults")
	private String totalResults;
	@SerializedName("Search")
	private ArrayList<SearchItemResponse> search;

	public void setResponse(String response){
		this.response = response;
	}

	public String getResponse(){
		return response;
	}

	public void setTotalResults(String totalResults){
		this.totalResults = totalResults;
	}

	public String getTotalResults(){
		return totalResults;
	}

	public void setSearch(ArrayList<SearchItemResponse> search){
		this.search = search;
	}

	public ArrayList<SearchItemResponse> getSearch(){
		return search;
	}
}