import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Scanner ler2 = new Scanner(System.in);
        ProdutosDAO pd = new ProdutosDAO();
        Carrinho car = new Carrinho();
        int menu;


        do{
            System.out.println("Digite:\n1 para listar Produtos\n2 para adicionar ao carrinho\n3 Calcular valor total do carrinho\n4 Esvaziar carrinho\n0 para encerrar o programa");
            menu = ler.nextInt();
            switch (menu){
                case 1:
                    pd.listar_produtos();
                    break;
                case 2:
                        System.out.println("Digite o nome do produto que deseja adicionar: ");
                        car.setNome(ler2.nextLine());
                        System.out.println("Digite a quantidade que deseja comprar: ");
                        car.setQuantidade(ler.nextInt());
                        car.Carrinho();
                    break;
                case 3:
                    car.Calcular_total();
                    break;
                case 4:
                    car.Limpar_carrinho();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        }while(menu != 0);
    }
}