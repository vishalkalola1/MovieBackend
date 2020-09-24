package com.ezshare.MovieAPI.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezshare.MovieAPI.DTO.MovieDTO;
import com.ezshare.Questionnaire.services.MovieDAO;
import com.ezshare.datamodel.MovieModel;


//vishal
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
		movieDTO.setCreatedon(ft.format(dNow));
		movieDTO.setUpdatedon(ft.format(dNow));
		
		MovieModel model = new MovieModel();
		model.setId(model.getId());
		model.setTitle(movieDTO.getTitle());
		model.setDetails(movieDTO.getDetails());
		model.setImageLink(movieDTO.getImageLink());
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
	
	@GET
	@Path("/searchMovie")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response search(@QueryParam("name") String name) {
		MovieDTO dto = new MovieDTO();
		return Response.ok().entity(dto.getSearch(name)).build();
	}
	
	@GET
	@Path("/details")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response details(@QueryParam("id") long id) {
		MovieDTO dto = new MovieDTO();
		return Response.ok().entity(dto.getDetails(id)).build();
	}
	
	@POST
	@Path("/getTopMovies")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response homeAPI(@RequestBody Map<String, String> details) {
		String userid = details.get("userid");
		System.out.println(Response.created(URI.create("getMovie/?s=" + userid)).build());
		return null;
		
	}
	
	
	@GET
	@Path("/getMovie")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getMovieData(@QueryParam("s") String userid) throws IOException {
		 URL url = new URL("http://localhost:4000/api/tws/getSeenMovie");
	        

		 String jsonInputString = "{userid\":" + userid +"}";

		 

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);

	        try(OutputStream os = conn.getOutputStream()) {
			    byte[] input = jsonInputString.getBytes("utf-8");
			    os.write(input, 0, input.length);			
			}
	        
	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

	        StringBuilder sb = new StringBuilder();
	        for (int c; (c = in.read()) >= 0;)
	            sb.append((char)c);
	        String response = sb.toString();
	        System.out.println(response);
	        return Response.status(200).entity(response).build();
	}
}
