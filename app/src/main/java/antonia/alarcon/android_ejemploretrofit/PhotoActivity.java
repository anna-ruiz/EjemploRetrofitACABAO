package antonia.alarcon.android_ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import antonia.alarcon.android_ejemploretrofit.adapters.PhotoAdapter;
import antonia.alarcon.android_ejemploretrofit.modelos.Photo;

public class PhotoActivity extends AppCompatActivity {
    private PhotoAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private ArrayList<Photo> listaPhotos;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        recycler = findViewById(R.id.contenedorPhoto);
        listaPhotos = new ArrayList<>();
        adapter = new PhotoAdapter(this, R.layout.photo_view_holder, listaPhotos);
        lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //unir tod0
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(lm);
    }
}