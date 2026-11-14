<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/layout/cabecalho.jsp">
    <jsp:param name="titulo" value="Dados Faker"/>
    <jsp:param name="menu" value="faker"/>
</jsp:include>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card shadow-sm">
            <div class="card-header fw-bold">Dados gerados com DataFaker</div>
            <div class="card-body">
                <dl class="row mb-0">
                    <dt class="col-sm-3">Nome</dt>
                    <dd class="col-sm-9">${nome}</dd>
                    <dt class="col-sm-3">E-mail</dt>
                    <dd class="col-sm-9">${email}</dd>
                    <dt class="col-sm-3">CPF</dt>
                    <dd class="col-sm-9 mb-0">${cpf}</dd>
                </dl>
            </div>
            <div class="card-footer d-flex gap-2">
                <a href="${pageContext.request.contextPath}/geraFaker" class="btn btn-primary">Gerar outros</a>
                <a href="${pageContext.request.contextPath}/formulario.jsp" class="btn btn-outline-secondary">Ir para o formulário</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/rodape.jsp"/>
