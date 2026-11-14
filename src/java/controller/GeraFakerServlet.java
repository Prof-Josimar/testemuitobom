package controller;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.datafaker.Faker;

/**
 * Gera dados falsos e encaminha para uma página.
 *   /geraFaker                    -> mostra os dados em exibeFaker.jsp
 *   /geraFaker?destino=formulario -> preenche o CPF em formulario.jsp
 * (Esta classe substitui GeraFakerServlet e GeraFakerServlet2, que eram iguais.)
 */
@WebServlet("/geraFaker")
public class GeraFakerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Cria o Faker em português do Brasil
        Faker faker = new Faker(new Locale("pt", "BR"));

        // 2. Gera os dados falsos e guarda no request para o JSP exibir
        request.setAttribute("nome", faker.name().fullName());
        request.setAttribute("email", faker.internet().emailAddress());
        request.setAttribute("cpf", faker.cpf().valid());

        // 3. Escolhe a página. Só aceitamos destinos conhecidos:
        //    nunca use o texto digitado pelo usuário direto no forward.
        String pagina = "/exibeFaker.jsp";
        if ("formulario".equals(request.getParameter("destino"))) {
            pagina = "/formulario.jsp";
        }

        // 4. Encaminha (forward) para a página JSP
        request.getRequestDispatcher(pagina).forward(request, response);
    }
}
