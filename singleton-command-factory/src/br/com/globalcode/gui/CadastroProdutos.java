package br.com.globalcode.gui;

import br.com.globalcode.facade.JDBCFacade;
import br.com.globalcode.model.Produto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CadastroProdutos extends JFrame{
    
    private CatalogoProdutosMediator mediator;
    // declara��o de vari�veis
    private JButton buttonAnterior;
    private JButton buttonCancelar;
    private JButton buttonEditar;
    private JButton buttonNovo;
    private JButton buttonProximo;
    private JButton buttonSalvar;
    private JLabel lbId;
    private JLabel lbMarca;
    private JLabel lbNome;
    private JLabel lbPreco;
    private JPanel pBotoes;
    private JPanel pLabels;
    private JPanel pCadastro;
    private JTextField textID;
    private JTextField textMarca;
    private JTextField textNome;
    private JTextField textPreco;
    
    List<Produto> produtos;
    ListIterator<Produto> produtosIterator;
    Produto dataCurrent;
    Produto oldData;
    
    
    public CadastroProdutos() {
        initComponents();
        initApp();
    }
    public void initApp() {
        produtos = lerProdutos();
        produtosIterator = produtos.listIterator();
        dataCurrent = produtosIterator.next();
        bindCurrentRecord();
    }
    
    public void reinitApp(int index) {
        produtos = lerProdutos();
        produtosIterator = produtos.listIterator(index);
        dataCurrent = produtosIterator.next();
        bindCurrentRecord();
    }
    
    public void bindCurrentRecord() {
        if(dataCurrent!=null) {
            this.textNome.setText(dataCurrent.getNome());
            this.textID.setText(""+dataCurrent.getId());
            this.textMarca.setText(dataCurrent.getMarca());
            this.textPreco.setText(""+dataCurrent.getPreco());
        }
    }
    
    private void initComponents() {
        pCadastro = new JPanel();
        pLabels = new JPanel();
        lbId = new JLabel();
        textID = new JTextField();
        lbNome = new JLabel();
        textNome = new JTextField();
        lbMarca = new JLabel();
        textPreco = new JTextField();
        lbPreco = new JLabel();
        textMarca = new JTextField();
        pBotoes = new JPanel();
        buttonAnterior = new JButton();
        buttonNovo = new JButton();
        buttonEditar = new JButton();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        buttonProximo = new JButton();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setLayout(new BorderLayout(10,5));
        setResizable(false);
        lbId.setText("ID ");
        
        textID.setEditable(false);
        textID.setEnabled(false);
        
        lbNome.setText("Nome");
        
        textNome.setEditable(false);
        
        lbMarca.setText("Marca");
        
        textPreco.setEditable(false);
        
        lbPreco.setText("Pre\u00e7o");
        
        textMarca.setEditable(false);
        
        pLabels.setLayout(new GridLayout(4,1));
        pLabels.add(lbId);
        pLabels.add(lbNome);
        pLabels.add(lbPreco);
        pLabels.add(lbMarca);
        this.add(pLabels, BorderLayout.WEST);
        
        pCadastro.setLayout(new GridLayout(4,1));
        pCadastro.add(textID);
        pCadastro.add(textNome);
        pCadastro.add(textPreco);
        pCadastro.add(textMarca);
        this.add(pCadastro, BorderLayout.CENTER);
        
        
        buttonAnterior.setText("<");
        buttonAnterior.addActionListener(new BotaoAnteriorHandler());
        
        pBotoes.add(buttonAnterior);
        
        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new BotaoNovoHandler());
        
        pBotoes.add(buttonNovo);
        
        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new BotaoEditarHandler());
        
        pBotoes.add(buttonEditar);
        
        buttonSalvar.setText("Salvar");
        buttonSalvar.setEnabled(false);
        buttonSalvar.addActionListener(new BotaoSalvarHandler());
        
        pBotoes.add(buttonSalvar);
        
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setEnabled(false);
        buttonCancelar.addActionListener(new BotaoCancelarHandler());
        
        pBotoes.add(buttonCancelar);
        
        buttonProximo.setText(">");
        buttonProximo.addActionListener(new BotaoProximoHandler());
        
        pBotoes.add(buttonProximo);
        
        this.add(pBotoes, BorderLayout.SOUTH);
        
        pack();
    }
    
    public static void main(String args[]) {
        new CadastroProdutos().setVisible(true);
    }
    
    //Inner classes
    class BotaoAnteriorHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	mediator.botaoAnteriorAction();
        }
    }
    
    class BotaoNovoHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	mediator.botaoNovoAction();
        }
    }
    
    class BotaoEditarHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		mediator.botaoEditarAction();
    	}
    }
    
    class BotaoSalvarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            JDBCFacade facade = JDBCFacade.getInstance();
            facade.salvarProduto(p);
            reinitApp(index);
            
            mediator.botaoSalvarAction();
        }
    }
    
    class BotaoCancelarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mediator.botaoCancelarAction();
        }
    }
    
    class BotaoProximoHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mediator.botaoProximoAction();
        }
    }
        
    class CatalogoProdutosMediator {

    	public void botaoEditarAction() {
            textNome.setEditable(true);
            textPreco.setEditable(true);
            textMarca.setEditable(true);
            buttonSalvar.setEnabled(true);
            buttonCancelar.setEnabled(true);
            
            buttonAnterior.setEnabled(false);
            buttonEditar.setEnabled(false);
            buttonProximo.setEnabled(false);
            buttonNovo.setEnabled(false);
        }

		public void botaoAnteriorAction() {
        	if(produtosIterator.hasPrevious())
                dataCurrent = produtosIterator.previous();
            bindCurrentRecord();
            
            textNome.setEditable(false);
            textPreco.setEditable(false);
            textMarca.setEditable(false);
            buttonSalvar.setEnabled(false);
            buttonCancelar.setEnabled(false);
            
            buttonAnterior.setEnabled(true);
            buttonEditar.setEnabled(true);
            buttonProximo.setEnabled(true);
            buttonNovo.setEnabled(true);
		}

		public void botaoNovoAction() {
        	oldData = dataCurrent;
            dataCurrent = new Produto();
            bindCurrentRecord();
            
            textNome.setEditable(true);
            textPreco.setEditable(true);
            textMarca.setEditable(true);
            buttonSalvar.setEnabled(true);
            buttonCancelar.setEnabled(true);
            
            buttonAnterior.setEnabled(false);
            buttonEditar.setEnabled(false);
            buttonProximo.setEnabled(false);
            buttonNovo.setEnabled(false);
		}

		public void botaoSalvarAction() {
            textNome.setEditable(false);
            textPreco.setEditable(false);
            textMarca.setEditable(false);
            buttonSalvar.setEnabled(false);
            buttonCancelar.setEnabled(false);
            
            buttonAnterior.setEnabled(true);
            buttonEditar.setEnabled(true);
            buttonProximo.setEnabled(true);
            buttonNovo.setEnabled(true);
		}

		public void botaoProximoAction() {
			if(produtosIterator.hasNext())
                dataCurrent = produtosIterator.next();
            bindCurrentRecord();
            
            textNome.setEditable(false);
            textPreco.setEditable(false);
            textMarca.setEditable(false);
            buttonSalvar.setEnabled(false);
            buttonCancelar.setEnabled(false);
            
            buttonAnterior.setEnabled(true);
            buttonEditar.setEnabled(true);
            buttonProximo.setEnabled(true);
            buttonNovo.setEnabled(true);			
		}

		public void botaoCancelarAction() {
			if (oldData != null) {
                dataCurrent = oldData;
                oldData = null;
            }
            bindCurrentRecord();
            
            textNome.setEditable(false);
            textPreco.setEditable(false);
            textMarca.setEditable(false);
            buttonSalvar.setEnabled(false);
            buttonCancelar.setEnabled(false);
            
            buttonAnterior.setEnabled(true);
            buttonEditar.setEnabled(true);
            buttonProximo.setEnabled(true);
            buttonNovo.setEnabled(true);            
		}
						
	}
}