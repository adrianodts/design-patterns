package br.com.globalcode.visitor;

import br.com.globalcode.command.EnviarPorEmail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public class LogVisitor implements Visitor {

	@Override
	public void visit(EnviarPorEmail command) {
		System.out.println("Enviando pedido por email...");
	}

	@Override
	public void visit(ExcluirPedido command) {
		System.out.println("Excluindo pedido...");
	}

	@Override
	public void visit(GerarPDF command) {
		System.out.println("Gerando PDF...");
	}

	@Override
	public void visit(NovoPedido command) {
		System.out.println("Gerando novo pedido...");
	}

}
