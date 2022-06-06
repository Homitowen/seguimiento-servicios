package Informacion;

import java.util.Calendar;

public class Pagos {
    private Calendar fecha;
    private int Pago;

    public Pagos(Calendar fecha, int pago) {
        this.fecha = fecha;
        Pago = pago;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getPago() {
        return this.Pago;
    }

    public void setPago(int pago) {
        Pago = pago;
    }
}
