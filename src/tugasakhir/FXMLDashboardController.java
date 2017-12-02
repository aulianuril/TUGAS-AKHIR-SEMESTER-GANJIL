/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lely
 */
public class FXMLDashboardController implements Initializable {

    @FXML
    private JFXTextField tgl;
    @FXML
    private JFXComboBox<String> ukc;
    @FXML
    private JFXComboBox<String> jkc;
    @FXML
    private JFXComboBox<String> jkd;
    @FXML
    private JFXComboBox<String> kamera;
    @FXML
    private JFXComboBox<String> camera;
    @FXML
    private JFXComboBox<String> kp;
    @FXML
    private JFXComboBox<String> pl;
    @FXML
    private JFXComboBox<String> uks;
    @FXML
    private JFXComboBox<String> jks;
    @FXML
    private JFXComboBox<String> tb;
    @FXML
    private JFXButton proses;
    @FXML
    private JFXButton Next;

    ObservableList<String> UKC = FXCollections.observableArrayList("100 liter", "80 liter", "55 liter", "45 liter");
    ObservableList<String> JKC = FXCollections.observableArrayList("Perempuan", "Laki-laki");

    ObservableList<String> JKD = FXCollections.observableArrayList("Perempuan", "Laki-laki");

    ObservableList<String> KAMERA = FXCollections.observableArrayList("700 D", "600 D", "100 D");
    ObservableList<String> CAMERA = FXCollections.observableArrayList("D5300", "D5200", "D7000");

    ObservableList<String> KP = FXCollections.observableArrayList(">4 orang", "5-7 orang", "10 orang");
    ObservableList<String> PL = FXCollections.observableArrayList("Dataran Rendah", "Dataran Tinggi");

    ObservableList<String> TB = FXCollections.observableArrayList(">150 cm", "<150 cm");

    ObservableList<String> UKS = FXCollections.observableArrayList(">35 cm", ">45 cm", ">50 cm");
    ObservableList<String> JKS = FXCollections.observableArrayList("Perempuan", "Laki-laki");
    @FXML
    private JFXTextArea TA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ukc.setValue("Pilih Ukuran");
        ukc.setItems(UKC);
        jkc.setValue("Jenis Kelamin");
        jkc.setItems(JKC);

        jkd.setValue("Jenis Kelamin");
        jkd.setItems(JKD);

        kamera.setValue("Jenis Kamera");
        kamera.setItems(KAMERA);
        camera.setValue("Jenis Kamera");
        camera.setItems(CAMERA);

        kp.setValue("Kapasitas");
        kp.setItems(KP);
        pl.setValue("Tempat");
        pl.setItems(PL);

        tb.setValue("Tinggi Badan");
        tb.setItems(TB);

        uks.setValue("Pilih Ukuran");
        uks.setItems(UKS);
        jks.setValue("Jenis Kelamin");
        jks.setItems(JKS);

        // TODO
    }

    @FXML
    private void UKC(ActionEvent event) {
    }

    @FXML
    private void JKC(ActionEvent event) {
    }

    @FXML
    private void JKD(ActionEvent event) {
    }

    @FXML
    private void KAMERA(ActionEvent event) {
    }

    @FXML
    private void CAMERA(ActionEvent event) {
    }

    @FXML
    private void KP(ActionEvent event) {
    }

    @FXML
    private void PL(ActionEvent event) {
    }

    @FXML
    private void UKS(ActionEvent event) {
    }

    @FXML
    private void JKS(ActionEvent event) {
    }

    @FXML
    private void TB(ActionEvent event) {
    }

    @FXML
    private void btnPROSES(ActionEvent event) {
        String ukuran_carrier;
        String jenis_carrier;
        String kap_tenda;
        String pl_tenda;
        String jenis_daypack;
        String tinggi;
        String canon;
        String nikon;
        String jenis_sepatu;
        String tanggal;
        String ukuran_sepatu;

        ukuran_carrier = ukc.getValue().toString();
        jenis_carrier = jkc.getValue().toString();
        kap_tenda = kp.getValue().toString();
        pl_tenda = pl.getValue().toString();
        jenis_daypack = jkd.getValue().toString();
        tinggi = tb.getValue().toString();
        canon = camera.getValue().toString();
        nikon = kamera.getValue().toString();
        ukuran_sepatu=uks.getValue().toString();
        jenis_sepatu = jks.getValue().toString();
        tanggal = tgl.getText();

        TA.setText("Ukuran Carrier : " + ukuran_carrier + "\n Jenis Carrier : " + jenis_carrier + "\n\n====================\nKapasitas Tenda : "
                + kap_tenda + "\nTempat Untuk Tenda : " + pl_tenda + "\n\n====================\nJenis Daypack : " + jenis_daypack
                + "\nTinggi Badan : " + tinggi + "\n\n====================\nKamera 1 : " + canon + "\nKamera 2 : " + nikon
                + "\n\n====================\nUkuran Sepatu : " +ukuran_sepatu +"\nJenis Sepatu Untuk : "+jenis_sepatu+ 
                "\n\n====================\nTanggal Booking : "
                + tanggal);

    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLWisata.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 625, 460);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Tempat Wisata");
                stage.show();
    }

}
