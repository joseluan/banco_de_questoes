/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
/**
 *
 * @author Luan
 */
public class Method {

    /* Cadastros de usuarios e administradores*/
    public void cadastrarProfAluno(String nome,String login,String senha, String nivel) throws SQLException, ClassNotFoundException{         Conexao banco = new Conexao();
            Connection conn = banco.getConn();
            
        String sql = "insert into aluno (nome,matricula,senha,nivel,data) values " +
                     "(?,?,?,?,?);";
        //pegando a data atual
        Calendar c = Calendar.getInstance();
        String data = c.get(Calendar.YEAR)+"-"+
                      (c.get(Calendar.MONTH)+1)+"-"+
                      c.get(Calendar.DAY_OF_MONTH);
            
        PreparedStatement stmtlocal;
        stmtlocal = conn.prepareStatement(sql);

        stmtlocal.setString(1, nome);
        stmtlocal.setString(2, login);
        stmtlocal.setString(3, senha);
        stmtlocal.setString(4, nivel);   
        stmtlocal.setString(5, data);
        stmtlocal.execute();
        stmtlocal.close();
        conn.close();
    }
    public void cadastrarPergunta(String pergunta,String resposta, String materia) throws SQLException, ClassNotFoundException{
        Conexao banco = new Conexao();
        Connection conn = banco.getConn();
        String sql = "insert into Questao (pergunta,resposta,materia) values " +
                     "(?,?,?);";
        //pegando a data atual
        PreparedStatement stmtlocal;
        stmtlocal = conn.prepareStatement(sql);

        stmtlocal.setString(1, pergunta);
        stmtlocal.setString(2, resposta);
        stmtlocal.setString(3, materia);
        stmtlocal.execute();
        stmtlocal.close();
        conn.close();
    }
    public void atualizaData(String matricula) throws SQLException, ClassNotFoundException{
        Conexao banco = new Conexao();
        try (Connection conn = banco.getConn()) {
            String sql = "update aluno "+
                         " set data = ?" +
                         " where matricula = ?";
            Calendar c = Calendar.getInstance();
            String data = c.get(Calendar.YEAR)+"-"+
                          (c.get(Calendar.MONTH)+1)+"-"+
                          c.get(Calendar.DAY_OF_MONTH);

            PreparedStatement stmtlocal;
            stmtlocal = conn.prepareStatement(sql);

            stmtlocal.setString(1, data);
            stmtlocal.setString(2, matricula);
            stmtlocal.execute();
            stmtlocal.close();
        }
    }
    public String getSenha(String matricula) throws SQLException, ClassNotFoundException{
        Conexao b = new Conexao();
        Connection conexao = b.getConn();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select senha from aluno where matricula = '"+matricula+"'";
        ResultSet rs = stmt.executeQuery(sql);
        String senha = "";
        while(rs.next()){
            senha = rs.getString("senha");
        }
        stmt.close();
        return senha;
    }
    public String getNivel(String matricula) throws SQLException, ClassNotFoundException{
        Conexao b = new Conexao();
        Connection conexao = b.getConn();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
        String sql = "select nivel from aluno where matricula = '"+matricula+"'";
        ResultSet rs = stmt.executeQuery(sql);
        String senha = "";
        while(rs.next()){
            senha = rs.getString("nivel");
        }
        stmt.close();
        conexao.close();
           
        return senha;
    }
    public String getNome(String matricula) throws SQLException, ClassNotFoundException{
        Conexao b = new Conexao();
        Connection conexao = b.getConn();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
        String sql = "select nome from aluno where matricula = '"+matricula+"'";
        ResultSet rs = stmt.executeQuery(sql);
        String senha = "";
        while(rs.next()){
            senha = rs.getString("nome");
        }
        stmt.close();
        conexao.close();
            
        return senha;
    }
    public String getData(String matricula) throws SQLException, ClassNotFoundException{
        Conexao b = new Conexao();
        Connection conexao = b.getConn();
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
        String sql = "select data from aluno where matricula = '"+matricula+"'";
        ResultSet rs = stmt.executeQuery(sql);
        String senha = "";
        while(rs.next()){
            senha = rs.getString("data");
        }
        stmt.close();
        conexao.close();
            
        return senha;
    }
}
