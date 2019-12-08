package me.bilalhaider.moviedatabase.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse{
	private String metascore;
	private String boxOffice;
	private String website;
	private String imdbRating;
	private String imdbVotes;
	private List<RatingsItem> ratings;
	@SerializedName("Runtime")
	private String runtime;
	private String language;
	@SerializedName("Rated")
	private String rated;
	private String production;
	@SerializedName("Released")
	private String released;
	private String imdbID;
	private String plot;
	@SerializedName("Director")
	private String director;
	@SerializedName("Title")
	private String title;
	private String actors;
	private String response;
	private String type;
	private String awards;
	private String dVD;
	@SerializedName("Year")
	private String year;
	private String poster;
	private String country;
	@SerializedName("Genre")
	private String genre;
	private String writer;

	public void setMetascore(String metascore){
		this.metascore = metascore;
	}

	public String getMetascore(){
		return metascore;
	}

	public void setBoxOffice(String boxOffice){
		this.boxOffice = boxOffice;
	}

	public String getBoxOffice(){
		return boxOffice;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setImdbRating(String imdbRating){
		this.imdbRating = imdbRating;
	}

	public String getImdbRating(){
		return imdbRating;
	}

	public void setImdbVotes(String imdbVotes){
		this.imdbVotes = imdbVotes;
	}

	public String getImdbVotes(){
		return imdbVotes;
	}

	public void setRatings(List<RatingsItem> ratings){
		this.ratings = ratings;
	}

	public List<RatingsItem> getRatings(){
		return ratings;
	}

	public void setRuntime(String runtime){
		this.runtime = runtime;
	}

	public String getRuntime(){
		return runtime;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setRated(String rated){
		this.rated = rated;
	}

	public String getRated(){
		return rated;
	}

	public void setProduction(String production){
		this.production = production;
	}

	public String getProduction(){
		return production;
	}

	public void setReleased(String released){
		this.released = released;
	}

	public String getReleased(){
		return released;
	}

	public void setImdbID(String imdbID){
		this.imdbID = imdbID;
	}

	public String getImdbID(){
		return imdbID;
	}

	public void setPlot(String plot){
		this.plot = plot;
	}

	public String getPlot(){
		return plot;
	}

	public void setDirector(String director){
		this.director = director;
	}

	public String getDirector(){
		return director;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setActors(String actors){
		this.actors = actors;
	}

	public String getActors(){
		return actors;
	}

	public void setResponse(String response){
		this.response = response;
	}

	public String getResponse(){
		return response;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setAwards(String awards){
		this.awards = awards;
	}

	public String getAwards(){
		return awards;
	}

	public void setDVD(String dVD){
		this.dVD = dVD;
	}

	public String getDVD(){
		return dVD;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setPoster(String poster){
		this.poster = poster;
	}

	public String getPoster(){
		return poster;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return genre;
	}

	public void setWriter(String writer){
		this.writer = writer;
	}

	public String getWriter(){
		return writer;
	}

/*	{
		"Title":"Rise of the Black Bat",
			"Year":"2012",
			"Rated":"N/A",
			"Released":"01 Apr 2012",
			"Runtime":"80 min",
			"Genre":"Action, Sci-Fi",
			"Director":"Brett Kelly",
			"Writer":"Trevor Payer (screenplay)",
			"Actors":"Jody Haucke, Richard Groen, Dixie Collins, Leo Frost",
			"Plot":"After a crime boss has Tony Quinn blinded by acid, Tony is given the ability to see in the dark like a bat. Them he takes the guise of the Black Bat to see to it that crime does not pay and that the scales of justice are balanced once more.",
			"Language":"English",
			"Country":"Canada",
			"Awards":"N/A",
			"Poster":"https://m.media-amazon.com/images/M/MV5BMjMwMTQ2OTU2MF5BMl5BanBnXkFtZTcwMDI0OTU4OA@@._V1_SX300.jpg",
			"Ratings":[
		{
			"Source":"Internet Movie Database",
				"Value":"1.2/10"
		}
   ],
		"Metascore":"N/A",
			"imdbRating":"1.2",
			"imdbVotes":"619",
			"imdbID":"tt2205589",
			"Type":"movie",
			"DVD":"N/A",
			"BoxOffice":"N/A",
			"Production":"TomCat Films LLC",
			"Website":"N/A",
			"Response":"True"
	}*/
}