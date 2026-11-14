<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="/WEB-INF/layout/cabecalho.jsp">
    <jsp:param name="titulo" value="CPFs cadastrados"/>
    <jsp:param name="menu" value="lista"/>
</jsp:include>

<%
    // lista enviada pelo ListaServlet
    List<Pessoa> lista = (List<Pessoa>) request.getAttribute("lista");
%>

<h1 class="h3 mb-4">CPFs cadastrados</h1>

<% if (lista.isEmpty()) { %>
<div class="alert alert-info">
    Nenhum CPF cadastrado ainda.
    <a href="${pageContext.request.contextPath}/formulario.jsp" class="alert-link">Cadastre o primeiro</a>.
</div>
<% } else { %>
<div class="card shadow-sm">
    <div class="table-responsive">
        <table class="table table-striped table-hover align-middle mb-0">
            <thead class="table-dark">
                <tr>
                    <th style="width: 60px">#</th>
                    <th>CPF</th>
                    <th class="text-end">Ações</th>
                </tr>
            </thead>
            <tbody>
                <% int numero = 1;
                   for (Pessoa p : lista) { %>
                <tr>
                    <td><%= numero++ %></td>
                    <td><%= p.getCpfFormatado() %></td>
                    <td class="text-end">
                        <form action="${pageContext.request.contextPath}/lista" method="POST" class="d-inline"
                              onsubmit="return confirm('Remover este CPF?');">
                            <input type="hidden" name="cpf" value="<%= p.getCpf() %>">
                            <button type="submit" class="btn btn-sm btn-outline-danger">Remover</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <div class="card-footer text-muted small">Total: <%= lista.size() %></div>
</div>
<% } %>

<jsp:include page="/WEB-INF/layout/rodape.jsp"/>
