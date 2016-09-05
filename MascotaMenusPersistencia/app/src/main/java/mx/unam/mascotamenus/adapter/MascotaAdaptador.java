package mx.unam.mascotamenus.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.unam.mascotamenus.R;
import mx.unam.mascotamenus.db.ConstructorMascotas;
import mx.unam.mascotamenus.pojo.Mascota;

/**
 * Created by john on 20/08/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    private TextView tvfavorito;
    ArrayList<Mascota> listMacotas;
    Activity activity;

   public MascotaAdaptador(ArrayList<Mascota> listMacotas, Activity activity){

       this.listMacotas=listMacotas;
       this.activity = activity;
   }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=listMacotas.get(position);
        mascotaViewHolder.ivMascota.setImageResource(mascota.getFoto());
       /* mascotaViewHolder.ivMascota.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(this,Activity_Contacto.class);
                startActivity(intent);
            }
        });*/
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRaiting())+" Likes");
        mascotaViewHolder.ivHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mascota.setRaiting(mascota.getRaiting()+1);
                mascota.setFavorito(1);

                ConstructorMascotas constructorMascotas=new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);


                mascotaViewHolder.tvRate.setText(constructorMascotas.obtenerLikesMascota(mascota) + " "+" Likes");

                //tvfavorito=(TextView)  view.findViewById(R.id.tvfavorito);
                //tvfavorito.setText("1"+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMacotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView ivMascota;
        private TextView tvNombre;
        private TextView tvRate;
        private ImageView ivHuesoBlanco;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivMascota=(ImageView) itemView.findViewById(R.id.ivMascota);
            tvNombre=(TextView)  itemView.findViewById(R.id.tvNombre);
            tvRate=(TextView)  itemView.findViewById(R.id.tvRate);
            ivHuesoBlanco=(ImageView)  itemView.findViewById(R.id.ivHuesoBlanco);
/*
            ivHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    tvRate.setText(String.valueOf(10));
                }
            });*/
        }
    }
}



