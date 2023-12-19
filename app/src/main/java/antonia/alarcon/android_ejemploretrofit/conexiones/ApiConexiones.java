package antonia.alarcon.android_ejemploretrofit.conexiones;

import java.util.ArrayList;

import antonia.alarcon.android_ejemploretrofit.modelos.Album;
import antonia.alarcon.android_ejemploretrofit.modelos.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConexiones {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    //para filtrar por parámetro
    @GET("/photos")
    Call<ArrayList<Photo>> getPhotoAlbum(@Query("albumId") int albumId);
}
