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
            lineaEntrada = cargar.nextLine();

            System.out.println("INGRESAR COMANDO");
            logica = new Logica(lineaEntrada);

            System.out.println(logica.getLineaEntrada());

        }



    }
}
