/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Austin Mathew
 */

package ucf.assignments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {

//        public FileWriter outWriter
    public FileWriter outWriter;
//        //writes to output file

//        private String fileName
    private String fileName;
//        //holds output file name

//        OutputFile(){
//            OutputFile(default name)
//        }
    OutputFile() throws IOException {
        this("TodoListStorage.txt");
    }

//        OutputFile(String fileName){
//            create File object of fileName
//            catch error
//                ifError(fileName)
//        }
    OutputFile(String fileName) throws IOException {
        File output = new File(fileName);
        if(output == null){
            ifError();
        }
        else{
            setOutWriter(output);
            this.fileName = fileName;
        }

    }

//        private ifError(String fileName){
//            set fileName = "Error"
//        }
    void ifError(){
        fileName = "Error";
    }
//        private setOutWriter(fileName){
//            creates FileWriter object to fileName and sets it to outWriter
//        }
    private void setOutWriter(File output) throws IOException {
        outWriter = new FileWriter(output);
    }
//        String getFileName(){
//            return fileName
//        }
    String getFileName(){
        return fileName;
    }

}
