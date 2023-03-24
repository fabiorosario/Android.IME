package fabiorosario.ime.pgsc.componentesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Intent intent = getIntent();
        String usuario = intent.getStringExtra(MainActivity.login_usuario);
        String email = intent.getStringExtra(MainActivity.email_usuario);
        ((TextView)findViewById(R.id.status)).setText(usuario);
        ((TextView)findViewById(R.id.email)).setText(email);
    }
}