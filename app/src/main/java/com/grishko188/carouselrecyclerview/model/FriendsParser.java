package com.grishko188.carouselrecyclerview.model;

import com.umojo.gson.JsonArray;
import com.umojo.gson.JsonElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 26.10.2015.
 */
public class FriendsParser extends AbstractParser<List<Friend>> {

    private Random random;

    @Override
    public List<Friend> parseJSON(String data) throws Exception {
        JsonArray jsonFriends = parseAsArray(data);
        if (jsonFriends != null) {
            List<Friend> friends = new ArrayList<>();
            for (JsonElement element : jsonFriends) {
                Friend item = GSON.fromJson(element, Friend.class);
                item.setOnline(generateRandomOnlineState());
                item.setFullName(String.format("%s %s", item.getFirstName(), item.getLastName()));
                friends.add(item);
            }
            return friends;
        }
        return Collections.emptyList();
    }

    private boolean generateRandomOnlineState() {
        if (random == null)
            random = new Random();
        return random.nextBoolean();
    }
}
