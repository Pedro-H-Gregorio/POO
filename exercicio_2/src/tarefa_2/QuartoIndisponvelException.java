package tarefa_2;

public class QuartoIndisponvelException extends Exception{
    public QuartoIndisponvelException(){
        super("Quarto não disponível para as datas informadas.");
    }
}
