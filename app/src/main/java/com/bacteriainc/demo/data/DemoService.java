package com.bacteriainc.demo.data;

import com.bacteriainc.demo.data.entity.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DemoService {
    @Headers("Content-Type:application/json")
    @GET("categoriasWithProd.php")
    Observable<Response<List<Category>>> getCategories();
}
