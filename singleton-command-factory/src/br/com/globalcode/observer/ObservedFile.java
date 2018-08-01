package br.com.globalcode.observer;

import java.util.ArrayList;

public class ObservedFile extends java.io.File implements Runnable {
	
	private static final long serialVersionUID = 1L;	
	private ArrayList<FileObserver> observers = new ArrayList<FileObserver>(); 
	private long dataAtualizacao = 0;
	private long INTERVALO_OBS = 500;
	
	public ObservedFile(String nome) {
		super(nome);
		Thread observacao = new Thread(this);
		observacao.start();
	}
	
	@Override
	public void run() {
		dataAtualizacao = this.lastModified();
		while(true){
			if(dataAtualizacao != this.lastModified()){
				notifyObservers();
				dataAtualizacao = this.lastModified();
			}
			try{
				Thread.sleep(INTERVALO_OBS);				
			}
			catch(InterruptedException e){
				System.out.println("sllep interrompido");
				break;
			}
		}
	}

	public void addObserver(FileObserver f) {
		this.observers.add(f);
	}

	public void removeObserver(FileObserver f) {
		this.observers.remove(f);
	}

	public void notifyObservers() {
		for(FileObserver observer : observers){
			observer.fileChanged(this);
		}
	}

}
