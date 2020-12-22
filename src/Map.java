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
        phamacy, supermarket, library, court_house, judges_office;

        // create the rooms
        pharmacy = new Room("outside the main entrance of the university",
                Items.MASTERKEY, items.FLASHLIGHT);
        supermarket = new Room("in a lecture theater", items.PEPPERSPRAY);
        library = new Room( "in the campus pub", Items.BOOK);
        court_house = new Room("in a computing lab", Items.COIN);
        judgesoffice = new Room("in the computing admin office", Items.RING);

        // initialise room exits
        outside.setExit("east", phamacy);
        outside.setExit("south", supermarket);
        outside.setExit("west", ouside);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", library);

        office.setExit("west", court_house);

        startRoom = pharmacy;  // start game outside
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
