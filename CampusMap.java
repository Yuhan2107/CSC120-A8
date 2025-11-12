import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Wilson House", "1 Paradise Road", 4, true, true));
        myMap.addBuilding(new House("Lawrence House", "78 Green Street", 3, false, true));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive", 4, true));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street", 2, false));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive", 2, 1000, 100, 100, 100));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street", 2, 500, 50, 50, 50));
        myMap.addBuilding(new Building("Sage Hall", "144 Green Street", 3));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green Street", 2));
        myMap.addBuilding(new Building("Smith College Museum of Art", "20 Elm Street", 3));
        myMap.addBuilding(new Building("John M. Greene Hall", "220 Elm Street", 3));

        System.out.println(myMap);

        //check the overloaded methods in cafe subclass
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive", 2, 1000, 100, 100, 100);
        compass.sellCoffee(16, 2, 3);
        compass.sellCoffee(12);
        System.out.println("Ingradients left: ");
        System.out.println("Coffee: " + compass.nCoffeeOunces);
        System.out.println("Sugar: " + compass.nSugarPackets);
        System.out.println("Creams: " + compass.nCreams);
        compass.restock(1000, 100, 100, 100);
        compass.restock(2000);
        System.out.println("Ingradients left after restock: \n coffee: " + compass.nCoffeeOunces + "\n Sugar: " + compass.nSugarPackets + "\n Creams: " + compass.nCreams);

        //check the verloaded methods in house subclass
        House haven = new House("haven", "110ElmSt", 3, false,true);
        Student maggie = new Student("maggie", "1024", 2029);
        ArrayList<Student> firstYear = new ArrayList<>();
        Student lois = new Student("Lois", "1057", 2029);
        Student ella = new Student("Ella", "2083", 2029);
        firstYear.add(lois);
        firstYear.add(ella);
        haven.moveIn(maggie);
        haven.moveIn(firstYear);
        System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
        haven.printResidents();
        haven.moveOut(firstYear);
        System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
        haven.printResidents();

        //check the overloaded methods in the library subclass
        Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4, false);
        neilson.addTitle("Harry Potter");
        neilson.addTitle("To Kill a Mockingbird","Harper Lee");
        neilson.printCollection();
        neilson.checkOut("Harry Potter");
        System.out.println("After checked out Harry Potter:");
        System.out.println("We have the book \" To Kill a Mockingbird \" " + neilson.containsTitle("To Kill a Mockingbird","Harper Lee"));
        neilson.printCollection();

    }
    
}
