/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Derek and Andrei
 */

public class Game
{
    private Map map;
    private Parser parser;
    private Location currentLocation;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        map = new Map();
        currentLocation = map.getStartRoom();
        player = new Player("John");
        play();
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (!finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentLocation.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord)
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case LOOK:
                System.out.println(currentLocation.getLongDescription());
                break;

            case GO:
                goLocation(command);
                break;

            case TAKE:

                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private void takeItem()
    {
        System.out.println("\nYou have taken the " +
                currentLocation.getContainedItem() +"\n");

        player.takeItem(currentLocation.getContainedItem());
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goLocation(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Location nextLocation = currentLocation.getExit(direction);

        enterLocation(nextLocation);

    }

    private void enterLocation(Location nextLocation)
    {
        if (nextLocation == null)
        {
            System.out.println("There is no door!");
        }
        else
        {
            if (player.hasItem(nextLocation.getRequiredItem()))
            {
                currentLocation = nextLocation;
                System.out.println(currentLocation.getLongDescription());
                currentLocation.printItem();
            }
            else {
                System.out.println("You cannot enter this room because you do not have a" + nextLocation.getRequiredItem());
                currentLocation.printItem();
                System.out.println(currentLocation.getLongDescription());
                currentLocation.printItem();
            }

        }
    }

    private boolean canEnterLocation(Location nextLocation)
    {
        if (nextLocation. getName(). equals("Library"))
        {
            if (player.hasItem(Items.BOOK))
            {
                return true;
            }
        } //TODO must add all other locations

        return false;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
