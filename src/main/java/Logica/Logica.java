package Logica;

import Informacion.Constantes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Logica {

    String lineaEntrada;

    ArrayList<String> codigoSeparado = new ArrayList<String>();
    ArrayList<String> parametrosCargados = new ArrayList<String>();


    StringBuilder unParametro;


    boolean estadoPrograma = false;
    boolean esParametroCompuesto;
    Constantes cte = new Constantes();
    private StringBuilder acumulador;

    public Logica(){
        this.estadoPrograma = false;
    }
    public Logica(String lineaEntrada) {
        this.lineaEntrada = lineaEntrada;
        armarParametros();
    }


    public void mostrarParametros(){
        for (String i : this.parametrosCargados){
            System.out.println(i);
        }
    }
    /*Tengo que lograr:
    * - identificar comillas
    * - separar en funcion a lo anterior*/

    /*para separar la linea de entrada*/
    private void separarPorPartes(){
        for (String i : this.lineaEntrada.split(cte.ID_CONSTANTE_SEPARADOR)){
            this.codigoSeparado.add(i);
        }
    }

    /*Hacer parametros en funcion de si son compuestos
    * Cuando comienza con X
    * Cuando no lo tiene
    * Cuando Termina con X
    * */
    private void armarParametros(){
        separarPorPartes();
        for(String i : codigoSeparado){
            this.esParametroCompuesto = false;
            this.unParametro = new StringBuilder();
            this.acumulador = new StringBuilder();

            if (i.startsWith(cte.ID_CONSTANTE_COMPUESTO) & i.endsWith(cte.ID_CONSTANTE_COMPUESTO)) {
                this.unParametro.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, ""));
            } else if (i.startsWith(cte.ID_CONSTANTE_COMPUESTO)){
                this.esParametroCompuesto = true;
                this.acumulador.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, ""));
            } else if (i.endsWith(cte.ID_CONSTANTE_COMPUESTO)){
                this.acumulador.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, ""));
            }

            this.unParametro.append(this.acumulador);
            this.parametrosCargados.add(this.unParametro.toString());

        }
    }

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
