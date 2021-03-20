package it.polito.tdp.librettovoti;

import javafx.application.Application;
import static javafx.application.Application.launch;

import java.lang.ModuleLayer.Controller;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	// devo creare una classe loader ed un oggetto loader che ha un metodo getController
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
      //  Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
    	Parent root = loader.load();
    	
    	// salvo il controller preso dal loader in un oggetto che mi so coreato
    	FXMLController controller = loader.getController();
    	
    	//creiamo il modello
        Libretto model = new Libretto();
        
        //chiamo il metodo setModel per settare il model sulla classe stessa
        controller.setModel(model);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
