package fabiorosario.ime.pgsc.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Salvar(View v) throws ClassNotFoundException {

        String nome = ((EditText)findViewById(R.id.nome)).getText().toString();
        String telefone = ((EditText)findViewById(R.id.telefone)).getText().toString();
        EditText jsonFile = (EditText)findViewById(R.id.jsonsalvo);
        try {
            String json = (new MeuJsonReaderWriter(nome, telefone, nome+"-"+telefone)).createJson();
            jsonFile.setText(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Escrever(View v) throws IOException {
        EditText nome = (EditText)findViewById(R.id.nomejson);
        EditText telefone = (EditText)findViewById(R.id.telefonejson);
        EditText jsonFile = (EditText)findViewById(R.id.jsonsalvo);

        Agenda agenda = (new MeuJsonReaderWriter(jsonFile.getText().toString())).readJson();
        nome.setText(agenda.getNome());
        telefone.setText(agenda.getTelefone());
    }
}