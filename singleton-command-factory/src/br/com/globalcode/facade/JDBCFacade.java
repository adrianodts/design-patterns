package br.com.globalcode.facade;

import br.com.globalcode.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe deve ser utilizada para implementação do acesso ao banco de dados
 */
public class JDBCFacade {
    
    private final static JDBCFacade instance = new JDBCFacade();
    
    private JDBCFacade() { }
    
    public static JDBCFacade getInstance() {
        return instance;
    }
    
    //implementar este m�todo
    private List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.111:3306/aw","aw","aw")){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produtos order by 'id'");
            while(rs.next()) {
                produtos.add(new Produto(rs.getInt("id"),rs.getString("nome")
                ,rs.getDouble("preco"),rs.getString("marca")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return produtos;
    }

    //implementar este m�todo
    public void salvarProduto(Produto p) {
//    	int index = 0;
//        boolean insert = textID.getText().equals("0");
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.111:3306/aw","aw","aw")){
//            String sql;
//            if(insert) {
//                sql = "insert into produtos ( nome, preco, marca ) values ( ?, ?, ? )";
//                index = produtos.size();
//            } else {
//                sql = "update produtos set nome = ?, preco = ?, marca = ? where id = ?";
//                index = produtos.indexOf(dataCurrent);
//            }
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1,textNome.getText());
//            st.setDouble(2,Double.parseDouble(textPreco.getText()));
//            st.setString(3,textMarca.getText());
//            if (!insert) {
//                st.setInt(4,Integer.parseInt(textID.getText()));
//            }
//            st.execute();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
    
}