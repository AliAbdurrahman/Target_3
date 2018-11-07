package id.papapaok.aliabdurrahman.focus.Network;

import id.papapaok.aliabdurrahman.focus.Model.ResponseGetFocus;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public interface ApiService {

    @GET("top-headlines")
    Call<ResponseGetFocus> getFocusData (
            @Query("sources") String sources,
            @Query("apikey") String key
    );

}
