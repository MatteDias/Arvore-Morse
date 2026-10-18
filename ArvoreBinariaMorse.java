
public class ArvoreBinariaMorse {

    private Nodo raiz;

    // Cria a raiz vazia da árvore.
    public void inicializar() {
        raiz = new Nodo(' ');
    }

    // Insere um caractere seguindo seu código Morse.
    // Ponto vai para a esquerda e traço para a direita.
    public void inserir(String codigo, char caractere) {
        Nodo atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {

            if (codigo.charAt(i) == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new Nodo(' ');
                }
                atual = atual.esquerda;

            } else if (codigo.charAt(i) == '-') {
                if (atual.direita == null) {
                    atual.direita = new Nodo(' ');
                }
                atual = atual.direita;
            }
        }

        atual.caractere = caractere;
    }

    // Busca o código Morse correspondente a um caractere.
    public String buscar(char caractere) {
        return buscarRecursivo(raiz, caractere, "");
    }

    private String buscarRecursivo(
            Nodo atual, char caractere, String codigo) {

        if (atual == null) {
            return "";
        }

        if (atual.caractere == caractere) {
            return codigo;
        }

        String resultado = buscarRecursivo(
                atual.esquerda, caractere, codigo + ".");

        if (resultado.length() > 0) {
            return resultado;
        }

        return buscarRecursivo(
                atual.direita, caractere, codigo + "-");
    }

    // Percorre os códigos Morse e retorna o caractere.
    public char decodificarCaractere(String codigo) {
        Nodo atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {

            if (codigo.charAt(i) == '.') {
                atual = atual.esquerda;

            } else if (codigo.charAt(i) == '-') {
                atual = atual.direita;

            } else {
                return '?';
            }

            if (atual == null) {
                return '?';
            }
        }

        return atual.caractere;
    }

    // Insere todas as letras e números na árvore.
    public void carregarAlfabeto() {

        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    // Exibe a árvore de forma hierárquica.
    public void exibir() {
        exibirRecursivo(raiz, "");
    }

    private void exibirRecursivo(Nodo atual, String codigo) {

        if (atual == null) {
            return;
        }

        if (atual.caractere != ' ') {
            System.out.println(
                    codigo + " = " + atual.caractere);
        }

        exibirRecursivo(atual.esquerda, codigo + ".");
        exibirRecursivo(atual.direita, codigo + "-");
    }

    // Converte um texto para código Morse.
    public String codificar(String mensagem) {
        String resultado = "";

        for (int i = 0; i < mensagem.length(); i++) {

            char caractere = mensagem.charAt(i);

            // Converte letras minúsculas para maiúsculas.
            if (caractere >= 'a' && caractere <= 'z') {
                caractere = (char) (caractere - 32);
            }

            if (caractere == ' ') {
                resultado = resultado + "/ ";
            } else {
                String codigo = buscar(caractere);

                if (codigo.length() > 0) {
                    resultado = resultado + codigo + " ";
                } else {
                    resultado = resultado + "? ";
                }
            }
        }

        return resultado;
    }

    // Converte código Morse para texto.
    // As letras são separadas por espaços e as palavras por /.
    public String decodificar(String mensagem) {
        String resultado = "";
        String codigo = "";

        for (int i = 0; i < mensagem.length(); i++) {

            char caractere = mensagem.charAt(i);

            if (caractere == '.' || caractere == '-') {
                codigo = codigo + caractere;

            } else if (caractere == ' ') {

                if (codigo.length() > 0) {
                    resultado = resultado
                            + decodificarCaractere(codigo);
                    codigo = "";
                }

            } else if (caractere == '/') {

                if (codigo.length() > 0) {
                    resultado = resultado
                            + decodificarCaractere(codigo);
                    codigo = "";
                }

                resultado = resultado + " ";
            }
        }

        // Processa o último código, caso a mensagem não termine
        // com um espaço.
        if (codigo.length() > 0) {
            resultado = resultado
                    + decodificarCaractere(codigo);
        }

        return resultado;
    }
}
