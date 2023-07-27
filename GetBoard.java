package TrelloBoardTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBoard {
	@Test
	public void getABoard() {
		given()
	    .log().all()
		.when()
		.get("https://api.trello.com/1/boards/64c23a9d479e01d337ebba0a?key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486")
		.then()
		.statusCode(200)
		.log().all()
		.assertThat().body("id", equalTo("64c23a9d479e01d337ebba0a"))
		.assertThat().body("name", equalTo("TrelloTestManagement"))
		.assertThat()
		.header("Content-Type","application/json; charset=utf-8");
		
	}
	
	@Test
	public void getABoardWithInvalidId() {
		given()
	    .log().all()
		.when()
		.get("https://api.trello.com/1/boards/64c23a9d479e01d3bba0a?key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486")
		.then()
		.statusCode(400)
		.log().all();
	}
	@Test
	public void getABoardWithInvalidToken() {
		given()
	    .log().all()
		.when()
		.get("https://api.trello.com/1/boards/64c23a9d479e01d3bba0a?key=f9c0ab8d3777f674d486ac759dd9104e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF94")
		.then()
		.statusCode(401)
		.log().all();
	}
	@Test
	public void getABoardWithInvalidKey() {
		given()
	    .log().all()
		.when()
		.get("https://api.trello.com/1/boards/64c23a9d479e01d3bba0a?key=f9c0ab8d3777f674d486ac759dd94e&token=ATTA359aaabe444d2f956f1811577f1b51133e41734e934e947f20ef62d7d0d9b2532AFF9486")
		.then()
		.statusCode(401)
		.log().all();
	}
	}


