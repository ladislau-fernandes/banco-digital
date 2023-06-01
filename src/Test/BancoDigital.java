package Test;

import dominio.Cliente;
import dominio.Conta;
import dominio.ContaCorrente;
import dominio.ContaPoupanca;

public class BancoDigital {
    public static void main(String[] args) {
        Cliente ladislau = new Cliente("Ladislau");
        Conta ccLadislau = new ContaCorrente(ladislau);
        Conta ppLadislau = new ContaPoupanca(ladislau);

        ccLadislau.depositar(100);
        ccLadislau.transferir(10, ppLadislau);

        System.out.println(ccLadislau);
        System.out.println(ppLadislau);


    }
}
