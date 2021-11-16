package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Scanner;

public class Controller {
    TodoList todoList;
    int currentIndex;
    ObservableList<DisplayItem> displayItems;
    boolean complete, incomplete;


    @FXML

    public TextField IDText;
    public TextField DateText;
    public TextArea DescriptionText;
    public CheckBox Complete;
    public CheckBox FilterComplete;
    public CheckBox FilterIncomplete;
    public TableView<DisplayItem> TodoListView;
    public TableColumn<DisplayItem, Integer> IDList;
    public TableColumn<DisplayItem, SimpleStringProperty> DateList;
    public TableColumn<DisplayItem, SimpleStringProperty> DescriptionList;
    public TableColumn<DisplayItem, SimpleStringProperty> CompleteList;

    public int IDText2Int(){
        if(IDText.getText()!="") {
            Scanner id = new Scanner(IDText.getText());
            return id.nextInt();
        }
        else{
            return -1;
        }
    }

    public void initializeTodoList() {
        if (todoList ==null) {
            todoList = new TodoList();
            currentIndex = -1;
        }
    }

    public void AddItemAction(ActionEvent actionEvent) {
        initializeTodoList();
        currentIndex=todoList.getListSize();
        IDText.setText(""+currentIndex);
        todoList.addItem(DescriptionText.getText(), DateText.getText(), false);
        Complete.setSelected(false);
        display();
    }

    public void RemoveItemAction(ActionEvent actionEvent) {
        todoList.removeItem(IDText2Int());
        display();
    }

    public void ClearAllAction(ActionEvent actionEvent) {
        initializeTodoList();
        todoList.removeAllItem();
        display();
    }

    public void FindItem(ActionEvent actionEvent) {
        initializeTodoList();
        int index = IDText2Int();
        if(todoList.validateIndex(index)){
            currentIndex = index;
            DescriptionText.setText(todoList.List.get(currentIndex).getDescription());
            DateText.setText(todoList.List.get(currentIndex).getDate());
            Complete.setSelected(todoList.List.get(currentIndex).getComplete());
        }
    }

    public void ReplaceDescription(ActionEvent actionEvent) {
        initializeTodoList();
        if(todoList.validateIndex(currentIndex)) {
            todoList.List.get(currentIndex).setDescription(DescriptionText.getText());
            DescriptionText.setText(todoList.List.get(currentIndex).getDescription());
        }
        display();
    }

    public void ReplaceDate(ActionEvent actionEvent) {
        initializeTodoList();
        if(todoList.validateIndex(currentIndex)) {
            todoList.List.get(currentIndex).setDate(DateText.getText());
            DateText.setText(todoList.List.get(currentIndex).getDate());
        }
        display();
    }

    public void EnterAll(ActionEvent actionEvent) {
        initializeTodoList();
        if(todoList.validateIndex(currentIndex)) {
            todoList.List.get(currentIndex).setDate(DateText.getText());
            DateText.setText(todoList.List.get(currentIndex).getDate());

            todoList.List.get(currentIndex).setDescription(DescriptionText.getText());
            DescriptionText.setText(todoList.List.get(currentIndex).getDescription());
        }
        display();
    }

    public void CompleteAction(ActionEvent actionEvent) {
        complete = FilterComplete.isSelected();
        display();
    }

    public void IncompleteAction(ActionEvent actionEvent) {
        incomplete = FilterIncomplete.isSelected();
        display();
    }

    public void LoadFileAction(ActionEvent actionEvent) {
        initializeTodoList();
    }

    public void SaveAction(ActionEvent actionEvent) {
        initializeTodoList();
    }

    public void ToggleComplete(ActionEvent actionEvent) {
        initializeTodoList();
        if(todoList.validateIndex(currentIndex)){
            todoList.List.get(currentIndex).toggleComplete();
            display();
        }
    }

    public  void display(){
        IDList.setCellValueFactory(new PropertyValueFactory<DisplayItem, Integer>("ID"));
        DateList.setCellValueFactory(new PropertyValueFactory<DisplayItem, SimpleStringProperty>("date"));
        DescriptionList.setCellValueFactory(new PropertyValueFactory<DisplayItem, SimpleStringProperty>("description"));
        CompleteList.setCellValueFactory(new PropertyValueFactory<DisplayItem, SimpleStringProperty>("complete"));
        TodoListView.setItems(getItemList());
    }

    private ObservableList<DisplayItem> getItemList() {
        displayItems = FXCollections.observableArrayList();
        for(int i=0; i<todoList.getListSize(); i++){
            boolean completeItem = todoList.List.get(i).getComplete();
            if((completeItem && !incomplete) || (!completeItem && !complete)){
                displayItems.add(new DisplayItem(i, todoList.List.get(i).getDate(), todoList.List.get(i).getDescription(), completeItem));
            }
        }
        return displayItems;
    }
}