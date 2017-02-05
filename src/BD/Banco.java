/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


/**
 *
 * @author luan
 */
public class Banco {
    private static Statement stmt;
    private static Statement stmt2;
    private ResultSet rs;
    public Connection conn;
    private static final Banco b = new Banco();
    public Banco(){
        String url = "jdbc:mysql://localhost:3306/banco_de_questoes";
        String usr = "root";
        String pas = "adminadmin";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pas);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                                        ResultSet.CONCUR_READ_ONLY);
            stmt2 = conn.createStatement();
            System.out.println("Tudo ok, conexão feita!");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }
     /* Cadastros de usuarios e administradores*/
        public void cadastrarProfAluno(String nome,String login,String senha, String nivel) throws SQLException{
            String sql = "insert into aluno (nome,matricula,senha,nivel,data) values " +
                         "(?,?,?,?,?);";
            //pegando a data atual
            Calendar c = Calendar.getInstance();
            String data = c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH);
            
            PreparedStatement stmtlocal = conn.prepareStatement(sql);
            stmtlocal = conn.prepareStatement(sql);

            stmtlocal.setString(1, nome);
            stmtlocal.setString(2, login);
            stmtlocal.setString(3, senha);
            stmtlocal.setString(4, nivel);
            stmtlocal.setString(5, data);
            stmtlocal.execute();
            stmtlocal.close();
        }
        public void cadastrarPergunta(String pergunta,String resposta, String materia) throws SQLException{
            String sql = "insert into Questao (pergunta,resposta,materia) values " +
                         "(?,?,?);";
            //pegando a data atual
            PreparedStatement stmtlocal = conn.prepareStatement(sql);
            stmtlocal = conn.prepareStatement(sql);

            stmtlocal.setString(1, pergunta);
            stmtlocal.setString(2, resposta);
            stmtlocal.setString(3, materia);
            stmtlocal.execute();
            stmtlocal.close();
        }
        public void atualizaData(String matricula) throws SQLException{
            String sql = "update aluno "
                    + " set data = ?"
                    + " where matricula = ?";
            Calendar c = Calendar.getInstance();
            String data = c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH);
            
            PreparedStatement stmtlocal = conn.prepareStatement(sql);
            stmtlocal = conn.prepareStatement(sql);

            stmtlocal.setString(1, data);
            stmtlocal.setString(2, matricula);
            stmtlocal.execute();
            stmtlocal.close();
        }
        public String getSenha(String matricula) throws SQLException{
            String sql = "select senha from aluno where matricula = '"+matricula+"'";
            ResultSet rs = stmt.executeQuery(sql);
            String senha = "";
            while(rs.next()){
                senha = rs.getString("senha");
            }
            return senha;
        }
        public String getNivel(String matricula) throws SQLException{
            String sql = "select nivel from aluno where matricula = '"+matricula+"'";
            ResultSet rs = stmt.executeQuery(sql);
            String senha = "";
            while(rs.next()){
                senha = rs.getString("nivel");
            }
            return senha;
        }
        public String getNome(String matricula) throws SQLException{
            String sql = "select nome from aluno where matricula = '"+matricula+"'";
            ResultSet rs = stmt.executeQuery(sql);
            String senha = "";
            while(rs.next()){
                senha = rs.getString("nome");
            }
            return senha;
        }
        public String getData(String matricula) throws SQLException{
            String sql = "select data from aluno where matricula = '"+matricula+"'";
            ResultSet rs = stmt.executeQuery(sql);
            String senha = "";
            while(rs.next()){
                senha = rs.getString("data");
            }
            return senha;
        }
        public ResultSet getPerguntas(String materia) throws SQLException{
            String sql = "SELECT * FROM questao " +
                         " where materia = '"+materia+"'"+
                         " ORDER BY RAND() LIMIT 8;";
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
}