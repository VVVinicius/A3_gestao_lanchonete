/**
 * LoginForm.java
 *
 * Esta classe representa a tela de login da aplicação de gestão da lanchonete.
 * Permite autenticação do administrador para acesso à interface de cadastro de produtos.
 *
 * Funcionalidades principais:
 * - Verificação do nome de usuário e senha contra o banco de dados
 * - Acesso à tela principal da aplicação (ProductForm) apenas mediante login válido
 *
 * Observações:
 * - Há apenas um usuário cadastrado no banco de dados: o administrador (admin)
 * - Esta tela é sempre a primeira a ser exibida ao iniciar a aplicação
 *
 * @author
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductForm extends javax.swing.JFrame {

    public ProductForm() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
        setLocationRelativeTo(null);
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lanchoneteCRUD", "root", "Acess1911@");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void LoadProductNo() {
        try {
        pst = con.prepareStatement("SELECT id FROM product_tbl");
        rs = pst.executeQuery();
        txtPid.removeAllItems();
        txtPid.addItem(""); // <-- Adiciona uma opção vazia/inicial

        while (rs.next()) {
            txtPid.addItem(rs.getString(1));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a < q; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("qty"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtPid = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        bntDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        bntSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nome do produto");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Preço do produto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantidade:");

        txtPid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Id Produto");

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        bntDelete.setText("Deletar");
        bntDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Limpar");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(bntDelete)
                .addGap(18, 18, 18)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(bntDelete)
                    .addComponent(btnNew))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        bntSearch.setText("Procurar");
        bntSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID ", "Nome", "Preço R$", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestão Lanchonete Java");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPname)
                                        .addComponent(txtPrice)
                                        .addComponent(txtQty, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bntSearch)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSearch))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
        String pname = txtPname.getText();
        double price = Double.parseDouble(txtPrice.getText());  // Convertendo para double
        int qty = Integer.parseInt(txtQty.getText());           // Convertendo para int

        pst = con.prepareStatement("INSERT INTO product_tbl (pname, price, qty) VALUES(?, ?, ?)");
        pst.setString(1, pname);
        pst.setDouble(2, price);   // Usando setDouble
        pst.setInt(3, qty);        // Usando setInt

        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Adicionado com sucesso!");
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
            txtPname.requestFocus();
            Fetch();
            LoadProductNo();
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao adicionar!");
        }

    } catch (SQLException ex) {
        Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Preço ou quantidade inválidos. Verifique os valores.");
    }
    } 
private void bntSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
        String pid = txtPid.getSelectedItem().toString();

        if (pid.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um ID válido.");
            return;
        }

        pst = con.prepareStatement("SELECT * FROM product_tbl WHERE id = ?");
        pst.setString(1, pid);
        rs = pst.executeQuery();

        if (rs.next()) {
            txtPname.setText(rs.getString("pname"));
            double price = rs.getDouble("price");
            txtPrice.setText(String.format("%.2f", price));
            txtQty.setText(String.valueOf(rs.getInt("qty")));
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
       try {
        String pname = txtPname.getText();
        double price = Double.parseDouble(txtPrice.getText());  // Convertendo para double
        int qty = Integer.parseInt(txtQty.getText());           // Convertendo para int
        String pid = txtPid.getSelectedItem().toString();

        pst = con.prepareStatement("UPDATE product_tbl SET pname = ?, price = ?, qty = ? WHERE id = ?");
        pst.setString(1, pname);
        pst.setDouble(2, price);  // Usando setDouble
        pst.setInt(3, qty);       // Usando setInt
        pst.setString(4, pid);

        int k = pst.executeUpdate();
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "O registro foi atualizado com sucesso!");
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
            txtPname.requestFocus();
            Fetch();
            LoadProductNo();
        }

    } catch (SQLException ex) {
        Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Preço ou quantidade inválidos. Selecione um produto e verifique os valores.");
    }
        
    }                                         

    private void bntDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        try {
    String pid = txtPid.getSelectedItem().toString();

    int confirm = JOptionPane.showConfirmDialog(this, 
        "Deseja realmente deletar o produto com ID " + pid + "?", 
        "Confirmação", 
        JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) return;

    pst = con.prepareStatement("DELETE FROM product_tbl WHERE id = ?");
    pst.setString(1, pid);

    if (pst.executeUpdate() == 1) {
        JOptionPane.showMessageDialog(this, "Produto deletado com sucesso!");
        txtPname.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtPname.requestFocus();
        Fetch();
        LoadProductNo();
    } else {
        JOptionPane.showMessageDialog(this, "Falha ao deletar o produto.");
    }

} catch (SQLException ex) {
    Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }                                         

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
        txtPname.setText("");
        txtPrice.setText("");
        txtQty.setText("");
    
        if (txtPid.getItemCount() > 0) {
            txtPid.setSelectedIndex(0); // Seleciona o primeiro item da combo box
    }
    
            txtPname.requestFocus();
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bntDelete;
    private javax.swing.JButton bntSearch;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtPid;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    // End of variables declaration                   
}                    
