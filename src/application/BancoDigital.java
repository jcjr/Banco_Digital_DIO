package application;

import entitites.Cliente;
import entitites.Conta;
import entitites.ContaCorrente;
import entitites.ContaPoupanca;

public class BancoDigital {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("João da Silva", "123.456.789-00");

		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);

		cc.depositar(100, true);
		cp.depositar(200, true);
		cc.transferir(100, cp);
		cc.sacar(50);

		cp.depositar(150, true);

		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}
