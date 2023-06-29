package com.example.pro2023.Apis;

import com.example.pro2023.model.category;
import com.example.pro2023.model.doctors;
import com.example.pro2023.model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIUrl {
    //
    /* URL  */

    String SIGN_IN = "http://10.0.2.2/store/checkUser.php/";
    String CAT="http://10.0.2.2/pharmacy/categoryMain.php/";
    String DOCTORS="http://10.0.2.2/pharmacy/doctorsCategory.php/";
    String VITAMINS="http://10.0.2.2/pharmacy/Vitamins.php/";
    String SER="http://10.0.2.2/pharmacy/suroms.php/";
    String SELLR="http://10.0.2.2/pharmacy/SellR.php/";




    @GET("categoryMain.php")
    Call<List<category>> getCategory();
    @GET("doctorsCategory.php")
    Call<List<doctors>> getDoctorsCategory();

    @GET("Vitamins.php")
    Call<List<product>>getProducts();
    //abs methode
    @GET("Products.php")
    Call<List<product>>getSerum();
    @GET("SellR.php")
    Call<List<product>>getSells();


}
