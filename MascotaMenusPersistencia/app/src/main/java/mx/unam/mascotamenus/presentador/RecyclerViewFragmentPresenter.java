package mx.unam.mascotamenus.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.unam.mascotamenus.db.ConstructorMascotas;
import mx.unam.mascotamenus.pojo.Mascota;
import mx.unam.mascotamenus.vista.fragment.IRecyclerViewFragmentView;

/**
 * Created by john on 04/09/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ConstructorMascotas constructorMacotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMacotas=new ConstructorMascotas(context);
        mascotas=constructorMacotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerFotos() {

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
