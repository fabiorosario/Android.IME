package fabiorosario.ime.pgsc.exercicioatividadeservicosenhasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GeradorSenhasAleatorias geradorSenhasAleatorias;
    Intent intent;

    public static final String senhas_geradas = "senhas_geradas";

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GeradorSenhasAleatorias.MyBinder b = (GeradorSenhasAleatorias.MyBinder)iBinder;
            geradorSenhasAleatorias = b.getService();
            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            geradorSenhasAleatorias = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        intent = new Intent(this, GeradorSenhasAleatorias.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause(){
        super.onPause();
        unbindService(serviceConnection);
    }

    public void GerarSenhasAleatorias(View v){
        int maiusculas = QuantidadeLetrasMaiusculas();
        int minusculas = QuantidadeLetrasMinusculas();
        int caracteres = QuantidadeCaracteresEspeciais();
        int numeros = QuantidadeNumeros();

        if ((maiusculas + minusculas + caracteres + numeros) == 0)
            Toast.makeText(MainActivity.this, "Digite ao menos uma das quantidades requeridas!", Toast.LENGTH_SHORT).show();
        else{
            String senhasGeradas = geradorSenhasAleatorias.gerarSenhasAleatorias(10, maiusculas, minusculas, caracteres, numeros);

            Intent intent = new Intent(this, SenhasAleatoriasActivity.class);
            intent.putExtra(senhas_geradas, senhasGeradas);
            startActivity(intent);
            finish();
        }
    }
    private int QuantidadeLetrasMaiusculas(){
        try{
            return Integer.parseInt(((EditText)findViewById(R.id.maiusculas)).getText().toString());
        }catch(Exception e){
            return 0;
        }
    }
    private int QuantidadeLetrasMinusculas(){
        try{
            return Integer.parseInt(((EditText)findViewById(R.id.minusculas)).getText().toString());
        }catch(Exception e){
            return 0;
        }
    }
    private int QuantidadeCaracteresEspeciais(){
        try{
            return Integer.parseInt(((EditText)findViewById(R.id.caracteres)).getText().toString());
        }catch(Exception e){
            return 0;
        }
    }
    private int QuantidadeNumeros(){
        try {
            return Integer.parseInt(((EditText) findViewById(R.id.numeros)).getText().toString());
        }
        catch(Exception e){
            return 0;
        }
    }

}