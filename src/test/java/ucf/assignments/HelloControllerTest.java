package ucf.assignments;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class HelloControllerTest
{
    @Test
    public void main()
    {
        //testing arraylist
        ArrayList<Items> testList = new ArrayList<Items>();
        Items item1 = new Items("name1", "2021-10-08");
        testList.add(item1);


    }
}
