package co.herovitamin.webservice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by kerry on 20/05/16.
 */
public interface API {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "client-id: Kerry T. Perez"
    })
    @GET("13lkatu1")
    Call<Void> getMethod();

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "client-id: Kerry T. Perez"
    })
    @POST("13lkatu1")
    Call<Void> postMethod(@Body SmallBody smallBody);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "client-id: Kerry T. Perez"
    })
    @POST("v2/573fc92d250000910b548b6d")
    Call<SmallBody> anotherPostMethod(@Body SmallBody smallBody);
}