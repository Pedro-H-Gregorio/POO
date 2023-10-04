package taskone;

public class Stack implements IStack{

    String[] stack;
    int top;

    public Stack(int tamanho){
        this.stack = new String[tamanho];
        this.top = 0;
    }

    @Override
    public void push(String item) throws Exception {
        if(this.isFull()){
            throw new Exception("Pilha cheia");
        }
        stack[top] = item;
        top++;
    }

    @Override
    public String pop() {
        String value = stack[top];
        top--;
        return value;
    }

    @Override
    public String peek() {
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == stack.length-1;
    }
}
