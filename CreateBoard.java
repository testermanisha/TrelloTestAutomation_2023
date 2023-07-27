package TrelloBoardTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateBoard {
	
	@Test
	public void createABoard() {
		JSONObject request = new JSONObject();
		request.put("name", "TrelloBoard");
		System.out.println(request.toJSONString());
	
	given().
	log().all().
		body(request.toJSONString()).
	when().
		post("https://api.trello.com/1/boards/?name=TrelloBoard&key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486").
	then().
		assertThat().statusCode(200).
		assertThat().body("name", equalTo("TrelloBoard"))
		.log().all();
	}
	
		@Test
		public void createABoardWithInvalidKey() {
			JSONObject request = new JSONObject();
			request.put("name", "TrelloBoard");
			System.out.println(request.toJSONString());
		
		given().
		log().all().
			body(request.toJSONString()).
		when().
			post("https://api.trello.com/1/boards/?name=TrelloBoard&key=f9c0ab8d3777f674d486ac75&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486").
		then().
			assertThat().statusCode(401).
			log().all();
		}
		@Test
		public void createABoardWithInvalidToken() {
			JSONObject request = new JSONObject();
			request.put("name", "TrelloBoard");
			System.out.println(request.toJSONString());
		
		given().
		log().all().
			body(request.toJSONString()).
		when().
			post("https://api.trello.com/1/boards/?name=TrelloBoard&key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF").
		then().
			assertThat().statusCode(401).
			log().all();
		}
		@Test
		public void createABoardWithEmptyNameField() {
			JSONObject request = new JSONObject();
			request.put("name", "");
			System.out.println(request.toJSONString());
		
		given().
		log().all().
			body(request.toJSONString()).
		when().
			post("https://api.trello.com/1/boards/?name=&key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486").
		then().
			assertThat().statusCode(400).
			assertThat().statusLine("HTTP/1.1 400 Bad Request").
			assertThat().body("message", equalTo("invalid value for name")).
			assertThat().body("error", equalTo("ERROR")).
			log().all();
		}

}

