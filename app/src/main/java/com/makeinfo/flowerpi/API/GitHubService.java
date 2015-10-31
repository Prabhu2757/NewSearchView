package com.makeinfo.flowerpi.API;

import com.makeinfo.flowerpi.model.Login;
import com.makeinfo.flowerpi.model.User;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;


public interface GitHubService {
    @FormUrlEncoded
    @POST("/index.php/api/login/")
    Call<Login> getLogin(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("/index.php/api/login/")
    Call<Login> getForgotPassword(@FieldMap Map<String, String> params);
}
