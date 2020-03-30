package fxtest;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;  
import javafx.stage.Stage;  

public class JavaFxTest extends Application{  
@Override  
public void start(Stage s) throws Exception {  

    s.setTitle("OCR"); 

    doOCR perform=new doOCR();
    TilePane r = new TilePane(); 
    Button btn = new Button("Browse Image");  
    btn.setTranslateX(50);
    btn.setTranslateY(250);
    Text text = new Text();      
    
    //Setting the text to be added. 
    text.setText("OCR Application"); 
     
    //setting the position of the text 
    text.setTranslateX(450);
    text.setTranslateY(50);
    text.setId("head");
    r.getChildren().add(text);
    btn.setId("sel");
    Label l = new Label("Click Perform OCR"); 
    l.setFont(Font.font ("Verdana", 20));
    btn.setOnAction(e->  
    {  	
        FileChooser file = new FileChooser();  
        file.setTitle("Choose Image");  
        //System.out.println(pic.getId());  
        File file1 = file.showSaveDialog(s);  
        String str=file1.toString();
        Button b=new Button();
        FileInputStream input;
		try {
			text.setX(0);
			text.setTranslateY(-100);
	        r.getChildren().remove(b);
	        r.getChildren().remove(l);
			input = new FileInputStream(str);
			Image i = new Image(input);
	        ImageView iw = new ImageView(i);
			iw.setFitHeight(300);
			btn.setTranslateX(450);
			btn.setTranslateY(-100);
			iw.setFitWidth(300);
			
	        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	                l.setText(perform.performOCR(str)); 
	                
	            } 
	        };
	        
	        b = new Button("Perform OCR", iw);
	        r.getChildren().remove(btn);
	        l.setTranslateX(-150);
	        b.setTranslateY(150);
	        l.setTranslateY(150);
	        b.setTranslateX(-150);
	        b.setOnAction(event);
	        r.getChildren().add(b);
	        r.getChildren().add(l);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    });  
    r.getChildren().add(btn); 

    // create a scene 
    Scene sc = new Scene(r, 1300, 600); 
    sc.getStylesheets().add("a.css");
    

    // set the scene 
    s.setScene(sc); 

    s.show(); 
}  
public static void main(String[] args) {  
    launch(args);  
      
}  
}  