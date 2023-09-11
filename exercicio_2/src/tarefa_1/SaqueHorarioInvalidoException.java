package tarefa_1;

public class SaqueHorarioInvalidoException extends Exception{
    public SaqueHorarioInvalidoException(){
        super("Valor de saque alto para o horário.");
    }
}
