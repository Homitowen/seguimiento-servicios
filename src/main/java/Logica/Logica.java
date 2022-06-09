package Logica;

import Informacion.Constantes;
import Informacion.Mes;
import Informacion.Servicios;

import java.time.LocalDate;
import java.util.ArrayList;

public class Logica {
    Constantes cte = new Constantes();
    String lineaEntrada;

    ArrayList<String> codigoSeparado = new ArrayList<String>();
    ArrayList<String> parametrosCargados = new ArrayList<>();

    StringBuilder unParametro;

    Servicios servicios;
    Mes mes;


    boolean estadoPrograma = false;
    boolean esParametroCompuesto;
    private StringBuilder acumulador;
    private int posicionActual;

    public Logica(){
        this.estadoPrograma = false;
    }
    public Logica(String lineaEntrada) {
        this.lineaEntrada = lineaEntrada;
        armarParametros();
        comandoElegido();
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

    /*Devueelve el parametro actual de parametrosCargados*/
    private String parametroActual(){
        return parametrosCargados.get(this.posicionActual);
    }

    /*Obtener el siguiente parametro de parametrosCargados*/
    private String siguienteParametro(){
        this.posicionActual++;
        return parametrosCargados.get(this.posicionActual);
    }

    private void comandoElegido(){
        this.posicionActual = cte.POS_OPERACION;

        if (parametroActual().equals(cte.NUEVO)){
            System.out.println("hacer Nuevo");
            if (siguienteParametro().equals(cte.SERVICIO)){
                System.out.println("Sobre Servicio");
                cargarServicio();
                mostrarServicio();
            } else if (parametroActual().equals(cte.MES)){
                System.out.println("Sobre Mes");
                cargarMes();
                mostrarMes();
            } else {
                System.out.println("ERROR NUEVO");
            }
        } else if (parametroActual().equals(cte.MODIFICAR)){
            System.out.println("hacer Modificacion");
            if (siguienteParametro().equals(cte.SERVICIO)){
                System.out.println("Sobre Servicio");
                cargarServicio();
                mostrarServicio();
            } else if (parametroActual().equals(cte.MES)){
                System.out.println("Sobre Mes");
                cargarMes();
                mostrarMes();
            } else {
                System.out.println("ERROR MODIFICAR");
            }
        } else if (parametroActual().equals(cte.ELIMINAR)){
            System.out.println("hacer Eliminacion");
            if (siguienteParametro().equals(cte.SERVICIO)){
                System.out.println("Sobre Servicio");
                cargarServicio();
                mostrarServicio();
            } else if (parametroActual().equals(cte.MES)){
                System.out.println("Sobre Mes");
                cargarMes();
                mostrarMes();
            } else {
                System.out.println("ERROR ELIMINAR");
            }
        } else if (parametroActual().equals(cte.SALIR_PROGRAMA)){
            System.out.println("Saliendo .........");
        } else {
            System.out.println("Comando Error");
        }
    }

    private boolean verificarLetras(){
        return true;
    }

    private boolean verificarNumeros(){
        return true;
    }

/*    Para cargar servicio. no necesita id
    2 - nombre*/
    private void cargarServicio(){
        this.servicios = new Servicios(siguienteParametro());
    }
    /*Para pedir servicio. necesita id*/
    private void pedirServicio(){
        int id = Integer.parseInt(siguienteParametro());
        String nombre = siguienteParametro();
        this.servicios = new Servicios(nombre, id);
    }

    /*mostrar el servicio*/
    private void mostrarServicio(){
        System.out.println("Ingresaste: "+this.servicios.toString());
    }
    /*mostrar el mes*/
    private void mostrarMes(){
        System.out.println("Ingresaste: "+this.mes.toString());
    }

    /*Para cargar mes. No necesita id
    * 2 - fecha
    * 3 - pago*/
    private void cargarMes(){
        pedirServicio();
        LocalDate fecha = LocalDate.parse(siguienteParametro());
        double pago = Double.parseDouble(siguienteParametro());
        this.mes = new Mes(this.servicios, fecha, pago);
    }
    /*Para pedir mes. necesita id
    * 2 - id
    * 3 - fecha
    * 4 - pago*/
    private void pedirMes(){
        int id = Integer.parseInt(parametroActual());
        LocalDate fecha = LocalDate.parse(siguienteParametro());
        double pago = Double.parseDouble(siguienteParametro());
        this.mes = new Mes(id, this.servicios, fecha, pago);
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
