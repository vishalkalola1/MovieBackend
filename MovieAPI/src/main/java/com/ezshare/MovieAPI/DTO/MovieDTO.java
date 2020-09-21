package com.ezshare.MovieAPI.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.Node;
import org.springframework.stereotype.Repository;
import org.neo4j.driver.TransactionWork;

import com.ezshare.datamodel.MovieModel;

public class MovieDTO {


	private Long id;
	private String title;
	private String details;
	private String  imageLink;	
	private String  createdon;
	private String  updatedon;
	private String releaseDate;
	private String category;
	private String movieDirector;
	
	
	
	public MovieDTO(Long id, String title, String details, String imageLink, String createdon, String updatedon,
			String releaseDate, String category, String movieDirector) {
		this.id = id;
		this.title = title;
		this.details = details;
		this.imageLink = imageLink;
		this.createdon = createdon;
		this.updatedon = updatedon;
		this.releaseDate = releaseDate;
		this.category = category;
		this.movieDirector = movieDirector;
	}

	public MovieDTO() {

	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	public String getCreatedon() {
		return createdon;
	}
	
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	
	public String getUpdatedon() {
		return updatedon;
	}
	
	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public List<MovieModel> listAll(){
		Driver driver = GraphDatabase.driver("bolt://192.168.56.101:10687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		Transaction tx = session.beginTransaction();
		List<MovieModel> movies = new ArrayList<MovieModel>();

		//Result result = tx.run("MATCH (n {name: $varName }) RETURN n", parameters("varName", name));
		Result result = tx.run("MATCH (n:MovieModel) RETURN n");
		while (result.hasNext()) {
			Record row = result.next();
			Value value = row.get("n");
			Node node = value.asNode();
			Map<String, Object> properties = value.asEntity().asMap();
			MovieModel movie = new MovieModel();
			movie.setId(node.id());
			movie.setTitle(String.valueOf(properties.get("title")));
			movie.setDetails(String.valueOf(properties.get("details")));
			movie.setImageLink(String.valueOf(properties.get("imageLink")));
			movie.setReleaseDate(String.valueOf(properties.get("releaseDate")));
			movie.setCategory(String.valueOf(properties.get("category")));
			movie.setMovieDirector(String.valueOf(properties.get("movieDirector")));
			movie.setCreatedon(String.valueOf(properties.get("createdon")));
			movie.setUpdatedon(String.valueOf(properties.get("updatedon")));
			movies.add(movie);
		}
		return movies;
	}
	
	public List<MovieModel> getSearch(String name){
		Driver driver = GraphDatabase.driver("bolt://192.168.56.101:10687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		Transaction tx = session.beginTransaction();
		List<MovieModel> movies = new ArrayList<MovieModel>();

		//Result result = tx.run("MATCH (n {name: $varName }) RETURN n", parameters("varName", name));
		Result result = tx.run("MATCH (n:MovieModel) where n.title STARTS WITH \"" + name + "\" RETURN n");
		while (result.hasNext()) {
			Record row = result.next();
			Value value = row.get("n");
			Node node = value.asNode();
			Map<String, Object> properties = value.asEntity().asMap();
			MovieModel movie = new MovieModel();
			movie.setId(node.id());
			movie.setTitle(String.valueOf(properties.get("title")));
			movie.setDetails(String.valueOf(properties.get("details")));
			movie.setImageLink(String.valueOf(properties.get("imageLink")));
			movie.setReleaseDate(String.valueOf(properties.get("releaseDate")));
			movie.setCategory(String.valueOf(properties.get("category")));
			movie.setMovieDirector(String.valueOf(properties.get("movieDirector")));
			movie.setCreatedon(String.valueOf(properties.get("createdon")));
			movie.setUpdatedon(String.valueOf(properties.get("updatedon")));
			movies.add(movie);
		}
		return movies;
	}
	
	public MovieModel getDetails(long id){
		Driver driver = GraphDatabase.driver("bolt://192.168.56.101:10687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		Transaction tx = session.beginTransaction();
		List<MovieModel> movies = new ArrayList<MovieModel>();

		//Result result = tx.run("MATCH (n {name: $varName }) RETURN n", parameters("varName", name));
		Result result = tx.run("MATCH (n) WHERE ID(n) = " + id + " RETURN n");
		while (result.hasNext()) {
			Record row = result.next();
			Value value = row.get("n");
			Node node = value.asNode();
			Map<String, Object> properties = value.asEntity().asMap();
			MovieModel movie = new MovieModel();
			movie.setId(node.id());
			movie.setTitle(String.valueOf(properties.get("title")));
			movie.setDetails(String.valueOf(properties.get("details")));
			movie.setImageLink(String.valueOf(properties.get("imageLink")));
			movie.setReleaseDate(String.valueOf(properties.get("releaseDate")));
			movie.setCategory(String.valueOf(properties.get("category")));
			movie.setMovieDirector(String.valueOf(properties.get("movieDirector")));
			movie.setCreatedon(String.valueOf(properties.get("createdon")));
			movie.setUpdatedon(String.valueOf(properties.get("updatedon")));
			movies.add(movie);
		}
		return movies.get(0);
	}
	
	

	public MovieModel createMovies(final MovieModel movie) {
		Driver driver = GraphDatabase.driver("bolt://192.168.56.101:10687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		MovieModel res = session.writeTransaction(new TransactionWork<MovieModel>() {

			public MovieModel execute(Transaction tx) {

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("title", movie.getTitle());
				params.put("details", movie.getDetails());
				params.put("imageLink", movie.getImageLink());
				params.put("releaseDate", movie.getReleaseDate());
				params.put("category", movie.getCategory());
				params.put("movieDirector", movie.getMovieDirector());
				params.put("createdon", movie.getCreatedon());
				params.put("updatedon", movie.getUpdatedon());

				Result result = tx.run(("CREATE (n:MovieModel {title:$title, details: $details, imageLink: $imageLink, releaseDate:$releaseDate, category: $category, movieDirector: $movieDirector, createdon: $createdon, updatedon:$updatedon }) RETURN n"),params);
				Record record = result.single();
				Value value = record.get("n");
				Map<String, Object> properties = value.asEntity().asMap();
				MovieModel movie = new MovieModel();
				Node node = value.asNode();
				movie.setId(node.id());
				movie.setTitle(String.valueOf(properties.get("title")));
				movie.setDetails(String.valueOf(properties.get("details")));
				movie.setImageLink(String.valueOf(properties.get("imageLink")));
				movie.setReleaseDate(String.valueOf(properties.get("releaseDate")));
				movie.setCategory(String.valueOf(properties.get("category")));
				movie.setMovieDirector(String.valueOf(properties.get("movieDirector")));
				movie.setCreatedon(String.valueOf(properties.get("createdon")));
				movie.setUpdatedon(String.valueOf(properties.get("updatedon")));
				tx.commit();
				return movie;
			}
		});
		return res;
	}
}
