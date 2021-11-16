package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;

import java.io.*;
import java.util.ArrayList;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Dynie Mesoneuvre
 */
public class List
{
    //initialized an Items arraylist filled with to do tasks to complete, add, remove, or edit
    ArrayList<Items> toDoTasks = new ArrayList<Items>();

    //Constructor assigning the arraylist
    public List()
    {

        toDoTasks = new ArrayList<>();
    }

    //retrieves items from list Items
    public ArrayList<Items> getItems(){
        return toDoTasks;
    }


    //add an item from the list Items
    public void addItem(Items item )
    {
        toDoTasks.add(item);
    }

    //removes an item from the list Items
    public void removeItem(Items item)
    {
        toDoTasks.remove(item);
    }

    //clears out list Items
    public void clearAll()
    {
        toDoTasks.clear();
    }

    //gets incomplete items, which have a false completed boolean variable
    public ArrayList<Items> getIncompleteItems()
    {
        ArrayList<Items> incompleteItems = new ArrayList<>();

        for (Items t : toDoTasks) {
            if (t.completed.get() == false) {
                incompleteItems.add(t);
            }
        }
        return incompleteItems;
    }

    //gets completed item, which have a true completed boolean variable
    public ArrayList<Items> getCompletedItems()
    {
        ArrayList<Items> completedItems = new ArrayList<>();

        for(Items t : toDoTasks)
        {
            if(t.completed.get() == true)
                completedItems.add(t);
        }

        return completedItems;
    }

  //Creating the CSV storage to store in user data
    public void storage(File directory)
    {
        try
        {
            BufferedWriter directoryView = new BufferedWriter(new FileWriter(directory));

            directoryView.write("Item Description:");
            directoryView.write(",");
            directoryView.write("Item Due Date:");
            directoryView.write(",");
            directoryView.write("Is Item Completed?");
            directoryView.write("\n");

            //goes through the toDoTask array of items and writes out user input into the CSV file
            for(Items item: toDoTasks)
            {
                directoryView.write(item.getDescription());
                directoryView.write(",");

                directoryView.write(item.getDate());

                if(item.completed.get())
                {
                    directoryView.write("Item is Completed");
                }
                else
                {
                    directoryView.write("Item is Incomplete");
                }
            }

            directoryView.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    //loads up the items
public List loadOption(File directory)
{
    List list = new List();

    //creating another arraylist filled with Items to be used
    ArrayList<Items> moreItems = new ArrayList<>();
    list.toDoTasks = moreItems;

    //writing user input data
    try{
        BufferedReader reader = new BufferedReader(new FileReader (directory));

        String reader2  = "";
        reader2= reader.readLine();

        //Splits user info up into pieces within the directory
        while((reader2 = reader.readLine()) != null)
        {
            String[] str1 = reader2.split(",");
            Items item = new Items(str1[0], str1[1]);

            //shows completed variable if the item is done or not
            if(str1[2].equals("complete")){
                item.completed = new SimpleBooleanProperty(true);
            }else{
                item.completed = new SimpleBooleanProperty(false);
            }

            moreItems.add(item);
        }
        toDoTasks = moreItems;

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

   //retrieves list
    return list;
}


}
