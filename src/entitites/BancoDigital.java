package entitites;

import java.util.ArrayList;
import java.util.List;

public class BancoDigital {

	private Cliente cliente;
	private List<Conta> contas = new ArrayList<>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
