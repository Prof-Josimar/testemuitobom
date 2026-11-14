<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/layout/cabecalho.jsp">
    <jsp:param name="titulo" value="Sucesso"/>
    <jsp:param name="menu" value="form"/>
</jsp:include>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-5">
        <div class="card shadow-sm text-center">
            <div class="card-body p-5">
                <div class="display-3 text-success mb-3">&#10004;</div>
                <h1 class="h3">Sucesso!</h1>
                <p class="text-muted mb-4">O CPF foi validado e cadastrado com sucesso.</p>
                <a href="${pageContext.request.contextPath}/formulario.jsp" class="btn btn-primary">Cadastrar outro</a>
                <a href="${pageContext.request.contextPath}/lista" class="btn btn-outline-secondary">Ver cadastrados</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/layout/rodape.jsp"/>
