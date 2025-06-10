/**
 * ProductForm.java
 *
 * Esta classe representa a interface gráfica para o cadastro, edição, listagem
 * e exclusão de produtos em uma lanchonete. Está integrada ao banco de dados
 * via JDBC e utiliza componentes Swing para a interface.
 *
 * Funcionalidades principais:
 * - Exibir lista de produtos cadastrados
 * - Adicionar novos produtos
 * - Atualizar produtos existentes
 * - Deletar produtos
 * - Carregar número sequencial do próximo produto
 *
 * Observações:
 * - Esta aplicação assume que já existe uma conexão válida com o banco de dados MySQL.
 * - Esta tela só é exibida após a autenticação do usuário admin.
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

public class ProductForm extends javax.swing.JFrame {

    // Conexão com o banco de dados
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Construtor principal. Inicializa os componentes e conecta ao banco de dados.
     */
    public ProductForm() {
        initComponents();
        Connect();
        Fetch();
        LoadProductNo();
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
     * Carrega o próximo número de identificação disponível para novo produto.
     */
    public void LoadProductNo() {
        // implementação omitida por brevidade
    }

    /**
     * Atualiza a tabela de produtos na interface.
     */
    public void Fetch() {
        // implementação omitida por brevidade
    }

    /**
     * Ação executada ao clicar no botão de salvar. Insere ou atualiza um produto no banco de dados.
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // implementação omitida por brevidade
    }

    /**
     * Ação executada ao clicar em um item da tabela. Preenche os campos com os dados do produto selecionado.
     */
    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {
        // implementação omitida por brevidade
    }

    /**
     * Ação executada ao clicar no botão de deletar. Exclui o produto selecionado do banco de dados.
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // implementação omitida por brevidade
    }

    // Outros métodos e componentes gerados pelo NetBeans são mantidos
}
