import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application  {
    Button pirate;
    Button chef;
    Label target;

    public static void main(String[] args) {
	    System.out.println("Starting");
	    launch(args);
	    System.out.println("Done");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Talk lake a ...");
        VBox layout = new VBox();
        Scene mainScene = new Scene(layout, 500, 300);
        layout.setAlignment(Pos.CENTER);

        primaryStage.setScene(mainScene);

        pirate = new Button("Pirate");



        chef = new Button();
        chef.setText("Chef");

        //pirate.setOnAction(this);
        //chef.setOnAction(this);

        pirate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Talk like a Pirate");
                target.setText("The ale waves endurance like a dead doubloons.");
            }
        });
        chef.setOnAction(event->{
           primaryStage.setTitle("Talk like a Chef");
            target.setText("With ramens drink honey.");
        });

        target = new Label("The starship trembles alarm like an evasive transporter.");

        layout.getChildren().add(chef);
        layout.getChildren().add(pirate);
        layout.getChildren().add(target);



        primaryStage.show();
    }

   // @Override
   /* public void handle(ActionEvent event) {
        System.out.println("An event Occurred " + event.getSource());
        if(event.getSource() == pirate){
            target.setText("Comrade of a big desolation, raid the treasure!");
        }
        if(event.getSource() == chef){
            target.setText("All children like pressed cabbages in triple sec and vegemite.");
        }

    }*/
}
