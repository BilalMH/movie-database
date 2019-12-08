package me.bilalhaider.moviedatabase.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse{
	@SerializedName("Response")
	private String response;
	@SerializedName("totalResults")
	private String totalResults;
	@SerializedName("Search")
	private List<SearchItemResponse> search;

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

	public void setSearch(List<SearchItemResponse> search){
		this.search = search;
	}

	public List<SearchItemResponse> getSearch(){
		return search;
	}
}