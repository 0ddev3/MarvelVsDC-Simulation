
import java.util.*;

// is this a subclass ?
public class SuperHV extends Character {

// Data Members 
    private ArrayList<String> powers;

    private final ArrayList<String> superpowers;

    // Constructors
    public SuperHV(String name, String team, String universe, String homePlanet, Stats stats, ArrayList<String> superpowers) {
        super(name, team, universe, homePlanet, stats); // Call the constructor of the superclass (Character)
        this.superpowers = superpowers;
    }

    // i might have to loop through and grab????
    // Accessor and mutator methods for powers
    public ArrayList<String> getPowers() {
        return superpowers;
    }

    public void setPowers(ArrayList<String> superpowers) {
        this.powers = superpowers;
    }

    // Other Methods
    // toString()
    @Override
    public String toString() {
        String a = "";

        ArrayList<String> powerss = getPowers();
        // Printing the inherited things of the Character
        a += super.toString();
        // MAYBE: if character already has a power print Error Message
        // IF character  doesn't have a power 

        a += String.format("\n   Powers:       ");
        for (int i = 0; i < powerss.size(); i++) {
            if(i != 0){
                a += ", ";
            }
            a += String.format("%s", powerss.get(i));

        }

        return a;
    }

} // end of class
