
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inicializar();
        arvore.carregarAlfabeto();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n===== CODIGO MORSE =====");
            System.out.println("1 - Buscar codigo de uma letra ou numero");
            System.out.println("2 - Codificar uma mensagem");
            System.out.println("3 - Decodificar uma mensagem");
            System.out.println("4 - Exibir a arvore");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {

                System.out.print("Digite uma letra ou numero: ");
                String texto = entrada.nextLine();

                if (texto.length() > 0) {
                    char caractere = texto.charAt(0);

                    if (caractere >= 'a' && caractere <= 'z') {
                        caractere = (char) (caractere - 32);
                    }

                    String codigo = arvore.buscar(caractere);

                    if (codigo.length() > 0) {
                        System.out.println(
                                "Codigo Morse: " + codigo);
                    } else {
                        System.out.println(
                                "Caractere nao encontrado.");
                    }
                }

            } else if (opcao == 2) {

                System.out.print("Digite a mensagem: ");
                String mensagem = entrada.nextLine();

                System.out.println(
                        "Morse: " + arvore.codificar(mensagem));

            } else if (opcao == 3) {

                System.out.println(
                        "Use espacos entre as letras e / entre palavras.");
                System.out.print("Digite o codigo Morse: ");

                String mensagem = entrada.nextLine();

                System.out.println(
                        "Texto: " + arvore.decodificar(mensagem));

            } else if (opcao == 4) {

                System.out.println(
                        "\nCodigos e caracteres da arvore:");
                arvore.exibir();

            } else if (opcao == 5) {

                System.out.println("Programa encerrado.");

            } else {

                System.out.println("Opcao invalida.");
            }
        }

        entrada.close();
    }
}
