/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.ArrayList;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private String status;
  private boolean hasElevator;

    /**
     * constructor of the library
     * @param name Name of library
     * @param address Address of library
     * @param nFloors Number of floors in the library
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      String status = "unavailable";
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }
    
    /**
     * Override the showOptions of House for it's special methods and the inherited methods
     */
    @Override
    public void showOptions(){
      super.showOptions();
      System.out.println("addTitle(title) \n removeTitle(title) \n checkOut(title) \n returnBook(title) \n containsTitle(title) \n isAvailable(title) \n printCollection()");
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
     * add a book into the library
     * @param title The title of the new book 
     */
    @Override
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * Overload: Add book with author (store as "Title - Author")
     * @param title Book title
     * @param author Book author
     */
    public void addTitle(String title, String author) {
        String fullTitle = title + " by " + author;
        collection.put(fullTitle, true);
        System.out.println("Added: " + fullTitle);
    }

    /**
     * remove a book from the library
     * @param title The name of the removal book
     * @return The title of the book that's been removed
     */
    @Override
    public String removeTitle(String title){
      collection.remove(title);
      return title; // return the title that we removed
    }

    /**
     * checkout the book from the library
     * @param title The title of the book being checked out
     */
    @Override
    public void checkOut(String title){
      collection.replace(title,false);
    }

    /**
     * return a book to the library
     * @param title The returning book's title
     */
    @Override
    public void returnBook(String title){
      collection.replace(title, true);
    }

    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title The title of the book that is being checked
     * @return Whether the book is in the library
     */
    @Override
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    /**
     * Overload: check whether the library have a book by the specific author
     * @param title Book title
     * @param author Book author
     * @return Whether the hashtable contains the book
     */
    public boolean containsTitle(String title, String author){
      String fullTitle = title + " by " + author;
      return collection.containsKey(fullTitle);
    }

    /**
     * returns true if the title is currently available, false otherwise
     * @param title The title of the book is being checked
     * @return The status of the book -- whether it is available now
     */
    @Override 
    public boolean isAvailable(String title){
      return collection.getOrDefault(title, false);
    }

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status
     */
    @Override 
    public void printCollection(){
      for(String title : collection.keySet()){
        if (collection.get(title)){
          status = "available";
        }else{
          status = "checked out";
        }
        System.out.println(" - " + title + " [ " + status + " ];");
      }
    }

    /**
     * make up a library and check the methods under this class 
     */
    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4, false);
      neilson.addTitle("Harry Potter");
      neilson.addTitle("To Kill a Mockingbird","Harper Lee");
      neilson.printCollection();
      neilson.checkOut("Harry Potter");
      System.out.println("After checked out Harry Potter:");
      System.out.println("We have the book \" To Kill a Mockingbird \" " + neilson.containsTitle("To Kill a Mockingbird","Harper Lee"));
      neilson.printCollection();
      neilson.goToFloor(3);
    }
}