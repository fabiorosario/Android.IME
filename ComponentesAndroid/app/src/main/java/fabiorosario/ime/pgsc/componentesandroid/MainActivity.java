package fabiorosario.ime.pgsc.componentesandroid;

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

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.LineNumberReader;

public class MainActivity extends AppCompatActivity {

    private Logar logar;
    Intent intent;
    public static String json = "";
    public static final String login_usuario = "login_usuario";
    public static final String email_usuario = "email_usuario";

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder){
            Logar.MyBinder b = (Logar.MyBinder)iBinder;
            logar = b.getService();
            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName){
            logar = null;
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

        MeuJsonReaderWriter meuJsonReaderWriter = new MeuJsonReaderWriter("Rosario", "12345", "rosario.santos@ime.mil.br");
        try {
            json = meuJsonReaderWriter.createJson();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        intent = new Intent(this, Logar.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause(){
        super.onPause();
        unbindService(serviceConnection);
    }

    public void Acesso(View v){
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String senha = ((EditText)findViewById(R.id.senha)).getText().toString();
        boolean loginOK = logar.validar(login, senha);

        String status = (loginOK) ? "Acesso Autorizado" : "Erro";
        String email = (loginOK) ? logar.emailUsuarioLogado() : "";
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();

        if (loginOK) {
            Intent intent = new Intent(this, TelaPrincipal.class);
            intent.putExtra(login_usuario, login);
            intent.putExtra(email_usuario, email);
            startActivity(intent);
            finish();
        }
    }
}