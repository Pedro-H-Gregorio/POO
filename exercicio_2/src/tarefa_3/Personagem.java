package tarefa_3;

public class Personagem {
    private String name;
    private int pontos_de_saude = 100;
    private int experiencia = 0;

    public Personagem(String nome){
        this.name = nome;
    }

    void sofrer_dano() throws PersonagemMorreuException {
        this.pontos_de_saude -= experiencia > 40? 7 : 15;
        if(pontos_de_saude < 1){
            throw new PersonagemMorreuException(name);
        }
    }

    void ganhar_experiencia() throws ExperienciaMaximaException {
        if(experiencia > 100){
            throw new ExperienciaMaximaException();
        }
        this.experiencia += 10;
    }

    void recupera_saude() throws SaudeMaximaException {
        if(pontos_de_saude > 100){
            throw new SaudeMaximaException();
        }
    }
}
