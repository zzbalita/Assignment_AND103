package phcom.phlynk.assignment_and103;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    String DOMAIN = "http://0.0.0.0:3000/";

    @GET("/api/list")
    Call<List<TreeModel>> getTree();


}
