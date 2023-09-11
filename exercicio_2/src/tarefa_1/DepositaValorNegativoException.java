package tarefa_1;

public class DepositaValorNegativoException extends Exception {
    public DepositaValorNegativoException(){
        super("Valor para depositar inválido. Não é permitido valores negativos");
    }
}
