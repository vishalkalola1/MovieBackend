package com.ezshare.MovieAPI.Service;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezshare.MovieAPI.DTO.CommentsDTO;
import com.ezshare.MovieAPI.DTO.MovieDTO;
import com.ezshare.Questionnaire.services.CommentsDAO;
import com.ezshare.Questionnaire.services.MovieDAO;
import com.ezshare.Questionnaire.services.UserDAO;
import com.ezshare.datamodel.CommentsModel;
import com.ezshare.datamodel.MovieModel;
import com.ezshare.datamodel.UserModel;

@Path("/CommentService")
public class CommentService {

	
	@Inject
	CommentsDAO commentDAO;
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	MovieDAO movieDAO;
	
	@POST
	@Path("/addcomment")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response insertMovie(@RequestBody CommentsDTO comment) {
		CommentsModel commentmodel = new CommentsModel();
		commentmodel.setRatings(comment.getRatings());
		commentmodel.setTitle(comment.getTitle());
		
		UserModel user = userDAO.getById(comment.getUserId().toString());
		MovieModel movie = movieDAO.getById(comment.getMovieId().toString());
		
		commentmodel.setComments(comment.getComments());
		commentmodel.setMovieId(movie);
		commentmodel.setUserId(user);
		
		return Response.ok().entity(comment).build();
	}
}
