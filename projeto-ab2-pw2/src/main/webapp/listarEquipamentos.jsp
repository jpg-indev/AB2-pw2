<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Equipamento" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Equipamentos Avariados</title>
</head>
<body>
    <h1>Histórico de Baixas Patrimoniais</h1>
    
    <table>
        <tr>
            <th>Nome</th>
            <th>Defeito</th>
            <th>Data da Baixa</th>
            <th>Opções</th>
        </tr>
        <% 
            ArrayList<Equipamento> lista = (ArrayList<Equipamento>) request.getAttribute("equipamentos");
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) { 
        %>
            <tr>
                <td><%= lista.get(i).getNome() %></td>
                <td><%= lista.get(i).getDefeito() %></td>
                <td><%= lista.get(i).getDataBaixa() %></td>
                <td>
                    
                    <a href="select?id=<%= lista.get(i).getId() %>" class="btn" style="display:inline; padding: 5px 10px;">Editar</a>
                    <a href="delete?id=<%= lista.get(i).getId() %>" class="btn" style="display:inline; padding: 5px 10px; background-color: red;">Apagar</a>
                </td>
            </tr>
        <% 
                } 
            }
        %>
    </table>
    
    <br><a href="index.html" class="btn">Voltar ao Menu</a>
</body>
</html>