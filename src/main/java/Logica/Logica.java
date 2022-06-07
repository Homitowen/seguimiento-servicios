package Logica;

import Informacion.Constantes;

public class Logica {

    String lineaEntrada;
    String[] Parametros;

    boolean estadoPrograma = false;
    Constantes cte = new Constantes();

    public Logica(){
        this.estadoPrograma = false;
    }
    public Logica(String lineaEntrada) {
        this.lineaEntrada = lineaEntrada;
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


    public String getLineaEntrada() {
        return this.lineaEntrada;
    }

    public void setLineaEntrada(String lineaEntrada) {
        this.lineaEntrada = lineaEntrada;
    }

    public boolean isEstadoPrograma() {
        return this.estadoPrograma;
    }

    public void setEstadoPrograma(boolean estadoPrograma) {
        this.estadoPrograma = estadoPrograma;
    }
}
