/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Austin Mathew
 */

package ucf.assignments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FileIO {
    InputFile inputFile;
    FileIO() throws FileNotFoundException {
        this("");
    }

    FileIO(String fileName) throws FileNotFoundException {
        if(fileName.isBlank()) {
            inputFile = new InputFile();
        }
        else{
            inputFile = new InputFile(fileName);
        }
    }
    public void loadFile(TodoList todoList){
        int ListSize = inputFile.inputReader.nextInt();
        for(int i=0; i<ListSize; i++){
            String date = inputFile.inputReader.nextLine();
            String description = inputFile.inputReader.nextLine();
            boolean complete = inputFile.inputReader.nextLine().equals("y");
            todoList.List.add(new Item(description, date, complete));
        }
    }

    public void setOutput(String fileName) throws IOException {
        if(fileName.isBlank()){
            inputFile.createOutputFile();
        }
        else{
            inputFile.createOutputFile(fileName);
        }

    }

    public void saveFile(TodoList todoList) throws IOException {
        inputFile.outputFile.outWriter.write(todoList.getListSize()+"\n");
        for(int i=0; i<todoList.getListSize(); i++){
            inputFile.outputFile.outWriter.write(todoList.List.get(i).getDate()+"\n");
            inputFile.outputFile.outWriter.write(todoList.List.get(i).getDescription()+"\n");
            if(todoList.List.get(i).getComplete()){
                inputFile.outputFile.outWriter.write("y\n");
            }
            else{
                inputFile.outputFile.outWriter.write("n\n");
            }
        }
    }
}
