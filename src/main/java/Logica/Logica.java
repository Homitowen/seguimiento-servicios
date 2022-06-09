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
    ArrayList<String> parametrosCargados;

    {
        parametrosCargados = new ArrayList<String>(cte.MAX_PARAMETROS);
    }

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

    /*Devueelve el parametro actual de parametrosCargados*/
    private String parametroActual(){
        return parametrosCargados.get(this.posicionActual);
    }

    /*Obtener el siguiente parametro de parametrosCargados*/
    private String siguienteParametro(){
        this.posicionActual++;
        return parametrosCargados.get(this.posicionActual);
    }

    private boolean verificarComando(){
        if (this.parametrosCargados.get(cte.POS_COM).equals(cte.NUEVO)){
            System.out.println("hacer Nuevo");
            return true;
        } else if (this.parametrosCargados.get(cte.POS_COM).equals(cte.MODIFICAR)){
            System.out.println("hacer Modificacion");
            return true;
        } else if (this.parametrosCargados.get(cte.POS_COM).equals(cte.ELIMINAR)){
            System.out.println("hacer Eliminacion");
            return true;
        } else if (this.parametrosCargados.get(cte.POS_COM).equals(cte.SALIR_PROGRAMA)){
            System.out.println("Saliendo .........");
        } else {
            System.out.println("Comando Error");
        }
        return false;
    }

    private boolean verificarSubComando(){

        try {

            this.posicionActual = cte.POS_DATOS;

            if (this.parametrosCargados.get(cte.POS_SUBCOM).equals(cte.MES)){
                System.out.println("Sobre mes");
                return true;
            } else if (this.parametrosCargados.get(cte.POS_SUBCOM).equals(cte.SERVICIO)){
                System.out.println("sobre servicio");
                cargarServicio();
                mostrarServicio();
                return true;
            } else if (this.parametrosCargados.get(cte.POS_SUBCOM).equals(cte.PAGO)){
                System.out.println("sobre pago");
                return true;
            } else {
                System.out.println("Subcomando Error");
            }
            return false;

        } catch (Exception e){
            System.out.println("Faltó subcomando");
        }

        return false;
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
        this.servicios = new Servicios(parametroActual());
    }
    /*Para pedir servicio. necesita id*/
    private void pedirServicio(){
        int id = Integer.parseInt(parametroActual());
        String nombre = siguienteParametro();
        this.servicios = new Servicios(nombre, id);
    }

    /*mostrar el servicio*/
    private void mostrarServicio(){
        System.out.println("Ingresaste: "+this.servicios.toString());
    }

    /*Para cargar mes. No necesita id
    * 2 - fecha
    * 3 - pago*/
    private void cargarMes(){
        LocalDate fecha = LocalDate.parse(siguienteParametro());
        double pago = Double.parseDouble(siguienteParametro());
        this.mes = new Mes(this.servicios, fecha, pago);
    }
    /*Para pedir mes. necesita id
    * 2 - id
    * 3 - fecha
    * 4 - pago*/
    private void pedirMes(){
        int id = Integer.parseInt(this.parametrosCargados.get(cte.POS_MES_ID));
        LocalDate fecha = LocalDate.parse(this.parametrosCargados.get(3));
        double pago = Double.parseDouble(this.parametrosCargados.get(4));
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
