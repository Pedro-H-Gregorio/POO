package tarefa_4;

public class CurtidaException extends Exception{

    public CurtidaException(){
        super("Você já curtiu esse post.");
    }
}
