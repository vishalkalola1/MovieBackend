# MovieBackend

# Introduction
- **Purpose** 
   - The main purpose of this document is to provide a working example of a Software Requirements Specification (SRS) in the technical aspects.

- **Scope** 
  - This document specifies requirements for a simple website for Movie Ratings. The application allows users to: 
      1. Login
      2. Signup 
      3. Search Movie by name
      4. Recommndation, Last seen and New Movie Tabs
      5. Show movie details 
      6. Review and Ratings Real Time
      7. Some upcoming movie poster

- **Product perspective**
  - **System interfaces**
      - The website runs in the latest version of Chrome or Firefox browser on Windows, Linux and Mac. 

  - **User interfaces**
    - The Website GUI provides Search, Recommendation Movie, buttons, GridView, Scrolling, Easy to use components allowing for easy control by a keyboard and a mouse. 

  - **Hardware interfaces**
  
      | Type | Configuration |
      |---|---|
      |**Operating system**|Windows, Mac, Linux|
      |**CPU**|Core 2 Quad Q6600 at 2.4 GHz or AMD Phenom 9850 at 2.5 GHz with virtualization technology|
      |**Memory**|8 GB RAM|
      |**Free space**|65 GB of free space|
      |**Graphics hardware**|DirectX 10-compatible GPU: GeForce 9800GT 1GB or ATI Radeon HD 4870 1GB|
      |**Sound hardware**|DirectX 10 compatible sound card|

  - **Website interfaces**
      | Type | Configuration |
      |---|---|
      |**Language & framework**|React js, Java, Spring, Hibernate, junit, Maven, Jersey, log4j, inject, postgres, neo4j, MongoDB, Socket.io, Node js, JSON|
      |**Tools**|VSCode, Eclipse, Postgress, Neo4j, Mongodb, Docker, Docker Container, ApacheDS, APIMAN, Tomcat9.0 server, Jenkins, Sonarqube, Nexus, Virtualbox, Chrome browser|

  - **Website Flow**
  
    <a href="https://github.com/vishalkalola1/MovieFrontend/blob/master/Images/Flow.png"><img src="https://github.com/vishalkalola1/MovieFrontend/blob/master/Images/Flow.png" title=""/></a>
    
    
# Github
| Repository | URL |
| --- | ---|
| Movie Rating Frontend | https://github.com/vishalkalola1/MovieFrontend.git |
| Movie backend Java | https://github.com/vishalkalola1/MovieBackend.git |
| Movie backend Node js | https://github.com/vishalkalola1/MovieBackendNode.git |

## Note: MovieWebsite.postman_collection.json Import into Postman for test API in your Local setup.

# API List

- Login API
  | Key | Value |
  | --- | --- |
  | URL | http://localhost:8080/MovieAPI/rest/user/authenticateUser |
  | Method | POST |
  | Request | JSON { "password":"123", "username":"vishal1"} | 
  | Response | 200 { "id": 44, "username": "vishal1", "password": "123", "birthdate": "2020-09-06", "gender": "male", "email": "vishalkalola196@gmail.com", "country": "France", "area": "val-de-marne", "city": "vitry", "street": "50", "pincode": "94800", "role": "user", "createdon": "06/20/2020 23:20:33", "updatedon": "06/20/2020 23:20:33" }|

- SignUp API
  | Key | Value |
  | --- | --- |
  | URL | http://localhost:8080/MovieAPI/rest/user/createUser |
  | Method | POST |
  | Request | JSON {"password":"123","username":"vishal3","birthdate":"12/05/1994","gender":"male","email":"vishalkalola196@gmail.com","country":"france","area":"villejuif","city":"val-de-marne","street":"50, avenue karl marx","pincode":"94800","role":"user"} | 
  | Response | 200 { "id": 44, "password":"123","username":"vishal3","birthdate":"12/05/1994","gender":"male","email":"vishalkalola196@gmail.com","country":"france","area":"villejuif","city":"val-de-marne","street":"50, avenue karl marx","pincode":"94800","role":"user"} |

- Home API
  | Key | Value |
  | --- | --- |
  | URL | http://localhost:8080/MovieAPI/rest/MovieService/getTopMovies |
  | Method | POST |
  | Request | JSON { "userid":"1" } |
  | Response | 200 {"recommondationmovie":[{"id":0,"title":"Harry potter Philosopher's Stone","details":"Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel.","imageLink":"https://www.linkpicture.com/q/harrypotter1.jpg","releaseDate":"26 June 1997","category":"Science Friction","movieDirector":"J. K. Rowling","createdon":"26/02/2020 01:02:29","updatedon":"26/02/2020 01:02:29"}],"lastSeenMovies":[{"id":0,"title":"Harry potter Philosopher's Stone","details":"Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. ","imageLink":"https://www.linkpicture.com/q/harrypotter1.jpg","releaseDate":"26 June 1997","category":"Science Friction","movieDirector":"J. K. Rowling","createdon":"26/02/2020 01:02:29","updatedon":"26/02/2020 01:02:29"}],"newMovie":[{"id":6,"title":"Avenger age of ultron","details":"This is good movie","imageLink":"https://www.linkpicture.com/q/avenger.png","releaseDate":"12/05/1994","category":"Science Friction","movieDirector":"vishal KALOLA","createdon":"20/29/2020 12:29:16","updatedon":"20/29/2020 12:29:16"}]} |

- Search API
  | Key | Value |
  | --- | --- |
  | URL | http://localhost:8080/MovieAPI/rest/MovieServicesearchMovie?name=Av |
  | Method | GET |
  | Response | 200 [{"id":4,"title":"Avenger","details":"This is good movie","imageLink":"https://www.linkpicture.com/q/avenger.png","releaseDate":"12/05/1994","category":"Science Friction","movieDirector":"vishal KALOLA","createdon":"20/27/2020 12:27:44","updatedon":"20/27/2020 12:27:44"},{"id":5,"title":"Avenger end game","details":"This is good movie","imageLink":"https://www.linkpicture.com/q/avenger.png","releaseDate":"12/05/1994","category":"Science Friction","movieDirector":"vishal KALOLA","createdon":"20/28/2020 12:28:46","updatedon":"20/28/2020 12:28:46"}] |

- Details API
  | Key | Value |
  | --- | --- |
  | URL | http://localhost:8080/MovieAPI/rest/MovieService/detailsMovie?id=4 |
  | Method | GET |
  | Response | 200 {"id":4,"title":"Avenger","details":"This is good movie","imageLink":"https://www.linkpicture.com/q/avenger.png","releaseDate":"12/05/1994","category":"Science Friction","movieDirector":"vishal KALOLA","createdon":"20/27/2020 12:27:44","updatedon":"20/27/2020 12:27:44"} |
