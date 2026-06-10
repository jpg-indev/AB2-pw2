<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Editar Equipamento</title>
</head>
<body>
    <h1>Editar Laudo de Equipamento</h1>
    
    <form action="update" method="post">
        <fieldset>

            <input type="hidden" name="id" value="<% out.print(request.getAttribute("id")); %>">
            
            <p>
                <label>Nome do Equipamento:</label><br>
                <input type="text" name="nome" value="<% out.print(request.getAttribute("nome")); %>" required>
            </p>
            <p>
                <label>Defeito Apresentado:</label><br>
                <textarea name="defeito" rows="3" required><% out.print(request.getAttribute("defeito")); %></textarea>
            </p>
            <p>
                <label>Data de Baixa:</label><br>
                <input type="date" name="dataBaixa" value="<% out.print(request.getAttribute("dataBaixa")); %>" required>
            </p>
            <p><input type="submit" value="Salvar Alterações"></p>
        </fieldset>
    </form>
</body>
</html>