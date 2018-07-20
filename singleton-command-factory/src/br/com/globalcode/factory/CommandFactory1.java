package br.com.globalcode.factory;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.command.EnviarPorEmail;
import br.com.globalcode.command.ExcluirPedido;
import br.com.globalcode.command.GerarPDF;
import br.com.globalcode.command.NovoPedido;

public class CommandFactory1 implements CommandFactory {

	@Override
	public BaseCommand create(String name) {
		BaseCommand command = null;
		if ("EnviarPorEmail".equals(name))
			command = new EnviarPorEmail();
		else if ("GerarPDF".equals(name))
			command = new GerarPDF();
		else if ("NovoPedido".equals(name))
			command = new NovoPedido();
		else if ("ExcluirPedido".equals(name))
			command = new ExcluirPedido();        
		return command;
	}
}
