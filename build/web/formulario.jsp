<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/layout/cabecalho.jsp">
    <jsp:param name="titulo" value="Cadastro de CPF"/>
    <jsp:param name="menu" value="form"/>
</jsp:include>

<%
    // mensagem de erro enviada pelo ValidaServlet (null quando não há erro)
    String erro = (String) request.getAttribute("erro");
%>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-5">
        <div class="card shadow-sm">
            <div class="card-body p-4">
                <h1 class="h4 mb-4">Cadastro de CPF</h1>

                <% if (erro != null) {%>
                <div class="alert alert-danger" role="alert"><%= erro%></div>
                <% }%>

                <form action="${pageContext.request.contextPath}/ValidaServlet" method="POST">
                    <div class="mb-3">
                        <label for="cpf" class="form-label">CPF</label>
                        <input type="text" class="form-control <%= erro != null ? "is-invalid" : ""%>"
                               id="cpf" name="cpf" placeholder="000.000.000-00" maxlength="14"
                               autofocus required value="${cpf}">
                        <div class="form-text">Pode digitar com ou sem pontos e traço.</div>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <a class="btn btn-outline-secondary"
                           href="${pageContext.request.contextPath}/geraFaker?destino=formulario">Gerar CPF de teste</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/rodape.jsp"/>
