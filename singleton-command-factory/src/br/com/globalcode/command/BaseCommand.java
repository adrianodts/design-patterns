package br.com.globalcode.command;

import javax.swing.JTextArea;

import br.com.globalcode.visitor.Visitor;

public interface BaseCommand {
	
	public void execute(JTextArea taMensagens);
	public void accept(Visitor visitor);
}
