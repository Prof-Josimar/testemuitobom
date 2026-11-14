package controller;

import dao.PessoaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.CpfUtil;

/**
 * GET  /lista -> mostra os CPFs cadastrados
 * POST /lista -> remove o CPF recebido e volta para a lista
 */
@WebServlet("/lista")
public class ListaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PessoaDAO dao = new PessoaDAO();
        request.setAttribute("lista", dao.listar());
        // lista.jsp fica dentro de WEB-INF: só é acessível passando por este servlet
        request.getRequestDispatcher("/WEB-INF/lista.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = CpfUtil.limpar(request.getParameter("cpf"));
        new PessoaDAO().remover(cpf);
        response.sendRedirect(request.getContextPath() + "/lista");
    }
}
