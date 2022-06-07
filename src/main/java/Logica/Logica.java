package Logica;

import Informacion.Constantes;

import java.sql.Connection;
import java.util.List;

public class Logica {

    String segmento;
    String[] Parametros;
    Constantes cte = new Constantes();

    //Obtener partes del comando
    public String obtenerParametro(String codigo){
        segmento = "";
        for (int i = 0; i <= codigo.length(); i++){

            if (codigo.charAt(i) == cte.ID_CONSTANTE_SEPARADOR){
                break;
            }

            segmento = segmento + codigo.charAt(i);

        }

        return segmento;
    }

//    Obtener conjunto de Partes

    /*Verificación de parametros*/

    private boolean verificarComando(){

        return true;
    }

    private boolean verificarSubComando(){
        return true;
    }

    private boolean verificarLetras(){
        return true;
    }

    private boolean verificarNumeros(){
        return true;
    }


    public String getSegmento() {
        return this.segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }
}
