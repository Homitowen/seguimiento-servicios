package Principal;

import Informacion.Constantes;
import Logica.Logica;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner cargar = new Scanner(System.in);
        String lineaEntrada;
        String condicion = "";
        Constantes cte = new Constantes();

        Logica logica = new Logica();

        while (!logica.isEstadoPrograma()) {
            System.out.println("INGRESAR COMANDO");
            lineaEntrada = cargar.nextLine();
            logica = new Logica(lineaEntrada);

        }



    }
}
