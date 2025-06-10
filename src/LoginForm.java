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

public class LoginForm extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Construtor padrão. Inicializa os componentes e conecta ao banco de dados.
     */
    public LoginForm() {
        initComponents();
        Connect();
    }

    /**
     * Estabelece conexão com o banco de dados MySQL.
     */
    public void Connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lanchoneteCRUD", "root", "Acess1911@");
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método de ação do botão de login. Verifica se as credenciais são válidas
     * e abre a tela de produtos (ProductForm) se forem.
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        try {
            pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                ProductForm pf = new ProductForm();
                this.setVisible(false);
                pf.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha está incorreto!\nTente novamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Outros métodos e componentes gerados pelo NetBeans são mantidos
}
