package entitites;

import interfaces.ContaBancaria;

public class ContaPoupanca extends Conta implements ContaBancaria {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirInforConta("Extrato Conta Poupança");
	};

}
