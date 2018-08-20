package com.boymustafa.mvvmboy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResponse {

    @SerializedName("results")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }
}
