
package br.com.globalcode.visitor;

import br.com.globalcode.adapter.AcionarSistemaContabilAdapter;
import br.com.globalcode.command.EnviarPorEmail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public interface Visitor {
	public void visit(EnviarPorEmail commandEmail);
	public void visit(ExcluirPedido command);
	public void visit(GerarPDF command);
	public void visit(NovoPedido command);
	public void visit(AcionarSistemaContabilAdapter command);
}
