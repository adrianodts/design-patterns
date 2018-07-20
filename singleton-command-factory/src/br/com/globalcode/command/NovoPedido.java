package br.com.globalcode.command;

import javax.swing.JTextArea;

import br.com.globalcode.ConfigManager;

public class NovoPedido implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conex�o com servidor " + server+"\n");
        //C�digo de cria��o de um novo pedido
        taMensagens.append("Setup para novo pedido...");
	}
}
