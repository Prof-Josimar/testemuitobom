/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import net.datafaker.Faker;
import java.util.Locale;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/geraFaker2")
public class GeraFakerServlet2 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Cria o Faker em português do Brasil
        Faker faker = new Faker(new Locale("pt", "BR"));

        // 2. Gera os dados falsos
        String nomeFake = faker.name().fullName();
        String emailFake = faker.internet().emailAddress();
        String cpfFake = faker.cpf().valid(); // ou gere um CPF formatado

        // 3. Guarda os dados nos atributos do request (os "gets/sets" do request)
        request.setAttribute("nome", nomeFake);
        request.setAttribute("email", emailFake);
        request.setAttribute("cpf", cpfFake);

        // 4. Encaminha (forward) para a página JSP exibir
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }
}