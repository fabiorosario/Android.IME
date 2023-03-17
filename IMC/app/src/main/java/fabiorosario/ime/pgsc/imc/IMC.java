package fabiorosario.ime.pgsc.imc;

public class IMC {
    float _altura;
    float _peso;
    
    public IMC(float peso, float altura){
        _peso = peso;
        _altura = altura;
    }

    public double CalcularAMC(){
        double scale = Math.pow(10, 1);
        return Math.round((_peso / (Math.pow(_altura/100, 2))) * scale) / scale;
    }
}
