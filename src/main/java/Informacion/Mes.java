package Informacion;

public class Mes {
    private Servicios servicio;
    private Pagos pago;

    public Mes(Servicios servicio, Pagos pago) {
        this.servicio = servicio;
        this.pago = pago;
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
