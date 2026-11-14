
package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListaRemove {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("Lista completa:");

        for (Integer num : numeros) {
            System.out.print(num + " ");
        }

        System.out.print("\n\nDigite o valor que deseja remover: ");
        int valor = sc.nextInt();

        Iterator<Integer> it = numeros.iterator();

        boolean encontrou = false;

        while (it.hasNext()) {

            Integer num = it.next();

            if (num == valor) {
                it.remove();
                encontrou = true;
                break;
            }
        }

        if (encontrou) {
            System.out.println("Valor removido com sucesso!");
        } else {
            System.out.println("Valor não encontrado!");
        }

        System.out.println("\nLista após remoção:");

        for (Integer num : numeros) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
