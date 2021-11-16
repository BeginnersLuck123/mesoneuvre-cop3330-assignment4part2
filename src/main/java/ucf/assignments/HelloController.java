package ucf.assignments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Dynie Mesoneuvre
 */

public class HelloController {

    //initializing a list for user interactions
    List list = new List();

    //initializing display
    static ObservableList<Items> display = FXCollections.observableArrayList();

    //initializing buttons that will perform functions when pressed by user
    @FXML
    private Button addItem;
    @FXML
    private Button deleteItem;
    @FXML
    private Button editItem;
    @FXML
    private Button displayAll;
    @FXML
    private Button clearAll;
    @FXML
    private Button displayCompleted;
    @FXML
    private TableColumn<Items, Boolean> completed;
    @FXML
    private Button displayIncomplete;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField fileField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TableView<Items> table;
    @FXML
    private TableColumn<Items, String> description;
    @FXML
    private TableColumn<Items, String> dueDate;
    @FXML
    private Button save;
    @FXML
    private Button load;

  //creating function to switch between the welcome screen to the main listview screen
    public void screenSwitch(ActionEvent actionevent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listView.fxml")));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //creating function to switch between listview screen to the itemview screen
    public void screenSwitch2(ActionEvent actionevent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("itemView.fxml")));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    //creating function to switch between the itemview screen and the listview screen
    public void screenSwitch3(ActionEvent actionevent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listView.fxml")));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
        //adds an item to the list
    void addItem(ActionEvent event)
    {
        Items item = new Items(descriptionField.getText(), dateField.getValue().toString());

        list.addItem(item);
        table.getItems().add(item);

        table.refresh();

        description.setText("");
        dateField.setValue(null);


    }

    @FXML
    //removes an item from the list
    void removeItem(ActionEvent event) {

        Items task = table.getSelectionModel().getSelectedItem();


        list.removeItem(task);
        table.getItems().remove(task);


        table.refresh();
    }

    @FXML
    //allows user to edit the item
    void editItem(ActionEvent event) {

        Items current = table.getSelectionModel().getSelectedItem();
        current.setCompleted();
        table.refresh();
    }

    @FXML
    //empties out the list
    void clearEverything(ActionEvent event)
    {
        list.clearAll();
        table.getItems().clear();
        table.refresh();
    }

    @FXML
    //displays all items in the list
    void displayAll(ActionEvent event)
    {
        display = FXCollections.observableArrayList(list.getItems());
        table.setItems(display);
        table.refresh();
    }

    @FXML
    //displays only completed items in the list
    void displayCompletedItems(ActionEvent event)
    {
        display = FXCollections.observableArrayList(list.getCompletedItems());
      table.setItems(display);
      table.refresh();

    }

    @FXML
   //displays only incomplete items in the list
    void displayIncomplete(ActionEvent event) {
        display = FXCollections.observableArrayList(list.getIncompleteItems());
        table.setItems(display);
        table.refresh();
    }

    @FXML
    //edits the item's due date
    void doneEditedDueDate(ActionEvent event)
    {
        Items current = table.getSelectionModel().getSelectedItem();
        String str = dateField.getValue().toString();
        current.setDate(str);
        table.refresh();
    }

    @FXML
    //edits the item's description
    void done2EditDescription(ActionEvent event) {
        Items current = table.getSelectionModel().getSelectedItem();
        String str = description.getText();
        current.setDescription(str);
        table.refresh();

    }

    @FXML
    //loads the list into storage
    void load(ActionEvent event) {


        File file = new File("./lists/.csv");
        display = FXCollections.observableArrayList(list.loadOption(file).toDoTasks);
        table.setItems(display);
        table.refresh();
        fileField.setText("");

    }

    @FXML
    //saves the list into storage
    void save(ActionEvent event) {
        File file = new File("./lists/.csv");
        fileField.setText("");

    }

}