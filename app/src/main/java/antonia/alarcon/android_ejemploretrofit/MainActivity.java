package antonia.alarcon.android_ejemploretrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import antonia.alarcon.android_ejemploretrofit.adapters.AlbumAdapter;
import antonia.alarcon.android_ejemploretrofit.conexiones.ApiConexiones;
import antonia.alarcon.android_ejemploretrofit.conexiones.RetrofitObject;
import antonia.alarcon.android_ejemploretrofit.databinding.ActivityMainBinding;
import antonia.alarcon.android_ejemploretrofit.modelos.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AlbumAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private ArrayList<Album> listaAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //inicializar la lista siempre antes que el adaptare para poder pasársela
        listaAlbums = new ArrayList<>();
        adapter = new AlbumAdapter(this, R.layout.album_view_holder, listaAlbums);
        lm = new LinearLayoutManager(this);

        binding.contentMain.contenedorAlbums.setAdapter(adapter);
        binding.contentMain.contenedorAlbums.setLayoutManager(lm);

        doGetAlbums();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void doGetAlbums() {
        Retrofit retrofit = RetrofitObject.getConexioin();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<ArrayList<Album>> getAlbums = api.getAlbums();

        getAlbums.enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                if (response.code() == HttpsURLConnection.HTTP_OK) {
                    ArrayList<Album> temp = response.body();
                    listaAlbums.addAll(temp);
                    adapter.notifyItemRangeInserted(0, listaAlbums.size());
                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}