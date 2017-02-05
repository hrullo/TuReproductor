package script.hrullo.com.tureproductor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class ListaActivity extends AppCompatActivity {

   protected  ListView lista;
    protected String videos []={"video1","video2","video3","video4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Contruyo el ListView
        lista=(ListView)findViewById(R.id.idLista);

        //Creo el Adaptador para poder mapear la lista con el array
        ArrayAdapter <String> adaptador = new ArrayAdapter(ListaActivity.this,android.R.layout.simple_list_item_1,videos);
       lista.setAdapter(adaptador);
        //Capturo lo eventos de los item seleccionados
      lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              //Obtengo el String de cada posicion

              String id = String.valueOf(lista.getItemAtPosition(i));
                //Creo un Intent para enviar el ID a la PrimneraActivity
              Intent intent = new Intent(getApplicationContext(),PrimeraActivity.class);
              intent.putExtra("video",id);
              startActivity(intent);



          }
      });

    }
}
