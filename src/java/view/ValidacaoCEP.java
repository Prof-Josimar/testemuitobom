/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class ValidacaoCEP {


    public static boolean validarCep(String cep) {
        return cep.matches("\\d{8}");
    }

    
    public static String consultarCep(String cep) throws IOException {

        URL url = new URL(
                "https://viacep.com.br/ws/" + cep + "/json/"
        );

        HttpURLConnection conexao =
                (HttpURLConnection) url.openConnection();

        conexao.setRequestMethod("GET");

        Scanner resposta = new Scanner(conexao.getInputStream());

        String json = resposta.useDelimiter("\\A").next();

        resposta.close();
        conexao.disconnect();

        return json;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader leitor = new BufferedReader(
                new InputStreamReader(System.in)
        );

        System.out.print("Digite um CEP: ");

        String cep = leitor.readLine();

        if (!validarCep(cep)) {
            System.out.println("CEP incorreto");
            return;
        }

        String resposta = consultarCep(cep);

        if (resposta.contains("\"erro\": true")) {
            System.out.println("CEP não existente");
            return;
        }

        String rua = "";
        String bairro = "";
        String cidade = "";

        String[] dados = resposta.split(",");

        for (String dado : dados) {

            if (dado.contains("\"logradouro\"")) {
                rua = dado.split(":")[1].replace("\"", "");
            }

            if (dado.contains("\"bairro\"")) {
                bairro = dado.split(":")[1].replace("\"", "");
            }

            if (dado.contains("\"localidade\"")) {
                cidade = dado.split(":")[1].replace("\"", "");
            }
        }

        System.out.println("----- Endereço -----");
        System.out.println("Rua: " + rua);
        System.out.println("Bairro: " + bairro);
        System.out.println("Cidade: " + cidade);
    }
}



