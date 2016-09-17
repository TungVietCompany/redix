package redix.booxtown.api;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import redix.booxtown.model.Book;
import redix.booxtown.model.CommentResult;
import redix.booxtown.model.Profile;
import redix.booxtown.model.Result;
import redix.booxtown.model.BookResult;
import redix.booxtown.model.Thread;
import redix.booxtown.model.ThreadResult;
import redix.booxtown.model.TopicResult;
import redix.booxtown.model.User;
import redix.booxtown.model.UserResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ServiceInterface {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Multipart
    @POST("/booxtown/rest/uploadimage")
    Call<Result> postImage(@Part MultipartBody.Part image);

    @GET("/booxtown/rest/getimage")
    Call<ResponseBody> getImage(@Query("username") String username ,@Query("image") String image);

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @POST("/booxtown/rest/user/signup")
    Call<Result> addUser(@Body User user);

    @POST("/booxtown/rest/book/update")
    Call<Result> update(@Body Object book);

    @POST("/booxtown/rest/user/login")
    Call<Result> login(@Body Object user);

    @GET("/booxtown/rest/user/getprofile")
    Call<UserResult> getprofile(@Query("session_id") String session_id);

    @POST("/booxtown/rest/user/updateprofile")
    Call<Result> updateprofile(@Body Object user);

    @POST("/booxtown/rest/user/changepassword")
    Call<Result> changepassword(@Query("session_id") String session_id, @Query("pwd_old") String pwd_old,
                                @Query("pwd_new") String pwd_new);

    @POST("/booxtown/rest/user/logout")
    Call<Result> logout(@Body Object user);

    @POST("/booxtown/rest/user/forgotpassword")
    Call<Result> forgotpassword(@Body Object email);

    @POST("/booxtown/rest/book/addbook")
    Call<Result> addbook(@Body Object book);

    @POST("/booxtown/rest/book/getinfo")
    Call<BookResult> getinfo(@Query("session_id") String session_id, @Query("book_id") String book_id);

    @GET("/booxtown/rest/book/getallbook")
    Call<BookResult> getAllBook();

    @GET("/booxtown/rest/book/getallbookbyuser")
    Call<BookResult> getAllBookByUser(@Query("session_id") String session_id);

    @POST("/booxtown/rest/book/book_delete")
    Call<Result> deletebook(@Body Object book);

    @GET("/booxtown/rest/topic/topic_getall")
    Call<TopicResult> topic_getall();

    @GET("/booxtown/rest/thread/thread_getbytopic")
    Call<ThreadResult> getAllThread(@Query("topic_id") String topic_id);

    @POST("/booxtown/rest/thread/thread_insert")
    Call<Result> insertThread(@Body Object thread);

    @GET("/booxtown/rest/comment/comment_getbythread")
    Call<CommentResult> getAllComment(@Query("thread_id") String thread_id);

    @POST("/booxtown/rest/comment/comment_insert")
    Call<Result> inser_comment_thread(@Body Object comment);
}
