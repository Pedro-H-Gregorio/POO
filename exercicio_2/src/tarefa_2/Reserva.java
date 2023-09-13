package tarefa_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private String nomeHospede;
    final private double VALOR_DIARIA = 150.00;
    private double valor_reserva;
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

    public double getValor_reserva() {
        return valor_reserva;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public boolean quartoIndisponivel(){
        return this.numeroQuarto != Integer.parseInt(null) && this.checkIn != null && this.checkOut != null;
    }

    public int tempoDaReserva(Date checkIn, Date checkOut) throws DiariaInvalidaException {
        long diferencaDias = Math.abs(checkOut.getTime() - checkIn.getTime());
        long tempo = TimeUnit.DAYS.convert(diferencaDias, TimeUnit.MILLISECONDS);
        if(tempo < this.MIN_DIAS || tempo > this.MAX_DIAS){
            throw new DiariaInvalidaException();
        }
        return (int) tempo;
    }

    public Reserva(int numeroQuarto, String nomeHospede, String checkIn, String checkOut) throws ParseException, QuartoIndisponvelException, DiariaInvalidaException {
        // formatando datas
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date newCheckIn = formato.parse(checkIn);
        Date newCheckOut = formato.parse(checkOut);

        //verificando disponibilidade do quarto
        if(quartoIndisponivel()){
            throw new QuartoIndisponvelException();
        }

        // aplicando desconto a depender da quantidade de dias
        int tempo = tempoDaReserva(newCheckIn, newCheckOut);
        double desconto = tempo > 3 ? 0 : 0.10;

        this.valor_reserva = (VALOR_DIARIA * desconto - VALOR_DIARIA) * tempo;
        this.nomeHospede = nomeHospede;
        this.numeroQuarto = numeroQuarto;
        this.checkIn = newCheckIn;
        this.checkOut = newCheckOut;
    }

    public void cancelarReserva(){
        this.numeroQuarto = Integer.parseInt(null);
        this.nomeHospede = null;
        this.checkIn = null;
        this.checkOut = null;
        this.valor_reserva = 0;
    }

}
