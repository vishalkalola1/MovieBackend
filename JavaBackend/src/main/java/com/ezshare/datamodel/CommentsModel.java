package com.ezshare.datamodel;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CommentsModel")
public class CommentsModel {

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private Long id;
			
			@Column(name="ratings")
			private BigInteger ratings;
			
			@Column(name="title")
			private String title;
			
			@Column(name="comments")
			private String  comments;
			
			@ManyToOne
			@JoinColumn(name="fk_user")
			private UserModel userId;
			
			@ManyToOne
			@JoinColumn(name="fk_movie")
			private MovieModel movieId;
			
			@Column(name="createdon")
			private String  createdon;
			
			@Column(name="updatedon")
			private String  updatedon;
			
			

			public UserModel getUserId() {
				return userId;
			}

			public void setUserId(UserModel userId) {
				this.userId = userId;
			}

			public MovieModel getMovieId() {
				return movieId;
			}

			public void setMovieId(MovieModel movieId) {
				this.movieId = movieId;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public BigInteger getRatings() {
				return ratings;
			}

			public void setRatings(BigInteger ratings) {
				this.ratings = ratings;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getComments() {
				return comments;
			}

			public void setComments(String comments) {
				this.comments = comments;
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

			public CommentsModel() {
				
			}
			
			
			
}
