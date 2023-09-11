package tarefa_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private int numeroQuarto;
    private String nomeHospede;
    final private double VALOR_DIARIA = 150.00;
    private Date checkIn;
    private Date checkOut;

    final private int MIN_DIAS = 2;
    final private int MAX_DIAS = 5;

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public boolean quartoIndisponivel(int numeroQuarto, Date checkIn, Date CheckOut){
        return this.numeroQuarto == numeroQuarto &&
                (checkIn.after(this.checkIn) && checkIn.before(this.checkOut)) &&
                (CheckOut.after(this.checkIn) && CheckOut.before(this.checkOut));
    }

    public void reservar(int numeroQuarto, String nomeHospede, String checkIn, String checkOut) throws ParseException, QuartoIndisponvelException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date newCheckIn = formato.parse(checkIn);
        Date newCheckOut = formato.parse(checkOut);

        if(quartoIndisponivel(numeroQuarto, newCheckIn, newCheckOut)){
            throw new QuartoIndisponvelException();
        }
        this.nomeHospede = nomeHospede;
        this.numeroQuarto = numeroQuarto;
        this.checkIn = newCheckIn;
        this.checkOut = newCheckOut;
    }

}
