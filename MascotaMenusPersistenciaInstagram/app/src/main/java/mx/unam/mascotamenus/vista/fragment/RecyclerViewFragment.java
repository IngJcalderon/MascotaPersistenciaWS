package mx.unam.mascotamenus.vista.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.unam.mascotamenus.adapter.MascotaAdaptador;
import mx.unam.mascotamenus.R;
import mx.unam.mascotamenus.RecyclerItemClickListener;
import mx.unam.mascotamenus.pojo.Mascota;
import mx.unam.mascotamenus.presentador.IRecyclerViewFragmentPresenter;
import mx.unam.mascotamenus.presentador.RecyclerViewFragmentPresenter;

/**
 * Created by john on 29/08/2016.
 */
public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentView{

    Mascota mascota;
   // ArrayList<Mascota> listMacotas;
    private RecyclerView rvMascotas;
    private TextView tvfavorito;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);


        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);


/*
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
            }
        });
        */

/*
        rvMascotas.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public void onTouchEvent(RecyclerView recycler, MotionEvent event) {
                // Handle on touch events here
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
                return false;
            }

        });

        */

        rvMascotas.addOnItemTouchListener(
                 new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                       // Intent intent = new Intent(view.getContext(), fragment_favoritos.class);
                        //intent=new Intent(this,Activity_Contacto.class);
                       // startActivity(intent);
                        Snackbar.make(view, "Mascota : "+position, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                })
        );


        presenter=new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        // GridLayoutManager glm=new GridLayoutManager(getActivity(),2);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> Mascotas) {
        MascotaAdaptador adaptador=new MascotaAdaptador(Mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
/*
    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            RecyclerViewFragment.this.refresh();
        }
    }

    public void refresh() {
        //yout code in refresh.
        Log.i("Refresh", "YES");
    }*/
}

