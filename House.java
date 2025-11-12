/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * constructor for the House
   * @param name Name of the house
   * @param adress Adress of the house
   * @param nFloors Number of floors the house has
   * @param hasDiningRoom Whether the house has dining room
   * @param hasElevator Whether the house has elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Override the showOptions of House for it's special methods and the inherited methods
   */
  @Override
  public void showOptions(){
    super.showOptions();
    System.out.println("hasDiningRoom() \n nResidents() \n moveIn(s) \n moveOut(s) \n isResident(s)");
  }

 /**
     * Overrides goToFloor to enforce elevator restrictions.
     * @param floorNum Target floor number
     * @throws RuntimeException If not inside the building, invalid floor, or non-adjacent floor without elevator
     */
    @Override
    public void goToFloor(int floorNum) {
        if (!hasElevator && Math.abs(floorNum - activeFloor) > 1) {
            throw new RuntimeException("No elevator! Can only move to adjacent floors.");
        }
        super.goToFloor(floorNum);
    }

  /**
   * return whether the house has dining room
   * @return Whether the house has dining room
   */
  @Override
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * return the number of residents in this house
   * @return The number of residents in this house
   */
  @Override
  public int nResidents(){
    return residents.size();
  }

  /**
   * add a new student into the arraylist as the student moves into the house
   * @param s The new student that moves in
   */
  @Override
  public void moveIn(Student s){
    residents.add(s);
  }

  /**
   * Overload: move in a bunch of students (eg. in the beginning of the semester)
   * @param students list of students being added
   */
  public void moveIn(ArrayList<Student> students){
    residents.addAll(students);
  }

  /**
   * delete the student from the arraylist when the students moves out
   * @param s The student moving out
   */
  @Override
  public Student moveOut(Student s){
    residents.remove(s);
    return s; // return the Student who moved out
  }

  /**
   * Overload: move out a bunch of students (eg. guaduated)
   * @param students the list of students being removed
   * @return The list of students that have been removed from the house
   */
  public ArrayList<Student> moveOut(ArrayList<Student> students){
    residents.removeAll(students);
    return students;
  }
  
  /**
   * check whether the student is living in this house
   * @param s The students checking
   * @return whether the student is living in this house (contains in the arraylist)
   */
  @Override
  public boolean isResident(Student s){
    return residents.contains(s);
  }
  
  /**
   * print our the name of the current residents
   */
  public void printResidents(){
    for(Student student : residents){
      System.out.println(student.getName());
    }
  }

  /**
   * make up a house and a students to check methods written above
   */
  public static void main(String[] args) {
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
    haven.moveOut(firstYear);
    System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
    System.out.println(haven.getName() + " has dining room: " + haven.hasDiningRoom());
    haven.moveOut(maggie);
    System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
    haven.goToFloor(2);
    haven.showOptions();
  }

}