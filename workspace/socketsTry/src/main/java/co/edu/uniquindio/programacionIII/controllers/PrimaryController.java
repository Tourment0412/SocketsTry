package co.edu.uniquindio.programacionIII.controllers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField txtTexto;

    @FXML
    void enviarMensajeEvent(ActionEvent event) {
    	//Se crea un socket con la importacion de javanet
    	
    	/*
    	 * Ahora como estamos haciendo esta simulacion en local, debemos de conocer nuestra direccion IP
    	 */
    	try {
			Socket miSocket= new Socket("localhost",9998);
			//Se crea un flujo de salida de tipo DataOutputStream
			//el socket posee un OutputStream propio
			DataOutputStream flujoSalida= new DataOutputStream(miSocket.getOutputStream());
			//A traves de esta funcion el mensaje viaja por el flujo se usa esta para strings hay para otros tipos de datos
			flujoSalida.writeUTF(txtTexto.getText());
			
			flujoSalida.close();
			
			//Con esto quedaria la parte del cliente, falta el servidor
			//El servidor hay que ponerlo a la escucha y que abra el puerto indicado
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Alert alerta= new Alert(AlertType.WARNING, e.getMessage());
			alerta.show();
		}
    }

}
