public class Map
{
    private Room startRoom;

    /**
     *
     */
    public Map ()
    {
        createRooms();
    }


    /**
     * Create all the rooms and link their exits together.
     */

    private void createRooms()
    {
        Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university", Items.POGO_STICK);
        theater = new Room("in a lecture theater", Items.BOOK);
        pub = new Room( "in the campus pub", Items.WATER);
        lab = new Room("in a computing lab", Items.CALCULATOR);
        office = new Room("in the computing admin office", Items.VACCINE);

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }

    /**
     *
     * @return
     */
    public Room getStartRoom()
    {
        return startRoom;
    }
}
