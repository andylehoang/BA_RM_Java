package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

public class KategorieAuswahlController {
	private Warenkorb myWarenkorb;
	
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

	// Event Listener on Button[#erstellenbtn].onAction
	@FXML
	public void btnGetKategorie(ActionEvent event) {
		this.myWarenkorb = new Warenkorb(this.getValue(),false);	
		 Stage stage = (Stage) erstellenbtn.getScene().getWindow();
		 stage.close();
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnGetKategorieGeschenk(ActionEvent event) {
		this.myWarenkorb = new Warenkorb(this.getValue(),true);
		 Stage stage = (Stage) geschenkBtn.getScene().getWindow();
		 stage.close();
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
}
