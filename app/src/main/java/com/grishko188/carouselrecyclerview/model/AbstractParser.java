package com.grishko188.carouselrecyclerview.model;


import com.umojo.gson.Gson;
import com.umojo.gson.JsonArray;
import com.umojo.gson.JsonElement;
import com.umojo.gson.JsonObject;
import com.umojo.gson.JsonParser;

import java.math.BigDecimal;


public abstract class AbstractParser<T> {

    protected static final Gson GSON = new Gson();
    private JsonParser parser;

    public abstract T parseJSON(String data) throws Exception;

    public T fromJson(JsonElement element, Class<T> clazz) {
        return GSON.fromJson(element, clazz);
    }

    protected boolean hasNotNull(JsonObject object, String tag) {
        assert object != null;
        return object.has(tag) && !object.get(tag).isJsonNull();
    }

    protected JsonElement parse(String data) {
        return parser().parse(data);
    }

    protected JsonObject parseAsObject(String data) {
        return parse(data).getAsJsonObject();
    }

    protected JsonArray parseAsArray(String data) {
        return parse(data).getAsJsonArray();
    }

    protected String optString(JsonObject element, String tag, String value) {
        if (hasNotNull(element, tag)) {
            return element.get(tag).getAsString();
        }
        return value;
    }

    protected int optInt(JsonObject element, String tag, int value) {
        if (hasNotNull(element, tag)) {
            return element.get(tag).getAsInt();
        }
        return value;
    }

    protected double optDouble(JsonObject element, String tag, double value) {
        if (hasNotNull(element, tag)) {
            return element.get(tag).getAsDouble();
        }
        return value;
    }

    protected BigDecimal optBigDecimal(JsonObject element, String tag, BigDecimal value) {
        if (hasNotNull(element, tag)) {
            return element.get(tag).getAsBigDecimal();
        }
        return value;
    }

    protected boolean optBoolean(JsonObject element, String tag, boolean value) {
        if (hasNotNull(element, tag)) {
            return element.get(tag).getAsBoolean();
        }
        return value;
    }

    protected String toJson(Object object) {
        return GSON.toJson(object);
    }

    private JsonParser parser() {
        if (parser == null) {
            parser = new JsonParser();
        }
        return parser;
    }

    protected Boolean parseBoolean(String value) {
        if ("0".equalsIgnoreCase(value)) {
            return Boolean.FALSE;
        } else if ("1".equalsIgnoreCase(value)) {
            return Boolean.TRUE;
        }
        return Boolean.parseBoolean(value);
    }

}
