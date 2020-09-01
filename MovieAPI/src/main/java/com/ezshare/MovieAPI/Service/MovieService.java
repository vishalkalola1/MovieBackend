package com.ezshare.MovieAPI.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezshare.MovieAPI.DTO.MovieDTO;
import com.ezshare.MovieAPI.DTO.UserDTO;
import com.ezshare.Questionnaire.services.MovieDAO;
import com.ezshare.datamodel.AddressModel;
import com.ezshare.datamodel.ContactModel;
import com.ezshare.datamodel.MovieModel;
import com.ezshare.datamodel.UserModel;

@Path("/MovieService")
public class MovieService {

	@Inject
	MovieDAO movieDAO;
	
	@POST
	@Path("/addmovie")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response insertMovie(@RequestBody MovieDTO movieDTO) {
		
		
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy HH:mm:ss");
		System.out.println(ft.format(dNow));
		movieDTO.setCreatedon(ft.format(dNow));
		movieDTO.setUpdatedon(ft.format(dNow));
		
		MovieModel model = new MovieModel();
		model.setId(model.getId());
		model.setTitle(movieDTO.getTitle());
		model.setDetails(movieDTO.getDetails());
		model.setImageLink(movieDTO.getCreatedon());
		model.setReleaseDate(movieDTO.getReleaseDate());
		model.setCategory(movieDTO.getCategory());
		model.setMovieDirector(movieDTO.getMovieDirector());
		model.setCreatedon(movieDTO.getCreatedon());
		model.setUpdatedon(movieDTO.getUpdatedon());
		
		MovieModel tempModel = movieDTO.createMovies(model);
		
		return Response.status(Status.OK).entity(tempModel).build();
	}
	
	@GET
	@Path("/getAllMovie")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getuser() {
//		List<MovieModel> users = movieDAO.getAll();
		
		MovieDTO dto = new MovieDTO();
		return Response.ok().entity(dto.listAll()).build();
	}
	
}