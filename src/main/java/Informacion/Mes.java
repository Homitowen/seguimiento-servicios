package Informacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Mes {
    private int idMes;
    private Servicios servicio;
    private LocalDate fechaPago;
    private double pago;

//    Para generar mes. no tiene idMes
    public Mes(Servicios servicio, LocalDate fechaPago, double pago) {
        this.servicio = servicio;
        this.fechaPago = fechaPago;
        this.pago = pago;
    }


//    Para ver / modificar / eliminar un mes cargado. tiene idMes
    public Mes(int idMes, Servicios servicio, LocalDate fechaPago, double pago) {
        this.idMes = idMes;
        this.servicio = servicio;
        this.fechaPago = fechaPago;
        this.pago = pago;
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

        datos.add(this.fechaPago.toString());
        datos.add(Double.toString(this.pago));

        return datos;
    }

    public int getIdMes() {
        return this.idMes;
    }

    public void setIdMes(int idMes) {
        this.idMes = idMes;
    }

    public Servicios getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public LocalDate getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getPago() {
        return this.pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
}
