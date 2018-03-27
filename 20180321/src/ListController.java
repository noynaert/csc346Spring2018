import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ListController {
    private static int count = 0;

    @FXML
    private TextField targetForCount;

    @FXML
    private TableView theView;

    private ObservableList<CourseWrapper> data;

    public ListController(){
        System.out.println("ListController constructor checking in");
    }

    @FXML
    private void initialize(){
        targetForCount.setText("Controller constructor");
        System.out.println("In initialize");
        makeTableView();
    }
    @FXML
    private void makeTableView(){
        //make my columns
        TableColumn courseIdColumn = new TableColumn("Course ID");
        TableColumn titleColumn = new TableColumn("Course Title");


        //Link the fields from the record to the column tables
        courseIdColumn.setCellValueFactory(
                new PropertyValueFactory<CourseWrapper,String>("courseId")
        );
        titleColumn.setCellValueFactory(
          new PropertyValueFactory<CourseWrapper, String>("title")
        );

        //add columns to the table
        theView.getColumns().addAll(courseIdColumn, titleColumn);


        //populate the body of the table with data
        ArrayList<CourseWrapper> list = CourseModel.getArrayList();
        data = FXCollections.observableArrayList(list);
        theView.setItems(data);


    }
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        count++;
        String s = String.format("Button has been pressed %d times",count);
        System.out.println(s);
        targetForCount.setText(s);
    }
}
