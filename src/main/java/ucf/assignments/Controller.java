/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Austin Mathew
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Controller {
    TodoList todoList;
    int currentIndex;
    ObservableList<DisplayItem> displayItems;
    boolean complete, incomplete;
    File file;
    //variables for storing information and states


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
    //items from fxml file which are used here

    //reads in from ID text field and converts to int, or returns non-breaking value if int is not valid

    public int IDText2Int(){
        if(!Objects.equals(IDText.getText(), "")) {
            Scanner id = new Scanner(IDText.getText());
            return id.nextInt();
        }
        else{
            return -1;
        }
    }

    //if not initialized and a button is pressed todolist will be initialized
    //work around for no constructor
    public void initializeTodoList() {
        if (todoList ==null) {
            todoList = new TodoList();
            currentIndex = -1;
        }
    }

    //create new item based on current strings inside textfields
    public void AddItemAction(ActionEvent actionEvent) {
        initializeTodoList();
        currentIndex=todoList.getListSize();
        IDText.setText(""+currentIndex);
        todoList.addItem(DescriptionText.getText(), DateText.getText(), false);
        Complete.setSelected(false);
        display();
    }

    //remove item based on current ID
    public void RemoveItemAction(ActionEvent actionEvent) {
        todoList.removeItem(IDText2Int());
        display();
    }

    //removes all items
    public void ClearAllAction(ActionEvent actionEvent) {
        initializeTodoList();
        todoList.removeAllItem();
        display();
    }

    //displays item in item display based on ID text field
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

    public void LoadFileAction(ActionEvent actionEvent) throws FileNotFoundException {
        initializeTodoList();
        /*initializeFileIO();
        fileIO.loadFile(todoList);*/
        Scanner inputReader = new Scanner("src/main/java/ucf/assignments/Storage.txt");
        int ListSize = inputReader.nextInt();
        for(int i=0; i<ListSize; i++){
            String date = inputReader.nextLine();
            String description = inputReader.nextLine();
            boolean complete = inputReader.nextLine().equals("y");
            todoList.List.add(new Item(description, date, complete));
        }
    }

    public void SaveAction(ActionEvent actionEvent) throws IOException {
        initializeTodoList();
        //initializeFileIO();
        //fileIO.setOutput(fileNameText.getText());
        //fileIO.saveFile(todoList);
        FileWriter outWriter = new FileWriter("src/main/java/ucf/assignments/Storage.txt");
        outWriter.write(todoList.getListSize()+"\n");
        for(int i=0; i<todoList.getListSize(); i++){
            outWriter.write(todoList.List.get(i).getDate()+"\n");
            outWriter.write(todoList.List.get(i).getDescription()+"\n");
            if(todoList.List.get(i).getComplete()){
                outWriter.write("y\n");
            }
            else{
                outWriter.write("n\n");
            }
        }

    }

    public void ToggleComplete(ActionEvent actionEvent) {
        initializeTodoList();
        if(todoList.validateIndex(currentIndex)){
            todoList.List.get(currentIndex).toggleComplete();
            display();
        }
    }

    public  void display(){
        IDList.setCellValueFactory(new PropertyValueFactory<>("ID"));
        DateList.setCellValueFactory(new PropertyValueFactory<>("date"));
        DescriptionList.setCellValueFactory(new PropertyValueFactory<>("description"));
        CompleteList.setCellValueFactory(new PropertyValueFactory<>("complete"));
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