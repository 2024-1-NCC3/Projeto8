package br.edu.fecap.doesangueproject.API;

import br.edu.fecap.doesangueproject.models.LoginResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("registrarUser")
    Call<ResponseBody> registrarUser(
            @Field("nome") String nome,
            @Field("email") String email,
            @Field("senha") String senha
    );

    @FormUrlEncoded
    @POST("loginUser")
    Call<LoginResponse> loginUser(
            @Field("email") String email,
            @Field("senha") String senha
    );

}
