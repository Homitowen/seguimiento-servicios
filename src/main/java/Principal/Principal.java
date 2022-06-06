package Principal;

import Informacion.Constantes;

import java.sql.Connection;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner cargar = new Scanner(System.in);
        String frase;
        String condicion = "";
        Constantes cte = new Constantes();

        System.out.println("INGRESAR COMANDO");
        frase = cargar.nextLine();

        System.out.println(frase);

        while (condicion != cte.SALIR_PROGRAMA) {

            System.out.println("INGRESAR COMANDO");
            frase = cargar.nextLine();

            System.out.println(frase);

        }



    }
}
