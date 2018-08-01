package br.com.globalcode.command;

import javax.swing.JTextArea;

import br.com.globalcode.ConfigManager;
import br.com.globalcode.visitor.Visitor;

public class EnviarPorEmail implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
		ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conexãoo com servidor " + server +"\n");
        //Código de envio do pedido por email
        
        taMensagens.append("Enviando Pedido por Email...");
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
