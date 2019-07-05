package com.everykan.resthelloworld;

import com.everykan.resthelloworld.model.Comment;
import com.everykan.resthelloworld.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

}
