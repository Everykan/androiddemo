package com.everykan.resthelloworld;

import com.everykan.resthelloworld.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Comment>> getComments(@Path("id") int postId);









}
