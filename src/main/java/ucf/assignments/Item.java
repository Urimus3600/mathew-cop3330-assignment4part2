package ucf.assignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Item {

//    private String description
    private String description;
//    //holds description of the item

//    private boolean complete
    private boolean complete;
//    //indicates that task is completed with true value

//    private int date[3];
    private String date;
//    //holds integers for {year, month, day}
//
//    Item(){
    Item() {

//        set description = "No Description"
        description = "No Description";
//        set to uncomplete complete = false
        complete = false;
//        set date to 0-0-0000 or date = {0,0,0}
        date = "No Date";
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

//    setDescription(String description){
    public boolean setDescription(String description) {
//        if description is valid
        if((!description.isBlank()) && (description.length()<=256)){
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
        return date;
    }
    final static String DATE_FORMAT = "yyyy-MM-dd";

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

//    setDate(String date){
    boolean setDate(String date) {

//        if validateDate(date)
        if (isDateValid(date)) {
            this.date = date;
            return true;
        }
//        else
        else {
//            date is given default
            this.date = "No Date";
            return false;
        }
    }
//    }
}
