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
        initialiseLocations();
        setRequiredItems();
    }


    /**
     * Create all the locations and link their exits together.
     */

    private void createLocations()
    {

        // create the rooms
        townCenter = new Location("town center", Items.COIN);
        townHall = new Location("town hall", Items. COIN);
        clockTower = new Location ("open new dimension", Items.COIN);
        pharmacy = new Location("inside the pharmacy",
                Items.MASTER_KEY);
        superMarket = new Location("in the supermarket isle", Items.PEPPER_SPRAY);
        library = new Location( "standing by the return desk", Items.BOOK);
        barclaysBank = new Location("you are with the assistant", Items.CHEQUE);
        postOffice = new Location("you are by the cashier", Items.LETTER);
        courtHouse = new Location("you are in front of the judges bench", Items.COIN);
        judgesOffice = new Location("by the judges desk", Items.RING);
        jail = new Location("you are sitting inside the cell", Items.LAW);



        startLocation = townCenter;  // start game outside
    }
    //
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

        judgesOffice.setExit("courthouse", courtHouse);
        courtHouse.setExit("outside", townCenter);

        courtHouse.setExit("courthouse", jail);
        jail.setExit("inside", courtHouse);

        townCenter.setExit("townhall", townHall);
        townHall.setExit("outside", townCenter);

        townCenter.setExit("barclaysBank", barclaysBank);
        barclaysBank.setExit("outside", postOffice);

        townCenter.setExit("postOffice", postOffice);
        postOffice.setExit("outside", townCenter);

        townHall.setExit("clockTower", clockTower);
        clockTower.setExit("inside", townHall);
    }

    private void setRequiredItems ()
    {
        library.setRequiredItem(Items.LAW);
        townCenter.setRequiredItem(Items.CHEQUE);
        townHall.setRequiredItem(Items.MASTER_KEY);
        clockTower.setRequiredItem(Items.COIN);
        pharmacy.setRequiredItem(Items.COIN);
        superMarket.setRequiredItem(Items.PEPPER_SPRAY);
        barclaysBank.setRequiredItem(Items.CHEQUE);
        postOffice.setRequiredItem(Items.LETTER);
        courtHouse.setRequiredItem(Items.COIN);
        judgesOffice.setRequiredItem(Items.COIN);
        jail.setRequiredItem(Items.CHEQUE);
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
