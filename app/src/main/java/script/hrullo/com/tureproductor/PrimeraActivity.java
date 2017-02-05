package script.hrullo.com.tureproductor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class PrimeraActivity extends AppCompatActivity {

    //Decalro los elementos a utilizar
     protected VideoView reproductor;
     protected ImageButton play;
    protected   ImageButton pause;
    protected  Uri url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);

        //Recupero los ID de ListaActivity
        Intent intent= getIntent();

       String video=getIntent().getStringExtra("video");

        //Segun el ID, creo la URL
        if (video.equals("video1"))
        {
            url = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1);
        }else
            if(video.equals("video2")) {

                url = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);



            }else if (video.equals("video3")) {
                url = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3);

            }else if (video.equals("video4"))

            {
                url = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video4);

            }

                // Obtengo el objeto VideoView del Activity
                reproductor= (VideoView) findViewById(R.id.idVideo);
                reproductor.setVideoURI(url);

                cargarBotones();

            }


    //Metodo encargado de crear los botones y la captura de sus eventos

    public void cargarBotones()
    {

        //Creo los botones
        play=(ImageButton) findViewById(R.id.btbPlay);
        pause= (ImageButton)findViewById(R.id.btbPause);

        //Capturo los eventos de los objetos
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproductor.pause();
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!reproductor.isPlaying())


                    reproductor.start();
                reproductor.requestFocus();
            }
        });



    }






}
