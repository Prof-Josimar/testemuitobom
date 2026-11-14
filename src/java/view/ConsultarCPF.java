/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;


public class ConsultarCPF {


   public static void main(String[] args) throws IOException {


       BufferedReader teclado = new BufferedReader(
               new InputStreamReader(System.in)
       );


       System.out.println("Digite o seu CEP: ");
       String cep = teclado.readLine();


      
       if (cep.matches("[0-9]{8}")) {


           System.out.println("CEP valido!");


           abrirSite("https://viacep.com.br/ws/" + cep + "/json/");


       } else {
           System.out.println("CEP invalido! Digite 8 numeros.");
       }
   }


   public static void abrirSite(String url) {
       try {
           if (Desktop.isDesktopSupported()) {
               Desktop.getDesktop().browse(new URI(url));
           } else {
               System.out.println("Abertura do navegador não suportada.");
           }


       } catch (Exception e) {
           System.out.println("Erro ao abrir o site: " + e.getMessage());
       }
   }


}

