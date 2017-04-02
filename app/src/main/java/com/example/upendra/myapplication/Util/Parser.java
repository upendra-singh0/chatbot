package com.example.upendra.myapplication.Util;

import com.example.upendra.myapplication.Model.Message;

import org.json.JSONObject;

/**
 * Created by Upendra on 4/2/2017.
 */

public class Parser {

    public static Message ParseMessage (JSONObject object)
    {
        Message message= new Message();

        try {

            message.setSuccess(object.getInt("success"));
            message.setErrorMessage(object.optString("errorMessage", ""));

            JSONObject m = object.getJSONObject("message");
            message.setChatBotName(m.optString("chatBotName", ""));
            message.setChatBotID(m.optInt("chatBotID"));
            message.setMessage(m.optString("message", ""));
            message.setEmotion(m.optString("emotions",null));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
