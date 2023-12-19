package antonia.alarcon.android_ejemploretrofit.conexiones;

import antonia.alarcon.android_ejemploretrofit.constantes.Constantes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    //para poder instanciar sin necesidad

    /*
    * 1. a que servidor nos vamos a conectar, la url
    * 2. le decimos que tiene que crear ___
    * 3. que construya lo anterior */
    public static Retrofit getConexioin() {
        return new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
