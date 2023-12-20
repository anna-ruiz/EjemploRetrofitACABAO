package antonia.alarcon.android_ejemploretrofit.conexiones;

import java.util.ArrayList;

import antonia.alarcon.android_ejemploretrofit.modelos.Album;
import antonia.alarcon.android_ejemploretrofit.modelos.Photo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConexiones {

    //Mostrar todos
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    //mostrar todos los de X parámetro - Filtrar por parametros
    @GET("/photos?")
    Call<ArrayList<Photo>> getPhotoAlbum(@Query("albumId") int albumId);

    //mostrar todos de X path - Filtrar por path
    @GET("/albums/{albumId}/photos")
    Call<ArrayList<Photo>> getPhotoAlbumPath(@Path("albumId") int albumId);

    //Insertar un album
    @POST("/albums")
    Call<Album> postAlbum(@Body Album a);

    //eliminar un album
    @DELETE("/albums/{id}")
    Call<Album> deleteAlbum(@Path("id") int idAlbum);

}
