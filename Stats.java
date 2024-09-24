//subclass
public class Stats{
    
    // Data Memebers 
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;
    
    // Constructors
    public Stats() {
    }

    public Stats(int intelligence, int strength, int stamina, int speed, int skills) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
    }
    
    // Getter's and Setters

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }
    
    // toString Method

    @Override
    public String toString() {
       String a = "";
       
        a += String.format("   Stats:        Intelligence: %d\n", getIntelligence());
        a += String.format("                 Strength:     %d\n", getStrength());
        a += String.format("                 Stamina:      %d\n", getStamina());
        a += String.format("                 Speed:        %d\n", getSpeed());
        a += String.format("                 Skills:       %d", getSkills());
        
       return a; 
    }
    
} // end of class
