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

    public ArrayList<String> obtenerMes(){

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
