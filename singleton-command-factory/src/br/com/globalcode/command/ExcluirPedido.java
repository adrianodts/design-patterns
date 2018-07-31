package br.com.globalcode.command;

import javax.swing.JTextArea;

import br.com.globalcode.ConfigManager;
import br.com.globalcode.visitor.Visitor;

public class ExcluirPedido implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conex�o com servidor " + server+"\n");
        //C�digo de exclus�o de pedido
        taMensagens.append("Excluindo pedido do sistema...");
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
