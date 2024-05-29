import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection connection;
    public ProdutoDAO(){
        this.connection = new Conexao().GeraConexao();
    }
    /*public void adiciona(Produtos p){
        String sql = "INSERT INTO Pessoa(nome, idade) VALUES(?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, p.getCodigo_p());
            stmt.setString(2, p.getNome_p());
            stmt.setDouble(1, p.getPreco_p());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }*/
    public ArrayList<Produtos> listarProdutos(){
        ArrayList<Produtos> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produtos p = new Produtos();
                p.setCodigo_p(rs.getInt("id"));
                p.setNome_p(rs.getString("nome"));
                p.setPreco_p(rs.getInt("preco"));
                produtos.add(p);

            }

            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        for (Produtos p : produtos) {
            System.out.println("id:"+ p.getCodigo_p() + " Produto:"+ p.getNome_p() + "  preço:" + p.getPreco_p());
        }

        return produtos;

    }
}