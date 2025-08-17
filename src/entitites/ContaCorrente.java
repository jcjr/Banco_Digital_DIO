package entitites;

import interfaces.ContaBancaria;

public class ContaCorrente extends Conta implements ContaBancaria {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirInforConta("Extrato Conta Corrente");
	};

}
