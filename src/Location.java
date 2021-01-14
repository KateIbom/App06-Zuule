import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Location
{
    private String name;
    private String description;

    // This is the item the room contains
    private Items containedItem;

    // This is the item that is needed to enter
    private Items requiredItem;

    //private String description;
    // String is the key to a room in that direction
    // east would be an exit that goes to the Room
    private HashMap<String, Location> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param item
     */
    public Location(String description, Items item)
    {
        name = this.getClass().getSimpleName(); //use the name of the class as the name of the location
        containedItem = item;

        this.description = description;
        exits = new HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Location neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()

    {

        return "You are " + description + " " + description +
                ".\n" + getExitString() +
                "\n Item in the room is " + containedItem;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void setRequiredItem(Items requiredItem)
    {
        this.requiredItem = requiredItem;
    }

    public Items getRequiredItem()
    {
        return requiredItem;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Location getExit(String direction)
    {
        return exits.get(direction);
    }

    public void setContainedItem(Items item)
    {
        containedItem = item;
    }

    public Items getContainedItem()
    {
        return containedItem;
    }

    public void removeContainedItem()
    {
        containedItem = Items.NONE;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public void printItem()
    {
        System.out.print("Item contained in room " + containedItem);
        System.out.println();
    }
}

