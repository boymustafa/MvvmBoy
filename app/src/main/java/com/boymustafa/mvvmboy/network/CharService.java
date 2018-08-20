package com.boymustafa.mvvmboy.network;

import com.boymustafa.mvvmboy.model.CharacterResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CharService {

    @GET
    Observable<CharacterResponse> getChars(@Url String url);
}
