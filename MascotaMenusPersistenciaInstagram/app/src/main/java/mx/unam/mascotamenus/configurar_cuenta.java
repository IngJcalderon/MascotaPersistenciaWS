package mx.unam.mascotamenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class configurar_cuenta extends AppCompatActivity implements View.OnClickListener{
    Button btnGuardarCuenta;
    EditText inputNombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);
        inputNombreUsuario = (EditText) findViewById(R.id.inputNombreUsuario);
        btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);

        btnGuardarCuenta.setOnClickListener(this);
    }

    public void asignarUsuario(View v){

    }

    @Override
    public void onClick(View view) {
        String user = inputNombreUsuario.getText().toString();

        String [] opciones = {
                getResources().getString(R.string.user1),
                getResources().getString(R.string.user2)

        };

        boolean esValido = false;

        for (int i = 0; i < opciones.length; i++) {
            if (user.equals(opciones[i])){
                esValido=true;
            }
        }
        //UserGral.usuario="3964909392";
        if (esValido){
               UserGral.usuario=user;

            Toast.makeText(configurar_cuenta.this, user +" Guardado :)", Toast.LENGTH_LONG).show();

        }else {

              Toast.makeText(configurar_cuenta.this, "Incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}
