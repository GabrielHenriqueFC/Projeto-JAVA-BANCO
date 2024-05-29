import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Scanner ler2 = new Scanner(System.in);

        ProdutoDAO pd = new ProdutoDAO();

        int menu;
        do{
            System.out.println("Digite:\n1 para listar os produtos\n0 para encerrar o programa");
            menu = ler.nextInt();
            switch (menu){
                case 1:
                    pd.listarProdutos();
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        }while(menu != 0);
    }
}