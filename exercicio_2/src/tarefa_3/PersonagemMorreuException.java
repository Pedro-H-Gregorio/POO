package tarefa_3;

public class PersonagemMorreuException extends Exception{
    public PersonagemMorreuException(String nome){
        super(String.join("","O Personagem ",nome,"Morreu!"));
    }
}
