package br.com.globalcode.command;

import javax.swing.JTextArea;

import br.com.globalcode.ConfigManager;
import br.com.globalcode.visitor.Visitor;

public class GerarPDF implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conex�o com servidor " + server+"\n");
        //C�digo de gera��o do arquivo PDF
        taMensagens.append("Gerando PDF do pedido...");
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
