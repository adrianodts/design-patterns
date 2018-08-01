package br.com.globalcode.adapter;

import javax.swing.JTextArea;

import br.com.globalcode.AcionarSistemaContabil;
import br.com.globalcode.ConfigManager;
import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.visitor.Visitor;

public class AcionarSistemaContabilAdapter implements BaseCommand {
	
	@Override
	public void execute(JTextArea taMensagens) {
		
		AcionarSistemaContabil comando = new AcionarSistemaContabil();
		comando.executarOperacaoContabil();
		
		ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        taMensagens.setText("Conexão com servidor " + server +"\n");
        //Código de acionamento do sistema contabil
        
        taMensagens.append("Acionando sistema contabil...");
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
