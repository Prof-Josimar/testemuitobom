<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="/WEB-INF/layout/cabecalho.jsp">
    <jsp:param name="titulo" value="Início"/>
    <jsp:param name="menu" value="inicio"/>
</jsp:include>

<div class="p-5 mb-4 bg-white border rounded-3 shadow-sm">
    <h1 class="display-6 fw-bold">Validador de CPF</h1>
    <p class="lead mb-4">
        Exercício com JSP, Servlet e DAO: digite um CPF, o sistema valida os dígitos
        verificadores e guarda os válidos em uma lista. Precisa de dados para testar?
        A biblioteca DataFaker gera para você.
    </p>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/formulario.jsp">Cadastrar CPF</a>
</div>

<div class="row g-4">
    <div class="col-md-4">
        <div class="card h-100 shadow-sm">
            <div class="card-body">
                <h2 class="h5 card-title">Cadastrar CPF</h2>
                <p class="card-text text-muted">Formulário com validação feita no servidor.</p>
                <a href="${pageContext.request.contextPath}/formulario.jsp" class="stretched-link">Abrir formulário</a>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card h-100 shadow-sm">
            <div class="card-body">
                <h2 class="h5 card-title">Cadastrados</h2>
                <p class="card-text text-muted">Lista dos CPFs salvos, com opção de remover.</p>
                <a href="${pageContext.request.contextPath}/lista" class="stretched-link">Ver lista</a>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card h-100 shadow-sm">
            <div class="card-body">
                <h2 class="h5 card-title">Dados Faker</h2>
                <p class="card-text text-muted">Nome, e-mail e CPF falsos gerados na hora.</p>
                <a href="${pageContext.request.contextPath}/geraFaker" class="stretched-link">Gerar dados</a>
            </div>
        </div>
    </div>
</div>

<div class="card shadow-sm mt-4">
    <div class="card-header fw-bold">Informações do servidor</div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item"><strong>Servidor:</strong> <%= application.getServerInfo() %></li>
        <li class="list-group-item"><strong>Servlet API:</strong> <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %></li>
        <li class="list-group-item"><strong>Versão do Java:</strong> <%= System.getProperty("java.version") %></li>
    </ul>
</div>

<jsp:include page="/WEB-INF/layout/rodape.jsp"/>
