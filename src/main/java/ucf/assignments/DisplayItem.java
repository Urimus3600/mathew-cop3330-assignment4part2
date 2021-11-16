package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class DisplayItem {
    public SimpleStringProperty ID;
    public SimpleStringProperty date;
    public SimpleStringProperty description;
    public SimpleStringProperty complete;

    DisplayItem( int ID, String date, String description, boolean complete){
        this.ID = new SimpleStringProperty(""+ID);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date);
        if(complete){
            this.complete = new SimpleStringProperty("yes");
        }
        else{
            this.complete = new SimpleStringProperty("no");
        }
    }

    public final SimpleStringProperty dateProperty() {
        return this.date;
    }

    public final SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    public final SimpleStringProperty IDProperty() {
        return this.ID;
    }

    public final SimpleStringProperty completeProperty() {
        return this.complete;
    }

}
