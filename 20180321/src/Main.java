
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        System.out.println("Starting fx");

        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //ArrayList<CourseWrapper> list = CourseModel.getArrayList();
        //System.out.println("List size is " + list.size());


        launch(args);
    }
}
