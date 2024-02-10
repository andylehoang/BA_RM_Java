package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

public class KategorieAuswahlController {
	private Warenkorb myWarenkorb;
	private Verwaltung myVerwaltung;
	
	@FXML
	private RadioButton standard_button;
	@FXML
	private ToggleGroup kategorie;
	@FXML
	private RadioButton oko_button;
	@FXML
	private RadioButton U18_button;
	@FXML
	private RadioButton mitarbeiter_button;
	@FXML
	private RadioButton spar_button;
	@FXML
	private Button erstellenbtn;
	@FXML
	private Button geschenkBtn;
	@FXML
	private RadioButton geschenk_0;
	@FXML
	private ToggleGroup geschenk;
	@FXML
	private RadioButton geschenk_10;
	@FXML
	private RadioButton geschenk_20;
	@FXML
	private RadioButton geschenk_50;
	
	// Constructor

	// Event Listener on Button[#erstellenbtn].onAction
	@FXML
	public void btnGetKategorie(ActionEvent event) {
		this.myWarenkorb = new Warenkorb(this.getValue(),this.getGeschenkValue());	
		 Stage stage = (Stage) erstellenbtn.getScene().getWindow();
		 stage.close();
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnGetKategorieGeschenk(ActionEvent event) {
		System.out.println(myVerwaltung.getGlobalValue());
	}
	
	public Warenkorb getWarenkorb() {
		return this.myWarenkorb;
	}
	
	public String getValue() {
		String kategorie = "";
		if(standard_button.isSelected()) {
			kategorie = standard_button.getText();
		}else if(oko_button.isSelected()) {
			kategorie = oko_button.getText();
		}else if(U18_button.isSelected()) {
			kategorie = U18_button.getText();
		}else if(spar_button.isSelected()) {
			kategorie = spar_button.getText();
		}else { kategorie = mitarbeiter_button.getText();
		}
		return kategorie;
	}
	
	public int getGeschenkValue() {
		int betrag = 0;
		if(geschenk_10.isSelected()) {
			betrag = 10;
		}else if(geschenk_20.isSelected()) {
			betrag = 20;
		}else if(geschenk_50.isSelected()) {
			betrag = 50;
		}
		return betrag;
	}
	
	public void setVerwaltung(Verwaltung verwaltung) {
		this.myVerwaltung = verwaltung;
	}
	

	
	//@FXML
	//public void initialize() {
       // myVerwaltung = new Verwaltung();
        // You can access globalValue property and observe it in your Subcontroller
       // myVerwaltung.globalValueProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Subcontroller - Global Value changed: " + newValue);
        //});
    //}
}
