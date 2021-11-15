package ucf.assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class AllLists {

//    public ArrayList<TodoList> TLList
    public ArrayList<TodoList> TLList;
//    //holds  todoLists

//    private int TLListSize
    private int TLListSize;
//    //stores size of array TLList
//
//    AllLists(){
//        set new array
//        TLListSize = 0
//    }
    AllLists(){
        TLList = new ArrayList<TodoList>();
        TLListSize = 0;
    }
//    loadAll(Scanner inputReader){
//        Scan in number of todolists
//        call for loop for this number
//            call loadTodoList and pass Scanner
//    }
    void loadAll(Scanner inputReader){
        int numTodoLists = 0;
    }

//    loadTodoList(Scanner inputReader){
//        reads in title
//        reads in number of items
//        for loop for number of items
//            reads in each parameter for an item
//            add Item with these parameters to current todolist
//    }
//    storeAll(FileWriter outWriter){
//        print length of array TLList, TLListSize
//            call for loop for this number
//                call storeTodoList with the counter for this for loop
//
//    }
//    storeTodoList(FileWriter outWriter, int index){
//        prints title of todolist
//        prints number of Items
//        call for loop for this number
//            prints Item elements
//    }
//    int getSize(){
//        return TLListSize
//    }
//    private increaseTLListSize(){
//        increase TLListSize by 1
//    }
//
//    private decreaseTLListSize(){
//        decrease TLListSize by 1
//    }
//    addTodoList(String title){
//        create TodoList object with title as parameter
//        add to array TLList
//        increaseTLListSize()
//    }
//    removeTodoList(int index){
//        if validateIndex
//            remove TodoList
//            decreaseTLListSize()
//    }
//
//    private boolean validateIndex(int index){
//        if int index > 0 and < length of array
//            return true
//        else
//            return false
//    }
//
}
