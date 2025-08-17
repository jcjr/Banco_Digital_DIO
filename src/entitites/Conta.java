package entitites;

import interfaces.ContaBancaria;

public abstract class Conta implements ContaBancaria {

	private static final int AGENCIAPADRAO = 1;
	private static int NUMEROCONTA = 1;

	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIAPADRAO;
		this.numeroConta = NUMEROCONTA++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Conta criarConta(int agencia, int numeroConta) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		return this;
	};

	@Override
	public double verificarSaldo(Conta conta) {
		if (this.agencia == conta.agencia && this.numeroConta == conta.numeroConta) {
			return getSaldo();
		} else {
			System.out.println("Agência ou número da conta inválidos!\n");
			return 0;
		}
	};

	@Override
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.printf("Saque de R$ %.2f realizado da " + this.getNumeroConta() + "\n", valor);
		} else if (valor <= 0) {
			System.out.println("Valor inválido para saque!\n");
		} else {
			System.out.println("Saldo insuficiente para saque!\n");
		}
	};

	@Override
	public void depositar(double valor, boolean messagem) {
		if (valor > 0 && messagem) {
			saldo += valor;
			System.out.printf("Depósito de R$ %.2f realizado na conta " + this.getNumeroConta() + "\n\n", valor);
		} else if (valor > 0) {
			saldo += valor;
		} else {
			System.out.println("Valor inválido para depósito.\n");
		}
	};

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			contaDestino.depositar(valor, false);
			System.out.printf("Transferência de R$ %.2f da conta " + this.getNumeroConta() + " para a conta "
					+ contaDestino.numeroConta + "\n\n", valor);
		} else if (valor <= 0) {
			System.out.println("Valor inválido para transferência.\n");
		} else {
			System.out.println("\nSaldo insuficiente para transferência.\n");
		}
	};

	public void imprimirInforConta(String message) {
		System.out.println("-- " + message + " --");
		System.out.printf("Cliente: %s\n", this.cliente.getNome());
		System.out.printf("Agência: %d\n", this.agencia);
		System.out.printf("Conta  : %d\n", this.numeroConta);
		System.out.printf("Saldo  : R$ %.2f\n", this.saldo);
		System.out.println("----------------------------\n");
	}

}
