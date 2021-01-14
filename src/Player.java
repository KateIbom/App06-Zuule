import java.util.ArrayList;

public class Player
{
    private String name;
    private int experience;

    private ArrayList <Items> itemList;
    private int score;
    private int health;

    public Player ( String name)
    {
        score = 0;
        health = 100;
        experience = 0;
        itemList =  new ArrayList<>();
    }
    public boolean hasItem(Items targetItem)
    {
        for (Items item : itemList)
        {
            if (item == targetItem)
                return true;
        }
        return false;
    }

    public void takeItem(Items item)
    {
        itemList.add(item);
    }
}
