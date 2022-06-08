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
        verificarComando();
        verificarSubComando();
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
//            Para los que deben contener comillas
            if (i.startsWith(cte.ID_CONSTANTE_COMPUESTO) & i.endsWith(cte.ID_CONSTANTE_COMPUESTO)) {
                this.acumulador = new StringBuilder();
                this.unParametro = new StringBuilder();

                this.parametrosCargados.add(i.replace(cte.ID_CONSTANTE_COMPUESTO, ""));
//                Para los que comienzan con comilla
            } else if (i.startsWith(cte.ID_CONSTANTE_COMPUESTO)){
                this.esParametroCompuesto = true;
                this.acumulador = new StringBuilder();
                this.acumulador.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, "")+" ");
//                Para los que terminan con comilla
            } else if (i.endsWith(cte.ID_CONSTANTE_COMPUESTO)){
                this.esParametroCompuesto = false;
                this.acumulador.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, ""));
                this.parametrosCargados.add(this.acumulador.toString());
//                Para los que no son extremos de un parametro compuesto
            } else if (this.esParametroCompuesto){
                this.acumulador.append(i.replace(cte.ID_CONSTANTE_COMPUESTO, "")+" ");
//                Para los que no tienen comillas ni son parte de un parametro compuesto
            } else {
                this.parametrosCargados.add(i);
            }



        }
    }

    private boolean verificarComando(){
        if (this.parametrosCargados.get(0).equals(cte.NUEVO)){
            System.out.println("hacer Nuevo");
            return true;
        } else if (this.parametrosCargados.get(0).equals(cte.MODIFICAR)){
            System.out.println("hacer Modificacion");
            return true;
        } else if (this.parametrosCargados.get(0).equals(cte.ELIMINAR)){
            System.out.println("hacer Eliminacion");
            return true;
        } else {
            System.out.println("Comando Error");
        }
        return false;
    }

    private boolean verificarSubComando(){
        if (this.parametrosCargados.get(1).equals(cte.MES)){
            System.out.println("Sobre mes");
            return true;
        } else if (this.parametrosCargados.get(1).equals(cte.SERVICIO)){
            System.out.println("sobre servicio");
            return true;
        } else if (this.parametrosCargados.get(1).equals(cte.PAGO)){
            System.out.println("sobre pago");
            return true;
        } else {
            System.out.println("Subcomando Error");
        }
        return false;
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
