package Informacion;

import java.util.ArrayList;

public class Mes {
    private Servicios servicio;
    private Pagos pago;
    private int idMes;

//    Para generar mes
    public Mes(Servicios servicio, Pagos pago) {
        this.servicio = servicio;
        this.pago = pago;
    }

//    Para ver un mes cargado

    public Mes(Servicios servicio, Pagos pago, int idMes) {
        this.servicio = servicio;
        this.pago = pago;
        this.idMes = idMes;
    }

    /*Obtengo todos los parametros, en el orden:
    * - id mes
    * - id servicio
    * - nombre servicio
    * - fecha pago
    * - pago
    * */
    public ArrayList<String> obtenerMes(){
        ArrayList<String> datos = new ArrayList<String>();

        datos.add(Integer.toString(this.idMes));

        datos.add(Integer.toString(this.servicio.getId_Servicio()));
        datos.add(this.servicio.getNombre());

        datos.add(this.pago.getFecha().toString());
        datos.add(Integer.toString(this.pago.getPago()));

        return datos;
    }

    public Servicios getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public Pagos getPago() {
        return this.pago;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }
}
