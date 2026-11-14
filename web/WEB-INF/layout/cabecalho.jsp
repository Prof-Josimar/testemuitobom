<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
    Cabeçalho comum a todas as páginas (HTML até a abertura do <main>).
    Recebe dois parâmetros:  titulo  (título da aba)  e  menu  (item que fica ativo).
--%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${param.titulo} | Validador de CPF</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex flex-column min-vh-100">

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/index.jsp">Validador de CPF</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#menuPrincipal" aria-controls="menuPrincipal"
                        aria-expanded="false" aria-label="Abrir menu">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menuPrincipal">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link ${param.menu == 'inicio' ? 'active' : ''}"
                               href="${pageContext.request.contextPath}/index.jsp">Início</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${param.menu == 'form' ? 'active' : ''}"
                               href="${pageContext.request.contextPath}/formulario.jsp">Cadastrar CPF</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${param.menu == 'lista' ? 'active' : ''}"
                               href="${pageContext.request.contextPath}/lista">Cadastrados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${param.menu == 'faker' ? 'active' : ''}"
                               href="${pageContext.request.contextPath}/geraFaker">Dados Faker</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <main class="container py-4 flex-grow-1">
