package com.dev1024.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * GsonUtils
 * 
 * Created by John on 2014-5-19
 */
public class GsonUtils {

	protected static final String TAG = "GsonUtils";

	/**
	 * Serialize a json string
	 * 
	 * @param json
	 * @param classOf
	 *            the target class
	 * @return
	 */
	public static <T> T getModel(String json, Class<T> classOf) {
		if (isJson(json)) {
			try {
				return new Gson().fromJson(json, classOf);
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
				LogUtils.e(TAG, e.getMessage());
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Return value of a node.
	 * 
	 * @param json
	 * @param node
	 * @return
	 */
	public static String getResult(String json, String node) {
		if (!isJson(json))
			return null;
		JSONTokener jsonParser = new JSONTokener(json);
		String result;
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.nextValue();
			result = jsonObject.getString(node);
		} catch (JSONException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	/**
	 * Return whether the string is a json format.
	 * 
	 * @param json
	 * @return
	 */
	public static boolean isJson(String json) {
		if (json == null || json.length() == 0)
			return false;
		try {
			new JsonParser().parse(json);
			return true;
		} catch (JsonParseException e) {
			return false;
		}
	}

}
