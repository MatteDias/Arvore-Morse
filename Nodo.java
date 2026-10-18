public class Nodo {

    char caractere;
    Nodo esquerda;
    Nodo direita;

    // Cria um nó com o caractere informado.
    public Nodo(char caractere) {
        this.caractere = caractere;
        esquerda = null;
        direita = null;
    }
}