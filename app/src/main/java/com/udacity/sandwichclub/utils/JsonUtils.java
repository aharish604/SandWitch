package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        ArrayList<String> alsoKnownAs = new ArrayList<>();
        ArrayList<String> ingredients = new ArrayList<>();
        try {
            JSONObject result = new JSONObject(json);
            JSONObject name = result.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray aKa = name.getJSONArray("alsoKnownAs");

            for (int i = 0; i<aKa.length();i++){
                alsoKnownAs.add(aKa.getString(i));
            }

            String placeOfOrigin = result.getString("placeOfOrigin");
            String description = result.getString("description");
            String image = result.getString("image");

            JSONArray jsonArrayingredients = result.getJSONArray("ingredients");

            for (int i = 0;i<jsonArrayingredients.length();i++){
                ingredients.add(jsonArrayingredients.getString(i));
            }

            return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
