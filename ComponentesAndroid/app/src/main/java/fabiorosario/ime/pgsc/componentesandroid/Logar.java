package fabiorosario.ime.pgsc.componentesandroid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;

public class Logar extends Service {

    private final IBinder mBinder = new MyBinder();
    private Usuario usuarioLogado;
    public class MyBinder extends Binder {
        Logar getService(){
            return Logar.this;
        }
    }
    public Logar() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public boolean validar(String login, String senha){

        try {
            usuarioLogado = (new MeuJsonReaderWriter(MainActivity.json)).readJson();
            if (login.equals(usuarioLogado.getLogin()) && senha.equals(usuarioLogado.getSenha()))
                return true;
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public String emailUsuarioLogado(){
        return usuarioLogado.getEmail();
    }

}