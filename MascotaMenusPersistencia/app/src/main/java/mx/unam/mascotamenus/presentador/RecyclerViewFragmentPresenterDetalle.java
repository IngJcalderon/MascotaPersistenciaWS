package mx.unam.mascotamenus.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.unam.mascotamenus.db.ConstructorMascotas;
import mx.unam.mascotamenus.pojo.Mascota;
import mx.unam.mascotamenus.vista.fragment.IRecyclerViewFragmentView;
import mx.unam.mascotamenus.vista.fragment.IRecyclerViewFragmentViewFotos;

/**
 * Created by john on 04/09/2016.
 */
public class RecyclerViewFragmentPresenterDetalle implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentViewFotos iRecyclerViewFragmentViewFotos;
    private  Context context;
    private ConstructorMascotas constructorMacotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenterDetalle(IRecyclerViewFragmentViewFotos iRecyclerViewFragmentViewFotos, Context context) {
        this.iRecyclerViewFragmentViewFotos=iRecyclerViewFragmentViewFotos;
        this.context=context;
        obtenerFotos();
    }

    @Override
    public void obtenerMascotas() {
        /*constructorMacotas=new ConstructorMascotas(context);
        mascotas=constructorMacotas.obtenerDatos();
        mostrarMascotasRV();*/
    }

    @Override
    public void obtenerFotos() {
        constructorMacotas=new ConstructorMascotas(context);
        mascotas=constructorMacotas.obtenerFotos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentViewFotos.inicializarAdaptadorRV(iRecyclerViewFragmentViewFotos.crearAdaptador(mascotas));
        iRecyclerViewFragmentViewFotos.generarGridLayout();
    }

}
