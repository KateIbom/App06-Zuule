public class Map
{
    private Location pharmacy;
    private Location superMarket;
    private Location library;
    private Location courtHouse;
    private Location judgesOffice;
    private Location postOffice;
    private Location barclaysBank;
    private Location jail;
    private Location townHall;
    private Location townCenter;
    private Location clockTower;
    private Location startLocation;


    /**
     *
     */
    public Map ()
    {
        createLocations();
    }


    /**
     * Create all the locations and link their exits together.
     */

    private void createLocations()
    {

        // create the rooms
        townCenter = new Location("town center", Items.COIN);
        pharmacy = new Location("inside the pharmacy",
                Items.MASTER_KEY);
        superMarket = new Location("in the supermarket isle", Items.PEPPER_SPRAY);
        library = new Location( "standing by the return desk", Items.BOOK);
        courtHouse = new Location("you are in front of the judges bench", Items.COIN);
        judgesOffice = new Location("by the judges desk", Items.RING);

        initialiseLocations();

        startLocation = townCenter;  // start game outside
    }

    private void initialiseLocations()
    {
        // initialise room exits
        townCenter.setExit("pharmacy", pharmacy);
        pharmacy.setExit("outside", townCenter);

        townCenter.setExit("supermarket", superMarket);
        superMarket.setExit("outside", pharmacy);

        townCenter.setExit("library", library);
        library.setExit("outside", courtHouse);

        townCenter.setExit("courthouse", courtHouse);
        courtHouse.setExit("inside", judgesOffice);

        townCenter.setExit("townhall", townHall);
        townHall.setExit("outside", townCenter);
    }

    /**
     *
     * @return
     */
    public Location getStartRoom()
    {
        return startLocation;
    }
}
