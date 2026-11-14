
package app;

import java.util.ArrayList;
import java.util.List;

public class ListaRemoveErro {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("Lista:");

        for (Integer num : numeros) {

            System.out.println("Analisando: " + num);

            if (num == 30) {
                numeros.remove(num); // ERRO!
            }
        }

        System.out.println(numeros);
    }
}
