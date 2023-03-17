package fabiorosario.ime.pgsc.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botaoAcaoIMC(View v){

        EditText alturaIU = (EditText) findViewById(R.id.altura);
        EditText pesoIU = (EditText) findViewById(R.id.peso);
        float altura = Float.parseFloat(alturaIU.getText().toString());
        float peso = Float.parseFloat(pesoIU.getText().toString());

        Intent resultadoIMC = new Intent(this, IMCActivity.class);

        double imc = new IMC(peso, altura).CalcularAMC();
        resultadoIMC.putExtra("imc_resultado", String.valueOf(imc));

        if (imc < 18.5){
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc0);
        }else if (imc <= 24.9){
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc1);
        }else if (imc <= 29.9){
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc2);
        }else if (imc <= 34.9){
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc3);
        }else if (imc <= 39.9){
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc4);
        }else{
            resultadoIMC.putExtra("imc_imagem", R.drawable.imc5);
        }

        startActivity(resultadoIMC);
        finish();
    }
}