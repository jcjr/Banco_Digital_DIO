package interfaces;

import entitites.Conta;

public interface ContaBancaria {

	Conta criarConta(int agencia, int numeroConta);

	double verificarSaldo(Conta conta);

	void sacar(double valor);

	void depositar(double valor, boolean messagem);

	void transferir(double valor, Conta contaDestino);

	public void imprimirExtrato();

}
