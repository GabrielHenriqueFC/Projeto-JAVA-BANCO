public class Produtos {
    private int codigo_p;
    private String nome_p;
    private double preco_p;
    private int quant_p;

    public int getQuant_p() {
        return quant_p;
    }

    public void setQuant_p(int quant_p) {
        this.quant_p = quant_p;
    }

    public int getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(int codigo_p) {
        this.codigo_p = codigo_p;
    }

    public String getNome_p() {
        return nome_p;
    }

    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }

    public double getPreco_p() {
        return preco_p;
    }

    public void setPreco_p(double preco_p) {
        this.preco_p = preco_p;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "codigo_p=" + codigo_p +
                ", nome_p='" + nome_p + '\'' +
                ", preco_p=" + preco_p +
                ", quant_p=" + quant_p +
                '}';
    }
}
