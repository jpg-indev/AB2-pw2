package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.Equipamento;


@WebServlet(urlPatterns = {"/Controlador", "/insert", "/read", "/select", "/update", "/delete"})
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DAO dao = new DAO();
    Equipamento equipamento = new Equipamento();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        if (action.equals("/read")) {
            listarEquipamentos(request, response);
        } else if (action.equals("/select")) {
            selecionarEquipamento(request, response);
        } else if (action.equals("/delete")) {
            removerEquipamento(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        if (action.equals("/insert")) {
            novoEquipamento(request, response);
        } else if (action.equals("/update")) {
            editarEquipamento(request, response);
        }
    }
    protected void novoEquipamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        equipamento.setNome(request.getParameter("nome"));
        equipamento.setDefeito(request.getParameter("defeito"));
        equipamento.setDataBaixa(request.getParameter("dataBaixa"));
        
        dao.inserirEquipamento(equipamento);
        response.sendRedirect("read");
    }

    protected void listarEquipamentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Equipamento> lista = dao.listarEquipamentos();
        request.setAttribute("equipamentos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("listarEquipamentos.jsp");
        rd.forward(request, response);
    }

    protected void selecionarEquipamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        equipamento.setId(id);
        dao.selecionarEquipamento(equipamento);
        
        request.setAttribute("id", equipamento.getId());
        request.setAttribute("nome", equipamento.getNome());
        request.setAttribute("defeito", equipamento.getDefeito());
        request.setAttribute("dataBaixa", equipamento.getDataBaixa());
        
        RequestDispatcher rd = request.getRequestDispatcher("editarEquipamento.jsp");
        rd.forward(request, response);
    }

    protected void editarEquipamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        equipamento.setId(request.getParameter("id"));
        equipamento.setNome(request.getParameter("nome"));
        equipamento.setDefeito(request.getParameter("defeito"));
        equipamento.setDataBaixa(request.getParameter("dataBaixa"));
        
        dao.alterarEquipamento(equipamento);
        response.sendRedirect("read");
    }

    protected void removerEquipamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        equipamento.setId(id);
        dao.deletarEquipamento(equipamento);
        response.sendRedirect("read");
    }
}