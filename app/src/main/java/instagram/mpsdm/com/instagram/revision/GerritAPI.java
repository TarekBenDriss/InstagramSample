package instagram.mpsdm.com.instagram.revision;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {

    String BASE_URL = "https://api.stackexchange.com";


    @GET("changes/")
    Call<List<User>> loadChanges(@Query("q") String status);
}