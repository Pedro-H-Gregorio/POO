package taskone;

public interface IStack {
    void push(String item) throws Exception;   // insere um item no topo
    String pop();             // remove um item do topo
    String peek();            // retorna um item do topo sem removê-lo
    boolean isEmpty();        // determina se a pilha está vazia
    boolean isFull();         // determina se a pilha está cheia
    String toString();        // retorna a representação da pilha em String
}
