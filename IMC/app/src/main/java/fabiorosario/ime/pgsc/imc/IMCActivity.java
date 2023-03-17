package fabiorosario.ime.pgsc.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        mostrarResultadoIMC();

    }

    void mostrarResultadoIMC(){

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            ((TextView)findViewById(R.id.imc_resultado)).setText(extras.getString("imc_resultado"));
            Drawable imc_imagem = getDrawable(extras.getInt("imc_imagem"));
            ((ImageView)findViewById(R.id.imc_imagem)).setImageDrawable(imc_imagem);
        }
    }

}