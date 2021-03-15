package it.polito.tdp.librettovoti;

import java.awt.TextArea;
import java.awt.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLController  {
     @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField txtEsame;

        @FXML
        private TextField txtVoto;

        @FXML
        private TextField txtData;

        @FXML
        private TextArea txtResult;
        

        private Libretto model;
        @FXML
        void handleInserisci(ActionEvent event) {

        	String nomeEsame = txtEsame.getText();
        	if(nomeEsame.length()==0) {
        		txtResult.setText("ERRORE: nome esame vuoto");
        		return ;
        	}
        	String votoEsame = txtVoto.getText();
        	int votoInt = Integer.parseInt(votoEsame);
        	String dataEsame = txtData.getText();
        	LocalDate data = LocalDate.parse(dataEsame);
        	
        	Voto voto = new Voto(nomeEsame, votoInt, data);
        	model.add(voto);
        	
        	
        	//aggiorna i risultati nella view
        	txtResult.setText(model.toString());
        	
        }

       

	
   
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
            assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtData != null : "fx:id=\"tstData\" was not injected: check your FXML file 'Scene.fxml'.";
            assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }  
    
    public void setModel (Libretto model) {
    	this.model=model;
    	}
   
   

}
