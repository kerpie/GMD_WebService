package co.herovitamin.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<SmallBody> {

    Retrofit retrofit;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
//                .baseUrl("http://requestb.in/")
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        api = retrofit.create(API.class);

    }

    @Override
    protected void onResume() {
        super.onResume();

//        Call<Simple> call = api.getMethod(new SmallBody("Kerry T. Perez"));
//        Call<Void> call = api.getMethod();
//        Call<Void> call = api.postMethod(new SmallBody("Kerry T. Perez"));
        Call<SmallBody> call = api.anotherPostMethod(new SmallBody("Kerry T. Perez"));
        call.enqueue(this);
    }


//    @Override
//    public void onResponse(Call<Void> call, Response<Void> response) {
//        Log.i("MainActivity", "onResponse: " + response.code() + "\n" + response.body());
//    }
//
//    @Override
//    public void onFailure(Call<Void> call, Throwable t) {
//
//    }

    @Override
    public void onResponse(Call<SmallBody> call, Response<SmallBody> response) {
        Log.i("MainActivity", "onResponse: " + response.code() + "\n" + response.body());
        SmallBody smallBody = response.body();
        Log.i(MainActivity.class.getSimpleName(), "onResponse: " + smallBody.small_body);
    }

    @Override
    public void onFailure(Call<SmallBody> call, Throwable t) {

    }
}
