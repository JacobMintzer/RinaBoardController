package com.example.rinaboardcontroller;
import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RinaFace {

	private String Name;
	private ArrayList<Boolean> Coords;
	private int Rows;


	@NonNull
	@Override
	public String toString() {
		return Name.toString();
	}

	public RinaFace(JSONObject jsObj) throws JSONException {
		Name=(String)jsObj.get("name");
		JSONArray jsArray = jsObj.getJSONArray("coords");
		for (int i=0;i< jsArray.length();i++){
			Coords.add((Boolean)jsArray.get(i));
		}

	}

	public RinaFace(String name, String url){
		Name=name;
		String decodedValue=decodeValue(url).split("fill=")[1].split("&q1")[0];
		System.out.println(decodedValue);
	}


	public RinaFace(String name, ArrayList<Boolean> coords ){
		Name=name;
		Coords=coords;
	}


	public static String decodeValue(String value) {
		try {
			return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex.getCause());
		}
	}

}
