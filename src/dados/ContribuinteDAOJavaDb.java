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
        // Cria o banco de dados vazio
        // Retirar do comentário se necessário
        /*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
        // Cria o banco de dados vazio
        // Retirar do comentário se necessário
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
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sql = "CREATE TABLE Pessoas ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "TELEFONE CHAR(8) NOT NULL,"
                    + "SEXO CHAR(1) NOT NULL"
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
    public boolean adicionar(Contribuinte p) throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO PESSOAS (NOME, TELEFONE, SEXO) VALUES (?,?,?)" //                             1        2         3            4          5             6
                    );
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, Character.toString(p.getSexo()));
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao adicionar.", ex);
        }
    }

    @Override
    public Contribuinte getPessoaPorNome(String n) throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM PESSOAS WHERE NOME=?"
                    );
            stmt.setString(1, n);
            ResultSet resultado = stmt.executeQuery();
            Contribuinte p = null;
            if(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                p = new Contribuinte(nome, telefone, sexo.equals("M"));
            }
            return p;
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao buscar.", ex);
        }
    }

    @Override
    public List<Contribuinte> getHomens() throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='M'");
            List<Contribuinte> lista = new ArrayList<Contribuinte>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                Contribuinte p = new Contribuinte(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao buscar.", ex);
        }
    }

    @Override
    public List<Contribuinte> getMulheres() throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='F'");
            List<Contribuinte> lista = new ArrayList<Contribuinte>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                Contribuinte p = new Contribuinte(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao buscar.", ex);
        }    }

    @Override
    public List<Contribuinte> getTodos() throws ContribuinteDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS");
            List<Contribuinte> lista = new ArrayList<Contribuinte>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                Contribuinte p = new Contribuinte(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ContribuinteDAOException("Falha ao buscar.", ex);
        }    }
    
}
