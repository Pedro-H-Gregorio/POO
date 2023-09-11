package tarefa_1;

import java.util.Calendar;

public class ContaBancaria {
    private double saldo;
    final private double TARIFA = 0.05;
    private String conta;
    private String agencia;

    public ContaBancaria(String agencia, String conta){
        this.agencia = agencia;
        this.conta = conta;
    }


    public double verificaSaldo() {
        return saldo;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void depositar(double valor) throws DepositaValorNegativoException {
        if(valor < 0){
            throw new DepositaValorNegativoException();
        }
        this.saldo += valor;
    }

    private boolean verificaHora(){
        int hora = Calendar.HOUR_OF_DAY;
        return hora < 19 && hora > 7;
    }

    private void saque_especial(){
        this.saldo = TARIFA * saldo + saldo;
    }

    public void sacar(double valor) throws SaqueHorarioInvalidoException {
        if(verificaHora() && valor >= 1000){
            throw new SaqueHorarioInvalidoException();
        }
        this.saldo -= valor;
        if(this.saldo < 0){
            saque_especial();
        }
    }
}
