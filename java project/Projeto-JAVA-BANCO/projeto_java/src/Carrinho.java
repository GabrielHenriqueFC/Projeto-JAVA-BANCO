import java.util.ArrayList;
import java.util.Scanner;

public class Carrinho {
    private ProdutosDAO produtosDAO;
    private String nome;
    private int quantidade;
    private double total;
    private double valor;
    private int id_carrinho, id_lista;
    private int quantidade_att;
    private int quant_soma;
    private String clear;
    private ArrayList<Produtos> carrinho = new ArrayList<>();
    Scanner ler4 = new Scanner(System.in);
    public Carrinho(){
        this.produtosDAO = new ProdutosDAO();
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

    public void Carrinho() {
        ArrayList<Produtos> produtos = produtosDAO.listarProdutos();

        for (Produtos p : produtos) {
            if (p.getNome_p().equalsIgnoreCase(nome)) {
                p.setQuant_p(quantidade);
                carrinho.add(p);
            }
        }
        System.out.println("Seu carrinho");
        for(Produtos p: carrinho){
            System.out.println("ID: "+p.getCodigo_p()+" nome: "+p.getNome_p()+" preço: "+p.getPreco_p()+" quantidade:"+ p.getQuant_p());
        }
    }
    public void Calcular_total(){
        if(carrinho==null){
            total = 0;
        }
        else{
            for(Produtos p: carrinho) {
                valor = p.getPreco_p();
                quant_soma = p.getQuant_p();
                total = total + (valor*quant_soma);
            }
        }
        System.out.println("O valor total da compra é de: "+total);
    }
    public void Limpar_carrinho(){
        System.out.println("Deseja mesmo esvaziar seu carrinho de compras?");
        clear = ler4.nextLine();
        if(clear.equalsIgnoreCase("sim")){
            carrinho.clear();
        }
    }

    public void Comprar(){
        ArrayList<Produtos> produtos = produtosDAO.listarProdutos();
        for (Produtos p: produtos){
            for(Produtos x:carrinho){
                id_carrinho = p.getCodigo_p();
                id_lista = x.getCodigo_p();
                if(id_lista == id_carrinho){
                    quantidade_att = p.getQuant_p() - x.getQuant_p();
                    p.setQuant_p(quantidade_att);
                    produtosDAO.atualizarProduto(p);
                }
            }
        }
        carrinho.clear();
        System.out.println("Compra realizada com sucesso!");
    }
}
