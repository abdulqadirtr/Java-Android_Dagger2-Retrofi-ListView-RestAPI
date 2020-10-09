package app.easylink.retrofit_api_marvel.network;

import java.util.List;

import app.easylink.retrofit_api_marvel.model.Marvel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientApi {

    @GET("/demos/marvel/")
    Call<List<Marvel>> getHeroes();

}
