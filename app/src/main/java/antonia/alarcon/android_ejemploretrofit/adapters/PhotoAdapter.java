package antonia.alarcon.android_ejemploretrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import antonia.alarcon.android_ejemploretrofit.R;
import antonia.alarcon.android_ejemploretrofit.modelos.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoVH> {

    private Context context;
    private int resource;
    private List<Photo> objects;


    @NonNull
    @Override
    public PhotoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View photoView = LayoutInflater.from(context).inflate(resource, null);
        return new PhotoVH(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoVH holder, int position) {
        Photo p = objects.get(position);

        holder.lbTitulo.setText(p.getTitle());

        Picasso.get().load(p.getThumbnailUrl()).placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(holder.imgFotito);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PhotoVH extends RecyclerView.ViewHolder{
        ImageView imgFotito;
        TextView lbTitulo;

        public PhotoVH(@NonNull View itemView) {
            super(itemView);

            imgFotito = itemView.findViewById(R.id.imgFotitoViewHolder);
            lbTitulo = itemView.findViewById(R.id.lbTituloPhotoViewHolder);
        }
    }

    public PhotoAdapter(Context context, int resource, List<Photo> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
}
