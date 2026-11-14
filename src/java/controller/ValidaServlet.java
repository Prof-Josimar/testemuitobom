package controller;

import dao.PessoaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import util.CpfUtil;

@WebServlet(name = "ValidaServlet", urlPatterns = {"/ValidaServlet"})
public class ValidaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fica só com os números (assim aceitamos com ou sem pontos e traço)
        String cpf = CpfUtil.limpar(request.getParameter("cpf"));
        PessoaDAO dao = new PessoaDAO();

        if (!CpfUtil.valido(cpf)) {
            voltarComErro(request, response, cpf, "CPF inválido!");
        } else if (dao.existe(cpf)) {
            voltarComErro(request, response, cpf, "Este CPF já está cadastrado!");
        } else {
            dao.inserir(new Pessoa(cpf));
            response.sendRedirect("sucesso.jsp");
        }
    }

    // Quem abrir /ValidaServlet digitando na barra de endereço volta ao formulário
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("formulario.jsp");
    }

    private void voltarComErro(HttpServletRequest request, HttpServletResponse response,
            String cpf, String mensagem) throws ServletException, IOException {
        request.setAttribute("erro", mensagem);
        request.setAttribute("cpf", cpf); // devolve o que foi digitado para o usuário corrigir
        request.getRequestDispatcher("/formulario.jsp").forward(request, response);
    }
}
