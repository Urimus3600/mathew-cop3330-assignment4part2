/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Austin Mathew
 */

package ucf.assignments;

import java.util.ArrayList;

public class TodoList {

//    public ArrayList<item> List
    public ArrayList<Item> List;
//    //will hold items for the list

//    private int ListSize
    private int ListSize;
//    //keeps track of list size for certain operations

//
//    TodoList(){
//        title = "No Title"
//        set ListSize to 0
//    }
    TodoList(){
        List = new ArrayList<>();
        ListSize=0;
    }


//    addItem(String description, String date, boolean complete){
//        create object of Item with above parameters
//        add the object to List
//        increaseListSize()
//    }
    public void addItem(String description, String date, boolean complete){
        List.add(new Item(description, date, complete));
        increaseListSize();
    }

//    removeItem(int index){
//        if validateIndex confirms index being part of List
//            remove item from list
//            decreaseListSize()
//    }
    boolean removeItem(int index){
        if(validateIndex(index)){
            List.remove(index);
            decreaseListSize();
            return true;
        }
        else
            return false;
    }

//    removeAllItem(){
//        uses loop to iterate from ListSize to 0
//            removes items from end to beginning of array
//    }
    void removeAllItem(){
        for(int i=ListSize-1; i>=0; i--){
            List.remove(i);
        }
        ListSize = 0;
    }

//    private boolean validateIndex(int index){
//        if int index > 0 and < length of array
//            return true
//        else
//            return false
//    }
    boolean validateIndex(int index){
        return (index >= 0 && index < ListSize);
    }

//    private increaseListSize(){
//        increase ListSize by 1
//    }
    private void increaseListSize(){
        ListSize++;
    }
//    private decreaseListSize(){
//        decrease ListSize by 1
//    }
    private void decreaseListSize(){
        ListSize--;
    }

//    int getListSize(){
//        return ListSize
//    }
    int getListSize(){
        return ListSize;
    }
}
