package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/sistema_ti";
    private String user = "root";
    private String password = "Jp2500@#"; 
    
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

  
    public void inserirEquipamento(Equipamento eq) {
        String create = "insert into equipamentos (nome, defeito, dataBaixa) values (?, ?, ?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, eq.getNome());
            pst.setString(2, eq.getDefeito());
            pst.setString(3, eq.getDataBaixa());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public ArrayList<Equipamento> listarEquipamentos() {
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        String read = "select * from equipamentos order by nome";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nome = rs.getString(2);
                String defeito = rs.getString(3);
                String data = rs.getString(4);
                equipamentos.add(new Equipamento(id, nome, defeito, data));
            }
            con.close();
            return equipamentos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void selecionarEquipamento(Equipamento eq) {
        String select = "select * from equipamentos where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, eq.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                eq.setId(rs.getString(1));
                eq.setNome(rs.getString(2));
                eq.setDefeito(rs.getString(3));
                eq.setDataBaixa(rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void alterarEquipamento(Equipamento eq) {
        String update = "update equipamentos set nome=?, defeito=?, dataBaixa=? where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, eq.getNome());
            pst.setString(2, eq.getDefeito());
            pst.setString(3, eq.getDataBaixa());
            pst.setString(4, eq.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletarEquipamento(Equipamento eq) {
        String delete = "delete from equipamentos where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, eq.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}