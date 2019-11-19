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
        
        /*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
                */
    }
    
    private static void createDB() throws ContribuinteDAOException {
        System.out.println("Vem aqui");
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
                    + "RENDIMENTOS DOUBLE"
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
                    "INSERT INTO Contribuinte (NOME, CPF, IDADE, DEPENDENTES, CONTRIBUICAO, RENDIMENTOS) VALUES (?,?,?,?,?,?)" //                             1        2         3            4          5             6
                    );
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setInt(3, c.getIdade());
            stmt.setInt(4, c.getNumeroDependentes());
            stmt.setDouble(5, c.getContribuicaoPrevidenciaria());
            stmt.setDouble(6, c.getTotalRendimentos());
            System.out.println(stmt.getWarnings());
            
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            System.out.println("falhando");
            throw new ContribuinteDAOException("Falha ao adicionar.", ex);
        }
    }
    
    @Override
    public List<Contribuinte> getTodos() throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Contribuinte");
            List<Contribuinte> lista = new ArrayList<Contribuinte>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String cpf = resultado.getString("CPF");
                int idade = resultado.getInt("IDADE");
                int numeroDependentes = resultado.getInt("DEPENDENTES");
                double contribuicaoPrevidenciaria = resultado.getDouble("CONTRIBUICAO");
                double totalRendimentos = resultado.getDouble("RENDIMENTOS");
                Contribuinte c = new Contribuinte(nome, cpf, idade, numeroDependentes, contribuicaoPrevidenciaria,  totalRendimentos);
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao buscar contribuintes.", ex);
        }    }
}
