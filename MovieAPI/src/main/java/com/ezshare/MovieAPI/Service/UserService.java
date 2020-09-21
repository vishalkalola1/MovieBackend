package com.ezshare.MovieAPI.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezshare.MovieAPI.DTO.UserDTO;
import com.ezshare.Questionnaire.services.AdderessDAO;
import com.ezshare.Questionnaire.services.ContactDAO;
import com.ezshare.Questionnaire.services.UserDAO;
import com.ezshare.datamodel.AddressModel;
import com.ezshare.datamodel.ContactModel;
import com.ezshare.datamodel.UserModel;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@Path("/user")
public class UserService {
	
	@Inject
	UserDAO userDAO;
	
	@Inject 
	AdderessDAO addressDAO;
	
	@Inject
	ContactDAO contactDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJson() {
	    Map<String, String> testMap = new HashMap<>();
	    testMap.put("username", "vishal1");
	    testMap.put("password", "123");

	    return Response.status(200).entity(testMap).build();
	}
	
	@GET
	@Path("/getuser")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getuser() throws IOException {
//		java.util.List<User> users = userDAO.getAll();
//		return Response.ok().entity(users).build();

		 URL url = new URL("http://localhost:8080/apiman-gateway/ezshare/authenticateUser/1.0?apikey=0429b102-d063-4094-bcf7-5bf0149d5974");
	        

		 String jsonInputString = "{\"username\": \"vishal1\", \"password\": \"123\"}";

		 

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Authorization", "bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJxSXVnV1owWXJWQlhPVTN1bm9pRV9iT2g4ZkpscDE2ZzExZ01xN1ZIem1rIn0.eyJqdGkiOiJiMWE2YWI1OS04MjdjLTQ0MjItOGY3Yi1lZWQzMzE4NTYzNWEiLCJleHAiOjE1OTkzNDA5NzAsIm5iZiI6MCwiaWF0IjoxNTk5MzQwNjcwLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvdGVzdC1vaWRjIiwiYXVkIjoidGVzdC1hcHBsaWNhdGlvbiIsInN1YiI6ImFiNjU3YzI2LTMwZDEtNDgyYi1hMDI2LTk2MmQ2YzdkYzZjYiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3QtYXBwbGljYXRpb24iLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiJiMmVmNTc1NS1hMjkwLTRjYWQtODNhYi05NTY3YWY4OTNiN2UiLCJhY3IiOiIxIiwiY2xpZW50X3Nlc3Npb24iOiI0Y2FlNzI0Mi1kMTY2LTRmNWItOWVhYy1jNDM4YjllZDE3NDEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMS8qIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJ2aWV3LXByb2ZpbGUiXX19LCJuYW1lIjoidGVzdCIsInByZWZlcnJlZF91c2VybmFtZSI6InRlc3QiLCJmYW1pbHlfbmFtZSI6InRlc3QifQ.cEJiYpPUu6o5Y_l4M_HBlnGM1oLCP0ZZrtldWefuIWU7Ams9NpEnrp8eC2f2H29Q73-4lqC4BwmJzNUFe_85jxOUoFG_Iv7ThqC6arGU6O6m5mpTXqH9PcvjQKFqkZ841x3OyqoZVk_tUu2ig6DcPcAEopZrOfcE1oaI9yEwONJaH0a7jxh8DyycL4RlDMAotoYvugIVgBdRPEZ2CJKbXbhnf37uFLJVsvIrZqlElnrMZDLEzKL8U4ZIMD0RXJcUOT0CbHDLxrsnmHafIeVeavV4Ne_WQYeJ4u6XB9WyjziDFUFmzwReDUDN85XoKncZ56A4o2mq7HpJKoRZNfnULw");
//	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
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
	
	@POST
	@Path("/createUser")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response create(@RequestBody UserDTO user) {
		
		if (user.getUsername() == null || user.getPassword() == null) {
			return Response.serverError().build();
		}
		
		List<UserModel> listUserTemp = userDAO.authenticate("username", user.getUsername(), "password", user.encrypt());
		
		if (listUserTemp.size() == 0) {
			
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy HH:mm:ss");
			System.out.println(ft.format(dNow));
			user.setCreatedon(ft.format(dNow));
			user.setUpdatedon(ft.format(dNow));
			
			UserModel usermodel = new UserModel();
			usermodel.setUsername(user.getUsername());
			usermodel.setPassword(user.encrypt());
			usermodel.setRole(user.getRole());
			usermodel.setCreatedon(user.getCreatedon());
			usermodel.setUpdatedon(user.getUpdatedon());
			
			ContactModel contact = new ContactModel();
			contact.setBirthdate(user.getBirthdate());
			contact.setEmail(user.getEmail());
			contact.setGender(user.getGender());
			contact.setUser(usermodel);
			contact.setCreatedon(user.getCreatedon());
			contact.setUpdatedon(user.getUpdatedon());
			
			AddressModel address =  new AddressModel();
			address.setCountry(user.getCountry());
			address.setArea(user.getArea());
			address.setCity(user.getCity());
			address.setStreet(user.getStreet());
			address.setPincode(user.getPincode());
			address.setUser(usermodel);
			address.setCreatedon(user.getCreatedon());
			address.setUpdatedon(user.getUpdatedon());
						
			try {
				userDAO.create(usermodel);
				contactDAO.create(contact);
				addressDAO.create(address);
				
				user.setId(usermodel.getId());
				
				return Response.status(Status.OK).entity(user).build();
			} catch (Exception e) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("error", "username is already exist.");
				return Response.status(Status.NOT_ACCEPTABLE).entity(map).build();
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", "username is already exist.");
			return Response.status(Status.UNAUTHORIZED).entity(map).build();
		}
	}
	
	@POST
	@Path("/authenticateUser")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response authenticate(@RequestBody UserDTO user) {
		if (user.getUsername() == null || user.getPassword() == null) {
			return Response.serverError().build();
		}
		
		List<UserModel> listUsermodel = userDAO.authenticate("username", user.getUsername(), "password", user.encrypt());
		if (listUsermodel.size() > 0) {
			
			UserModel usermodel = listUsermodel.get(0);
			if(usermodel.getUsername().equalsIgnoreCase(user.getUsername()) && usermodel.decrypt().equalsIgnoreCase(user.getPassword())) {
				
				ContactModel contact = contactDAO.getByOtherColumnId(usermodel.getId(), "fk_user").get(0);
				AddressModel address = addressDAO.getByOtherColumnId(usermodel.getId(), "fk_user").get(0);
				
				user.setId(usermodel.getId());
				user.setRole(usermodel.getRole());
				user.setUsername(usermodel.getUsername());
				user.setGender(contact.getGender());
				user.setBirthdate(contact.getBirthdate());
				user.setEmail(contact.getEmail());
				user.setCountry(address.getCountry());
				user.setArea(address.getArea());
				user.setCity(address.getCity());
				user.setStreet(address.getStreet());
				user.setPincode(address.getPincode());
				user.setCreatedon(usermodel.getCreatedon());
				user.setUpdatedon(usermodel.getUpdatedon());
				
				return Response.status(Status.OK).entity(user).build();
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("error", "Wrong Credentials");
				return Response.status(Status.UNAUTHORIZED).entity(map).build();
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", "Wrong Credentials");
			return Response.status(Status.UNAUTHORIZED).entity(map).build();
		}
	}
}
