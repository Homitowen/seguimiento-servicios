package Informacion;

public class Servicios {
    private String nombre;
    private int id_Servicio;
    private String enlaceWeb;

//    Para cuando se crean
    public Servicios(String nombre, String enlaceWeb) {
        this.nombre = nombre;
        this.enlaceWeb = enlaceWeb;
    }

//    Para cuando necesito acceder a ellos
    public Servicios(String nombre, int id_Servicio) {
        this.nombre = nombre;
        this.id_Servicio = id_Servicio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_Servicio() {
        return this.id_Servicio;
    }

    public void setId_Servicio(int id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    public String getEnlaceWeb() {
        return this.enlaceWeb;
    }

    public void setEnlaceWeb(String enlaceWeb) {
        this.enlaceWeb = enlaceWeb;
    }

    @Override
    public String toString() {
        return "Servicios{" +
                "nombre='" + nombre + '\'' +
                ", id_Servicio=" + id_Servicio + "" +
                ", enlace=" + enlaceWeb +
                '}';
    }
}
