// Main class

public class Character extends Object {

// Data Members
    private String name;
    private String team;
    private String universe;
    private String homePlanet;
    // what is Stats?
        // Its a reference variable that stores 5 stats for the character                                                                                   
    private Stats stats;

    // Constructors
    public Character() {
        this.stats = new Stats();
    }

    public Character(String name, String team, String universe, String homePlanet, Stats stats) {
        this.name = name;
        this.team = team;
        this.universe = universe;
        this.homePlanet = homePlanet;
        this.stats = stats;

    }

    // Getter's and Setter's
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  TEAM: should store which side the Character is on: HEROES or VILLAINS 
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // universe: should store “Marvel” or “DC”
    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
    // s is a reference variable to a Stats object

    public Stats getStats() {
        return stats;
    }
    
    
    //  toString() method

    @Override
    public String toString() {
        String a = "";

       

        a += String.format("   Name:         %s\n",getName());
        a += String.format("   Team:         %s\n",getTeam());
        a += String.format("   Universe:     %s\n",getUniverse());
        a += String.format("   Home Planet:  %s\n",getHomePlanet());
        
       a += stats.toString();
         
       

        return a;
    }
    
    
} // end of class
