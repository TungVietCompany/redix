package redix.booxtown.API;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import redix.booxtown.model.Book;
import redix.booxtown.model.Result;
import redix.booxtown.model.BookResult;
import redix.booxtown.model.UserResult;
import redix.booxtown.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ServiceInterface {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Multipart
    @POST("/")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image);

    @GET("/uploads")
    Call<ResponseBody> getImage(@Query("fileName") String fileName);

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @POST("/booxtown/rest/user/signup")
    Call<Result> addUser(@Body User user);

    @POST("/booxtown/rest/user/login")
    Call<Result> login(@Query("username") String username, @Query("password") String password,
                       @Query("device_type") String device_type);

    @POST("/booxtown/rest/user/getprofile")
    Call<BookResult> getprofile(@Query("session_id") String session_id);

    @POST("/booxtown/rest/user/updateprofile")
    Call<Result> updateprofile(@Body User user, @Query("session_id") String session_id);

    @POST("/booxtown/rest/user/changepassword")
    Call<Result> changepassword(@Query("session_id") String session_id, @Query("pwd_old") String pwd_old,
                                @Query("pwd_new") String pwd_new);

    @POST("/booxtown/rest/user/logout")
    Call<Result> logout(@Query("session_id") String session_id);

    @POST("/booxtown/rest/user/forgotpassword")
    Call<Result> forgotpassword(@Query("email") String email);

    @POST("/booxtown/rest/book/addbook")
    Call<Result> addbook(@Body Book book, @Query("session_id") String session_id);

    @POST("/booxtown/rest/book/getinfo")
    Call<UserResult> getinfo(@Query("session_id") String session_id, @Query("book_id") String book_id);

    @POST("/booxtown/rest/book/getallbook")
    Call<UserResult> getAllBook(@Query("session_id") String session_id);

}
