/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.List;
import negocio.ContribuinteDAO;
import negocio.Contribuinte;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author p-karol
 */
public class ContribuinteDAOJavaDb implements ContribuinteDAO{
    private static ContribuinteDAOJavaDb ref;
    
    public static ContribuinteDAOJavaDb getInstance() throws ContribuinteDAOException {
        if (ref == null)
            ref = new ContribuinteDAOJavaDb();
        return ref;
    }
    
    private ContribuinteDAOJavaDb() throws ContribuinteDAOException {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new ContribuinteDAOException("JdbcOdbDriver not found!!");
        }
    }
    
    
    //public Contribuinte(String nome, String cpf, int idade, int numDependentes, double contrubuicaoPrevidenciaria, double totalRendimentos) {
    
    
    private static void createDB() throws ContribuinteDAOException {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sql = "CREATE TABLE Contribuinte ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF VARCHAR(11) NOT NULL,"
                    + "IDADE INTEGER,"
                    + "DEPENDENTES INTEGER,"
                    + "CONTRIBUICAO DOUBLE,"
                    + "RENDIMENTOS DOUBLE,"
                    + ")";
            sta.executeUpdate(sql);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new ContribuinteDAOException(ex.getMessage());
        }
    }
    
    private static Connection getConnection() throws SQLException {
        //derbyDB sera o nome do diretorio criado localmente
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }
    
    @Override
    public boolean adicionar(Contribuinte c) throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO CONTRIBUINTE (NOME, CPF, IDADE, DEPENDENTES, CONTRIBUICAO, RENDIMENTOS) VALUES (?,?,?,?,?,?)" //                             1        2         3            4          5             6
                    );
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setInt(3, c.getIdade());
            stmt.setDouble(4, c.getNumeroDependentes());
            stmt.setDouble(5, c.getContrubuicaoPrevidenciaria());
            stmt.setDouble(6, c.getTotalRendimentos());
            
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao adicionar.", ex);
        }
    }
}
