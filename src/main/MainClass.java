package main;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.NaverDAOImpl;
import dto.NaverDTO;
import naver.ApiExamSearchBlog;

public class MainClass {
	public static void jsonParsing3() {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("지역을 입력해주세요 > ");
		String a = sc.next();

//		String jsonString = ApiExamSearchBlog.main(a);
//
//		// 가장 큰 JSONObject를 가져옵니다.
//		JSONObject jObject = new JSONObject(jsonString);
//		// 배열을 가져옵니다.
//		JSONArray jArray = jObject.getJSONArray("posts");
//
//		// 배열의 모든 아이템을 출력합니다.
//		for (int i = 0; i < jArray.length(); i++) {
//			JSONObject obj = jArray.getJSONObject(i);
//			String title = obj.getString("title");
//			String url = obj.getString("url");
//			boolean draft = obj.getBoolean("draft");
//			System.out.println("title(" + i + "): " + title);
//			System.out.println("url(" + i + "): " + url);
//			System.out.println("draft(" + i + "): " + draft);
//			System.out.println();
//		}
		NaverDTO dto = new NaverDTO();
		NaverDAOImpl nd = new NaverDAOImpl();
	String str = ApiExamSearchBlog.main(a);
	System.out.println(str);
	JsonParser Parser = new JsonParser();
	JsonObject jsonObj = (JsonObject) Parser.parse(str);
	JsonArray ol = (JsonArray) jsonObj.get("items");
	for (int i = 0; i < ol.size(); i++) {
		JsonObject object = (JsonObject) ol.get(i);
		String title = object.get("title").getAsString();
		String originallink = object.get("originallink").getAsString();
		String link = object.get("link").getAsString();
		String description = object.get("description").getAsString();
		String pubDate = object.get("pubDate").getAsString();
		dto.setTitle(title);
		dto.setOriginallink(originallink);
		dto.setLink(link);
		dto.setDescription(description);
		dto.setPubDate(pubDate);
		}
	}		
}
