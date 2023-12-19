package antonia.alarcon.android_ejemploretrofit.conexiones;

import java.util.ArrayList;

import antonia.alarcon.android_ejemploretrofit.modelos.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();
}
