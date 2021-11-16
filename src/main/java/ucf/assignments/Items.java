package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Dynie Mesoneuvre
 */
public class Items
{

    SimpleStringProperty description;//description of the item
    SimpleStringProperty dueDate;//date of the item
    SimpleBooleanProperty completed;//if the item was completed

    //constructor to assign item components to their given variables
    public Items(String description, String dueDate)
    {
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.completed = new SimpleBooleanProperty(false);
    }


    //retrieves Item description
    public String getDescription()
    {
        return description.get();
    }

    //retrieves Item date
    public String getDate()
    {
        return dueDate.get();
    }

    //retrieves Item completed boolean variable
    public Boolean getCompleted()
    {

        return completed.get();
    }

    //uses this.(object) to take user input and place into the description variable
    public void setDescription(String description)
    {
        this.description = new SimpleStringProperty(description);
    }

    //uses this.(object) to take user input and place into the date variable
    public void setDate(String dueDate)
    {

        this.dueDate = new SimpleStringProperty(dueDate);
    }

    //uses this.(object) to take user input and place into the completed variable
    public void setCompleted()
    {
        if(completed.get())
        {
            this.completed = new SimpleBooleanProperty(true);
        }
        else
        {
            this.completed = new SimpleBooleanProperty(false);
        }

    }
}

