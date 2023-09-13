package tarefa_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Postagem {

    private String autor;
    private String texto;
    private Date data;

    private int numeroCurtidas = 0;

    private ArrayList<String> likeUsuarios;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Postagem(String autor, String texto, String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.autor = autor;
        this.texto = texto;
        this.data = format.parse(data);
    }

    public void curtir(String usuario) throws CurtidaException {
        // verifica se o usuario já curtiu
       if(this.likeUsuarios.contains(usuario)){
            throw new CurtidaException();
       }

       this.numeroCurtidas += 1;
       this.likeUsuarios.add(usuario);
    }

    public void descurtir(String usuario) throws DescurtidaException {
        // verifica se o usuario não curtiu
        int index = this.likeUsuarios.indexOf(usuario);
        if(index < 0){
            throw new DescurtidaException();
        }

        this.numeroCurtidas -= 1;
        this.likeUsuarios.remove(index);
    }
}
