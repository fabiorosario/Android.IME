package fabiorosario.ime.pgsc.exercicioatividadeservicosenhasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SenhasAleatoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senhas_aleatorias);

        Intent intent = getIntent();
        String senhasGeradas = intent.getStringExtra(MainActivity.senhas_geradas);
        ((TextView) findViewById(R.id.senhasAleatoriasGeradas)).setText(senhasGeradas);
    }
}