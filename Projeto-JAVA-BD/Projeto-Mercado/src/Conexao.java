import java.sql.*;

public class Conexao {

    public static Connection GeraConexao(){
        Connection conexao = null;
        try{
            String url = "jdbc:mysql://localhost/produtosTeste";
            String usuario ="root";
            String senha ="S3rvid0r";
            conexao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão realizada com sucesso");
        }catch(SQLException e){
            System.out.println("Erro ao tentar conectar: " + e.getMessage());
            conexao = null;
        }
        return conexao;
    }
}