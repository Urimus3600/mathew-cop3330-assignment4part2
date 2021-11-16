/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Austin Mathew
 */

package ucf.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InputFile {

//    OutputFile outputFile
    OutputFile outputFile;
//    //sets up possibility for save to same or other file

//    public Scanner inputReader
    Scanner inputReader;
//    //lets input file be read

//    private String fileName
    private String fileName;
//    //holds name of input file
//
//    InputFile(){
//        calls other constructor with default fileName
//    }
    InputFile() throws FileNotFoundException {
        this("TodoListStorage.txt");
    }

//    InputFile(String fileName){
//        open input file
//            checks if valid
//                sets error name to fileName
//            else
//                calls setInputReader
//    }
    InputFile(String fileName) throws FileNotFoundException {
        File input = new File(fileName);
        if(input==null){
            ifError();
        }
        else{
           setInputReader(input);
        }

    }
//    private ifError(String fileName){
//        print out failure to create input file scanner
//    }
    void ifError(){
        fileName = "Error";
    }

//    private setInputReader(File input){
//        scanner for file reading to fileName
//        catch error
//    }
    private void setInputReader(File input) throws FileNotFoundException {
        inputReader = new Scanner(input);
    }
//    String getFileName(){
//        return fileName
//    }
    String getFileName(){
        return fileName;
    }
//    createOutputFile(){
//        create instance of OutputFile and set to outputFile
//    }
    void createOutputFile() throws IOException {
        outputFile = new OutputFile();
    }
//    createOutputFile(String fileName){
//        create instance of OutputFile with parameter and set to outputFile
//    }
    void createOutputFile(String fileName) throws IOException {
        outputFile = new OutputFile(fileName);
    }
}
