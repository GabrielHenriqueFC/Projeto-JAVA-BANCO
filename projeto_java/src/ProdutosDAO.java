import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    private Connection connection;
    private String nome;
    private int quantidade;

    public ProdutosDAO(){
        this.connection = new Conexao().GeraConexao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
                p.setPreco_p(rs.getDouble("preco"));
                p.setQuant_p(rs.getInt("quantidade"));
                produtos.add(p);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public void listar_produtos(){
        ArrayList<Produtos> produtos = listarProdutos();
        for (Produtos p: produtos){
            System.out.println("ID: "+p.getCodigo_p()+" nome: "+p.getNome_p()+" preço: "+p.getPreco_p()+" quantidade:"+ p.getQuant_p());
        }
    }
}

