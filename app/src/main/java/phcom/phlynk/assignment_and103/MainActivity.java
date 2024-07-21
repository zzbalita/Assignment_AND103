package phcom.phlynk.assignment_and103;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    List<TreeModel> listTreeModel;

    TreeAdapter treeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMain = findViewById(R.id.listviewMain);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<TreeModel>> call = apiService.getTrees();

        call.enqueue(new Callback<List<TreeModel>>() {
            @Override
            public void onResponse(Call<List<TreeModel>> call, Response<List<TreeModel>> response) {
                if (response.isSuccessful()) {
                    listTreeModel = response.body();

                    treeAdapter = new TreeAdapter(getApplicationContext(), listTreeModel);

                    lvMain.setAdapter(treeAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<TreeModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}
