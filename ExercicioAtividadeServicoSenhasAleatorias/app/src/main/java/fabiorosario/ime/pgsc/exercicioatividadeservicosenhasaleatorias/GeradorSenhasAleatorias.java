package fabiorosario.ime.pgsc.exercicioatividadeservicosenhasaleatorias;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class GeradorSenhasAleatorias extends Service {
    public static final String[] letrasMaiusculas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static final String[] letrasMinusculas = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static final String[] caracteresEspeciais = { "!", "@", "#", "$", "%", "&", "(", ")", "-", "_", "=",
            "+", ",", ";"};

    public static final String[] numerosPossiveis = { "0", "1", "2", "3", "4", "5", "6", "7", "8","9"};

    private final IBinder mBinder = new GeradorSenhasAleatorias.MyBinder();
    public class MyBinder extends Binder {
        GeradorSenhasAleatorias getService(){
            return GeradorSenhasAleatorias.this;
        }
    }
    public GeradorSenhasAleatorias() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public String gerarSenhasAleatorias(int quantidadeSenhas, int maiusculas, int minusculas, int caracteres, int numeros){
        StringBuilder senhasGeradas = new StringBuilder();
        for (int i = 0; i < quantidadeSenhas; i++){
            escolherCaracteresSenha(maiusculas, letrasMaiusculas, senhasGeradas);
            escolherCaracteresSenha(minusculas, letrasMinusculas, senhasGeradas);
            escolherCaracteresSenha(caracteres, caracteresEspeciais, senhasGeradas);
            escolherCaracteresSenha(numeros, numerosPossiveis, senhasGeradas);
            senhasGeradas.append(System.getProperty("line.separator"));
        }
        return senhasGeradas.toString();
    }
    void escolherCaracteresSenha(int limite, String[] caracteresPossiveis, StringBuilder senhasGeradas){
        for (int i = 0; i < limite; i++) {
            int posicao = new Random().nextInt(caracteresPossiveis.length);
            senhasGeradas.append(caracteresPossiveis[posicao]);
        }
    }
}