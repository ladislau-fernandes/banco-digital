package dominio;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Titular: " + this.cliente.getNome() + "\nAgencia: " + this.agencia + "\nNumero da conta: " + this.numero + "\nSaldo: " + this.saldo + "\n";
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else {

            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.\nNovo saldo: " + saldo);
        }
    }


    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= 0) {
            System.out.println("O valor da transferência deve ser maior que zero.");
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        } else {

            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.\nNovo saldo: " + saldo);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}


