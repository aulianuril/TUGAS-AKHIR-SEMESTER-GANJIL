/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lely
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField editNama;
    @FXML
    private JFXTextField editAlamat;
    @FXML
    private JFXTextField editTelepon;
    @FXML
    private JFXButton login;
      @FXML
    private JFXButton daftar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void btnDaftar(ActionEvent event) throws IOException, SQLException {
        String nama = editNama.getText();
        String alamat = editAlamat.getText();
        String telp = editTelepon.getText();
        
        try {
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO Login VALUES ('"+nama+"', '"+alamat+"', '"+telp+"')");
            }
            JOptionPane.showMessageDialog(null, "Daftar Berhasil!");
                editNama.clear();
                editAlamat.clear();
                editTelepon.clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "GAGAL! Silahkan Coba Lagi");
        }
                
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        Connection connection;
        PreparedStatement ps;
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bacpacker", "root", "");
                ps = connection.prepareStatement("SELECT * FROM `Login` WHERE Nama=? AND Alamat=? AND Telepon=?");
                ps.setString(1, editNama.getText());
                ps.setString(2, editAlamat.getText());
                ps.setString(3, editTelepon.getText());
                ResultSet result = ps.executeQuery();
            if(result.next()){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Selamat Datang!");
            ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDashboard.fxml"));
                Scene scene = new Scene (fxmlLoader.load(), 734, 613);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("BackPacker");
                stage.show();
            } else {               
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Salah!");
                editNama.requestFocus();
                editAlamat.requestFocus();
                editTelepon.requestFocus();
                 }
            } catch (java.sql.SQLException ex){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal!");
            }
    }
    
}
