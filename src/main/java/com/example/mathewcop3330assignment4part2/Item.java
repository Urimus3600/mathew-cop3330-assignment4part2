package com.example.mathewcop3330assignment4part2;

import java.util.Scanner;

public class Item {

//    private String description
    private String description;
//    //holds description of the item

//    private boolean complete
    private boolean complete;
//    //indicates that task is completed with true value

//    private int date[3];
    private int[] date;
//    //holds integers for {day, month, year}
//
//    Item(){
    Item() {

//        set description = "No Description"
        description = "No Description";
//        set to uncomplete complete = false
        complete = false;
//        set date to 0-0-0000 or date = {0,0,0}
        date = new int[]{0,0,0};
//    }
    }
//    Item(String description, String date){
    Item(String description, String date) {
//        passes to next constructor with added parameter of false
//        Item(description, date, false)
        this(description, date, false);
//    }
    }

//    item(String description, String date, boolean complete){
    Item(String description, String date, boolean complete) {
//        call setDescription of description
        setDescription(description);
//        call setDate of date
        setDate(date);
//        this class's complete = complete
        this.complete = complete;
//    }
    }
//
//    private boolean validateDate(String date){
    private boolean validateDate(String date) {
//        checks if date is in format mm-dd-yyyy
//        also that values of each are within expected values
        int i=0;
        if(date.charAt(i)>='0' && date.charAt(i++)<='1' && date.length()==10){
            if(date.charAt(i)>='0' && date.charAt(i++)<='9'){
                if(date.charAt(i++)=='-'){
                    if(date.charAt(i)>='0' && date.charAt(i++)<='3'){
                        if(date.charAt(i)>='0' && date.charAt(i++)<='9'){
                            if(date.charAt(i++)=='-'){
                                if(date.charAt(i)>='0' && date.charAt(i++)<='9'){
                                    if(date.charAt(i)>='0' && date.charAt(i++)<='9'){
                                        if(date.charAt(i)>='0' && date.charAt(i++)<='9'){
                                            if(date.charAt(i)>='0' && date.charAt(i)<='9'){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Invalid Date");
        return false;
//    }
    }

//    setDescription(String description){
    public boolean setDescription(String description) {
//        if description is valid
        if(!description.isBlank()){
            this.description = description;
//            set this class's description equal to description
            return true;
        }

//        else
        else{
            this.description = "No Description";
//            set this class's description to "No Description"
            return false;
        }

//    }
    }

//    String getDescription(){
    String getDescription() {
//        return description
        return description;
//    }
    }
//    toggleComplete(){
    void toggleComplete() {
//        flip truth value of complete from false to true or true to false
        complete = !complete;
//    }
    }
//    bool getComplete(){
    boolean getComplete() {
//        return complete
        return complete;
//    }
    }
//    private String getDate(){
//        return concatenated string of integer at 1 then a dash then the one at 0 then dash then the one at 2
//    }
    private String getDate(){
        String Date, day, month, year;
        if(date[0]<10)
            day = "0"+date[0];
        else
            day = "" + date[0];

        if(date[1]<10)
            month = "0"+date[0];
        else
            month = "" + date[0];

        if(date[2]<1000){
            year = "0" + date[2];
            if(date[2]<100){
                year="00" + date[2];
                if(date[2]<10){
                    year="000" + date[2];
                    if(date[2]==0){
                        year="0000";
                    }
                }
            }
        }
        else
            year = "" + date[0];
        Date = month+"-"+day+"-"+year;
        return Date;
    }

//    int getYear(){
//        return date's third integer
//    }
    int getYear(){
        return date[2];
    }

//    int getMonth(){
//        return date's second integer
//    }
    int getMonth(){
        return date[1];
    }

//    int getDay(){
//        return date's first integer
//    }
    int getDay(){
        return date[0];
    }

//    setDate(String date){
    boolean setDate(String date) {
//        if validateDate(date)
        if (validateDate(date)) {
            date = date.replaceAll("-", " ");
            Scanner dateString = new Scanner(date);
//            read in integer from front into second integer of date
            this.date[1] = dateString.nextInt();
//            skip 1 character
//            read in integer into first
            this.date[0] = dateString.nextInt();
//            skip 1 character
//            read in integer into third
            this.date[2] = dateString.nextInt();
            return true;
        }
//        else
        else {
//            date is set to hold zeros
            this.date[0] = 0;
            this.date[1] = 0;
            this.date[2] = 0;
            return false;
        }
    }
//    }
}
