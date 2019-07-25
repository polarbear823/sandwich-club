package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static String TAG = JsonUtils.class.getSimpleName();
    public static Sandwich parseSandwichJson(String json) {
        if (json != null && !"".equals(json)) {
            try {
                Sandwich sandwich = new Sandwich();
                JSONObject jsonObj = new JSONObject(json);
                JSONObject nameObj = jsonObj.optJSONObject("name");
                if (nameObj != null) {
                    sandwich.setMainName(nameObj.optString("mainName"));
                    JSONArray alsoKnownAsArray = nameObj.optJSONArray("alsoKnownAs");
                    List<String> alsoKnownAsList = new ArrayList<>();
                    if (alsoKnownAsArray != null && alsoKnownAsArray.length() != 0) {
                        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                            alsoKnownAsList.add((String) alsoKnownAsArray.get(i));
                        }
                    }
                    sandwich.setAlsoKnownAs(alsoKnownAsList);
                }
                sandwich.setDescription(jsonObj.optString("description"));
                sandwich.setImage(jsonObj.optString("image"));
                JSONArray ingredientsArray = jsonObj.optJSONArray("ingredients");
                List<String> ingredientsList = new ArrayList<>();
                if (ingredientsArray != null && ingredientsArray.length() != 0) {
                    for (int i = 0; i < ingredientsArray.length(); i++) {
                        ingredientsList.add((String) ingredientsArray.get(i));
                    }
                }
                sandwich.setIngredients(ingredientsList);
                sandwich.setPlaceOfOrigin(jsonObj.optString("placeOfOrigin"));
                return sandwich;
            } catch (JSONException e) {
                Log.e(TAG, "parseSandwichJson - parse json error: " + e);
            }
    }
        return null;
    }
}
