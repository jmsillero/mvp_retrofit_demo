package com.bacteriainc.demo.data;

import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.utils.AppConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryRemoteProvider {
    private DemoService demoService;

    public CategoryRemoteProvider() {
        demoService = buildRetrofitInstance().create(DemoService.class);
    }

    private Retrofit buildRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);
        httpClient.readTimeout(10, TimeUnit.SECONDS);
        httpClient.connectTimeout(10, TimeUnit.SECONDS);


        OkHttpClient client = httpClient.build();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setLenient()
                .create();

        Retrofit retrofit1 = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(AppConstants.SERVICE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit1;
    }

    public Observable<List<Category>> fetchCategories() {
        return demoService.getCategories().map(listResponse -> {
            if (listResponse.code() == 200) {
                return listResponse.body();
            }
            return null; // return empty list
        });
    }
}
