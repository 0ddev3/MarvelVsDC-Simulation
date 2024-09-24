
// Name: Yvette Boyd
// Date: 4/1/2024
// email: ev3boyd@gmail.com
// Assignment title: Program 4
import java.util.*;

public class Marvel_vs_DC {

    // Method to add Character 
    public static void addCharacter(ArrayList<Character> chars, String[] inputLine) {
        // If inputLine[1] is "superhv", we know this a super power Character
        if (inputLine[1].equals("superhv")) {
            // Get the information from the array of strings InputLine
            // String name, String team, String universe, String homePlanet, Stats s, ArrayList<String> powers
            String name = inputLine[2];
            String team = inputLine[3];
            String universe = inputLine[4];
            String homePlanet = inputLine[5];

            // get the Stats directly from inputLine
            int intelligence = Integer.parseInt(inputLine[6]);
            int strength = Integer.parseInt(inputLine[7]);
            int stamina = Integer.parseInt(inputLine[8]);
            int speed = Integer.parseInt(inputLine[9]);
            int skills = Integer.parseInt(inputLine[10]);

            // Create a new Stats object 
            Stats stats = new Stats(intelligence, strength, stamina, speed, skills);

            // Extracting superpowers from inputLine
            ArrayList<String> superpowers = new ArrayList<>();
            for (int i = 11; i < inputLine.length; i++) {
                superpowers.add(inputLine[i]);
            }

            // CREATE a new SuperHv Object
            SuperHV superhv = new SuperHV(name, team, universe, homePlanet, stats, superpowers);
            //Save the new SuperHv object into the chars ArrayList
            chars.add(superhv);
            // Print the character details CALLING THE TOSTRING()

            System.out.println(superhv.toString());

            //
        }
        else {
            // ELSE,the character is an NPC:
            // Get the information from inputLine: name, team, universe, homePlanet
            String name = inputLine[1];
            String team = inputLine[2];
            String universe = inputLine[3];
            String homePlanet = inputLine[4];

            // Get the Stats from inputLine
            int intelligence = Integer.parseInt(inputLine[5]);
            int strength = Integer.parseInt(inputLine[6]);
            int stamina = Integer.parseInt(inputLine[7]);
            int speed = Integer.parseInt(inputLine[8]);
            int skills = Integer.parseInt(inputLine[9]);

            // Create a new Stats object 
            Stats stats = new Stats(intelligence, strength, stamina, speed, skills);

            // CREATE a new Character Object
            Character character = new Character(name, team, universe, homePlanet, stats);
            // Add the Character object to the chars ArrayList
            chars.add(character);
            System.out.println("");

            // PRINT CHARACTER DETAILS USING TOSTRING()
            System.out.println(character.toString());
            // Print the stats 

        }

    }

    // method to add power to a charcter 
    public static void addPower(ArrayList<Character> chars, String[] inputLine) {
        // Check if the character is empty 
        if (chars.isEmpty()) {
            // if empty print the error message 
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            return; // Return if there are no characters
        }

        // Get character name and potential power
        String characterName = inputLine[1];
        String power = inputLine[2];

        // Keep track if the character is found
        boolean characterFound = false;

        //  LOOP, through the chars ArrayList to find the character
        for (int i = 0; i < chars.size(); i++) {
            Character character = chars.get(i);
            if (character.getName().equals(characterName)) {
                characterFound = true;

                // Check if the character is an instance of SuperHV
                if (character instanceof SuperHV superhv) {
                    // if so get Powers froms superhv and SAVE it into an array of strings called powers
                    ArrayList<String> powers = superhv.getPowers();

                    // Check if the character already has the power
                    if (powers.contains(power)) {
                        // print error message
                        System.out.println("ERROR: " + characterName + " already has the superpower of " + power + ".");
                    }
                    else {
                        // Add the power to the character
                        powers.add(power);
                        System.out.println(characterName + " now has the new superpower of " + power + ".");
                    } // END OF ELSE STATEMENT

                }
                // END OF IF STATEMENT
            } // END OF IF STATEMENT
        } // END OF FOR LOOP

        // If character is not found
        if (!characterFound) {
            // print error message
            System.out.println("ERROR: " + characterName + " is not a character currently in the system.");
        } // END OF IF STATEMENT
    } // end of method 

    // The user is trying to search for a character
    public static void searchCharacter(ArrayList<Character> chars, String[] inputLine) {
        // Check if the arrayList of characters(chars) is empty
        if (chars.isEmpty()) {
            // Print error message, there are no characters in the system
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Extract character name from inputLine
            String characterName = inputLine[1];

            // Keep track if the characater is found
            boolean found = false;

            // Iterate through the chars ArrayList to find the character
            for (int i = 0; i < chars.size(); i++) {
                //  get the character theb save it into a character which is type Character Object
                Character character = chars.get(i);
                // IF, chaarcter name equals CharacterName from input
                if (character.getName().equals(characterName)) {
                    //  Print the character's information: name, team, universe, home planet, stats, powers
                    System.out.println(character.toString());
                    found = true; // set found to true
                    break; // exit the loop once the character is found
                }
            }

            //  No characters exist or if the given character is not found
            if (!found) {
                //  Print error message, they are not in the system
                System.out.printf("ERROR: %s is not a character currently in the system.", characterName);
                System.out.println(""); // for spacing 
                // example: 
                // ERROR: Green Arrow is not a character currently in the system 
            } // end of if statement
        } // end of Is empty method
    } // end of method

    // Method to display Heros
    public static void displayHeros(ArrayList<Character> chars, String[] inputLine) {
        // Check if there are no characters in the system
        if (chars.isEmpty()) {
            // Print error message, no charcters in the system
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Keep track if any heroes are found
            boolean heroesFound = false;

            // Iterate through the chars ArrayList to find the heroes
            for (int i = 0; i < chars.size(); i++) {
                //  get the character theb save it into a character which is type Character Object
                Character character = chars.get(i);

                // IF, character team equals Heroes
                if (character.getTeam().equals("Heroes")) {
                    // Set heroesFound to true if a hero is found
                    heroesFound = true;

                    // Print the details of the hero
                    System.out.println(" -----------------------------------------");
                    // Use the character toString method to print the chaarcter details
                    System.out.println(character.toString());

                }
            }

            // If no heroes were found
            if (!heroesFound) {
                // print there were no heros found
                System.out.println("There are no Heroes in the system.");
            }
        }
    }

    // Method to display villains
    public static void displayVillains(ArrayList<Character> chars, String[] inputLine) {
        // Check if there are no characters in the system
        if (chars.isEmpty()) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Keep track if any Villains are found
            boolean villainsFound = false; // set it to false

            // Iterate through the chars ArrayList to find the Villains
            for (int i = 0; i < chars.size(); i++) {
                Character character = chars.get(i);

                // Check if the character is a Villains
                if (character.getTeam().equals("Villains")) {
                    // Set heroesFound to true if a Villains is found
                    villainsFound = true; // set

                    // Print the details of the Villains
                    System.out.println(" -----------------------------------------");
                    System.out.println(character.toString());
                    ;
                }
            }

            // If no Villains were found
            if (!villainsFound) {
                System.out.println("There are no Villains in the system.");
            }
        }
    } // end of method

    // Display Marvel characters
    public static void displayMarvel(ArrayList<Character> chars, String[] inputLine) {
        // Check if there are no characters in the system
        if (chars.isEmpty()) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Keep track if any heroes are found
            boolean marvelFound = false;

            // Iterate through the chars ArrayList to find the heroes
            for (int i = 0; i < chars.size(); i++) {
                Character character = chars.get(i);

                // Check if the character is a marvel character
                if (character.getUniverse().equals("Marvel")) {
                    // Set heroesFound to true if a marvel character is found
                    marvelFound = true;

                    // Print the details of the marvel character
                    System.out.println(" -----------------------------------------");
                    System.out.println(character.toString());

                } // end of if statement
            } // end of for loop

            // IF there is no a marvel character found
            if (!marvelFound) {
                System.out.println("There are no Marvel characters in the system.");
            } // end of if statement
        }
    } // end of method

    // Display DC characters
    public static void displayDc(ArrayList<Character> chars, String[] inputLine) {
        // Check if there are no characters in the system
        if (chars.isEmpty()) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Keep track if any DC characters are found
            boolean DCFound = false;

            // Iterate through the chars ArrayList to find the heroes
            for (int i = 0; i < chars.size(); i++) {
                // Get the character from the chaarcter array
                Character character = chars.get(i);

                // Check if the character is a hero
                if (character.getUniverse().equals("DC")) {
                    // Set DCFound to true if a DC character is found
                    DCFound = true;

                    // Print the details of the DC character
                    System.out.println(" -----------------------------------------");
                    System.out.println(character.toString());
                } // end of if statement
            } // end of for loop

            // If no DC characters were found
            if (!DCFound) {
                System.out.println("There are no DC characters in the system.");
            } // end of if statement
        } // end of else statement
    } // end of method

    public static void displayStats(ArrayList<Character> chars) {
        // Check if the chars ArrayList is empty or not
        if (chars.isEmpty()) {
            // IF, it is empty, Print error message 
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            return;
        } // end of if statement

        // Display stats for Marvel characters
        displayUniverseStat(chars, "Marvel");
        // Display stats for DC characters
        displayUniverseStat(chars, "DC");

    } // end of method 

    // Helper Method to Display the Chaarcters
    public static void displayUniverseStat(List<Character> characters, String universe) {
        // ArrayList called universeChars to hold characters
        List<Character> universeC = new ArrayList<>();

        //LOOP over all characters to find what universe they are from
        for (Character c : characters) {
            // IF, the universe of THAT character equals the correct universe
            if (c.getUniverse().equals(universe)) {
                // ADD it into the newly created ArrayList(universeChars)
                universeC.add(c);
            } // end of if statements
        } // end of for loop  

        // IF, the list of the universe is empty
        if (universeC.isEmpty()) {
            System.out.println("   " + universe + " Characters");
            System.out.println("      There are currently no " + universe + " characters in the system.");
            return;
        }
        System.out.println("   " + universe + " Characters");

        // Separate heroes and villains
        List<Character> heroes = new ArrayList<>();
        List<Character> villains = new ArrayList<>();
        //LOOP over the charcater
        for (Character c : universeC) {
            if (c.getTeam().equals("Heroes")) {
                heroes.add(c);
            }
            else if (c.getTeam().equals("Villains")) {
                villains.add(c);
            }
        }
        // Calculate stats for heroes and villains
        calculateAndDisplayStats(heroes, "Heroes", "Hero");
        calculateAndDisplayStats(villains, "Villains", "Villain");
    }

    // HELPER METHOD to display and calculate Stats
    public static void calculateAndDisplayStats(List<Character> characters, String type, String team) {
        // IF, the character array is empty
        if (characters.isEmpty()) {
            // Print the title: which is the the type of character
            //System.out.println("      " + type);
            // And the fact that theya re not in the system at all
            System.out.println("         There are currently no" + type + " characters in this category.");
            return;
        }

        // Initialize variables for averages and counts
        int totalIntelligence = 0, totalStrength = 0, totalStamina = 0, totalSpeed = 0, totalSkill = 0;

        int superPowerCount = 0;

        // Create a new ArrayList of superPowers
        List<String> superPowers = new ArrayList<>();

        // Loop through the ArrayList of characters
        for (Character character : characters) {

            //  Find the averages of each stat and save it into a variable
            totalIntelligence += character.getStats().getIntelligence();
            totalStrength += character.getStats().getStrength();
            totalStamina += character.getStats().getStamina();
            totalSpeed += character.getStats().getSpeed();
            totalSkill += character.getStats().getSkills();

            // If character has superpowers, increment count and add them
            if (character instanceof SuperHV) {
                SuperHV superChar = (SuperHV) character;
                // increment superPowerCount
                superPowerCount++;
                // Loop through the characters with a super power
                for (String power : superChar.getPowers()) {
                    // Check if the power is already in the list
                    if (!superPowers.contains(power)) {
                        // ADD, the power if it's not already there
                        superPowers.add(power);

                    } // end of if statement
                } // end of for-loop
            } // end of if statement 
        } // end of for loop

        // Calculate the averages of eachs stat
        int count = characters.size(); // this equals the size of chaarcters

        double avgIntelligence = (double) totalIntelligence / count;
        double avgStrength = (double) totalStrength / count;
        double avgStamina = (double) totalStamina / count;
        double avgSpeed = (double) totalSpeed / count;
        double avgSkill = (double) totalSkill / count;

        // Display the calculated stats
        System.out.println("   " + team + " Stats:");
        System.out.printf("         Average Intelligence: %.2f\n", avgIntelligence);
        System.out.printf("         Average Strength:     %.2f\n", avgStrength);
        System.out.printf("         Average Stamina:      %.2f\n", avgStamina);
        System.out.printf("         Average Speed:        %.2f\n", avgSpeed);
        System.out.printf("         Average Skill:        %.2f\n", avgSkill);

        System.out.println("    Number of Normal-Person " + type + ": " + (count - superPowerCount));
        System.out.println("    Number of " + type + " with Superpowers: " + superPowerCount);

        // Print the SuperPowers but make sure only once NOT many time
        System.out.println("      Aggregate Superpowers:");
        
        // Loop over the arrayList of superpowers
        // Loop over the ArrayList of superpowers using a traditional for loop
for (int i = 0; i < superPowers.size(); i++) {
    // Print the power
    System.out.print(superPowers.get(i));
    
    // Check if it's not the last power
    if (i < superPowers.size() - 1) {
        // Print a comma and a space
        System.out.print(", ");
    }
}
        // I want to print a comma and a space after each power but I end up having an extra comma
        System.out.println("");
    } // end of method

// Method for two characters to fight
    public static void fightPlayers(ArrayList<Character> chars, String[] inputLine) {
        // Check if there are no characters in the system
        if (chars.isEmpty()) {
            // Print error message
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else {
            // Get the names of the charcters involved in the fight
            // this is from the inputLine[]
            String character1Name = inputLine[1];
            String character2Name = inputLine[2];

            // keep track of characters found
            boolean char1Found = false;
            boolean char2Found = false;

            // IKeep track whether the characters are both null
            Character c1 = null, c2 = null;
            // Loop through chars ArrayList
            for (int i = 0; i < chars.size(); i++) {
                // GET the character and SAVE it into the variable character
                Character character = chars.get(i);
                // CHARACTER 1
                if (character.getName().equals(character1Name)) {
                    // WE found the character
                    char1Found = true; // set char1Found to true
                    c1 = character; // saving the character into the variable c1
                }
                // CHARACTER 2
                if (character.getName().equals(character2Name)) {
                    // WE found the seconf character 
                    char2Found = true; // set char2Found to true
                    c2 = character; // save that character into the variable c2
                } // end of if statment
            } // end of for loop

            // If char1 OR char2 not found
            if (!char1Found || !char2Found) {
                // Print error message
                System.out.println("    ERROR: cannot execute command. One or more characters cannot be found.");
                // if char1 not found
                if (!char1Found) {
                    // Print that specific character is not found
                    System.out.println(character1Name + " is not a character currently in the system.");
                }
                // if char2 not found
                if (!char2Found) {
                    // Print that specific character is not found
                    System.out.println(character2Name + " is not a character currently in the system.");
                }
            }
            // IF BOTH FOUND
            else {
                // Calculate attack power for character 1
                int attackPower1 = calculateAttackPower(c1);
                // Calculate attack power for character 2
                int attackPower2 = calculateAttackPower(c2);
                // PRINT, the name of both characters
                System.out.println("   " + c1.getName() + " vs " + c2.getName());
                System.out.println(); // for spacing

                // Print first fighter
                System.out.println("   Fighter #1:");
                // call the character's tostring method
                System.out.println(c1.toString());
                System.out.println("");

                //Print, second fighter 
                System.out.println("   Fighter #2:");
                System.out.println();
                // call the character's tostring method
                System.out.println(c2.toString());
                System.out.println("");

                // Print fight details
                System.out.println("   Fight Results:");

                // keep track of automatic win
                boolean automaticWin = false;

                if ((c1 instanceof SuperHV && !(c2 instanceof SuperHV))
                        || (!(c1 instanceof SuperHV) && c2 instanceof SuperHV)) {
                    // One character has superpowers and the other does not
                    automaticWin = true;

                    // basically if c1 has a superpower and c2 doesnt, c1 wins
                    if (c1 instanceof SuperHV) {
                        System.out.println("    " + c2.getName() + " has no superpowers. Thus, " + c1.getName() + " wins every time.");
                    }
                    // if c2 has a superpower and c1 doesnt, c2 wins
                    else {
                        System.out.println("    " + c1.getName() + " has no superpowers. Thus, " + c2.getName() + " wins every time.");
                    }
                }
                // if they BOTH have a superpower, the winner is determined by total attackpower
                else {
                    System.out.println("        " + c1.getName() + "'s total attack power: " + attackPower1);
                    System.out.println("        " + c2.getName() + "'s total attack power: " + attackPower2);
                }

                // Compare attack powers if there was no automatic win
                if (!automaticWin) {
                    if (attackPower1 > attackPower2) {
                        System.out.println("    Winner: " + c1.getName());
                    }
                    else if (attackPower1 < attackPower2) {
                        System.out.println("    Winner: " + c2.getName());
                    }
                    else {
                        System.out.println("    It's a tie!");
                    } // end of else statement
                } // end of if statement
            }
        }

    } // end of method 

    // HELPER METHOD FOR ATTACK POWER
    public static int calculateAttackPower(Character character) {
        // GET the stats and ADD them up
        int totalStats = character.getStats().getIntelligence()
                + character.getStats().getStrength()
                + character.getStats().getStamina()
                + character.getStats().getSpeed()
                + character.getStats().getSkills();

        int totalPowers = 0;
        // IF, character has a super power
        if (character instanceof SuperHV) {
            // get the power size and increment total powers
            totalPowers = ((SuperHV) character).getPowers().size();
        }
        // Then, add 10 points per superpower(using total powers)
        int attackPower = totalStats + (10 * totalPowers);

        // return the attack power
        return attackPower;
    }

// The Purpose of the main is to progress the program 
    public static void main(String[] args) {
        // Create a Scanner and Save it into a variable
        // Purpose: use this newly created and saved variable to compare and check user input
        Scanner in = new Scanner(System.in);
        // Looking at the Sample, we realize that the input can take a big line of information 
        // Therefore, we will be saving that long piece of info into an Array called command.
        String[] inputLine; // declare inputLine as an array of Strings

        //  Create an empty ArrayList of Character references
        ArrayList<Character> chars = new ArrayList<>(); // all the character data is stored here

        // Create a do-While loop
        do {

            // read each line of input 
            inputLine = in.nextLine().split(",");

            if (inputLine[0].equals("ADDCHARACTER")) {
                System.out.println("Command: ADDCHARACTER");
                addCharacter(chars, inputLine);

            }
            else if (inputLine[0].equals("ADDPOWER")) {
                System.out.println("Command: ADDPOWER");
                addPower(chars, inputLine);

            }
            else if (inputLine[0].equals("SEARCHCHARACTER")) {
                System.out.println("Command: SEARCHCHARACTER");
                searchCharacter(chars, inputLine);

            }
            else if (inputLine[0].equals("DISPLAYHEROES")) {
                System.out.println("Command: DISPLAYHEROES");
                displayHeros(chars, inputLine);

            }
            else if (inputLine[0].equals("DISPLAYVILLAINS")) {
                System.out.println("Command: DISPLAYVILLAINS");
                displayVillains(chars, inputLine);

            }
            else if (inputLine[0].equals("DISPLAYMARVEL")) {
                System.out.println("Command: DISPLAYMARVEL");
                displayMarvel(chars, inputLine);

            }
            else if (inputLine[0].equals("DISPLAYDC")) {
                System.out.println("Command: DISPLAYDC");
                displayDc(chars, inputLine);

            }
            else if (inputLine[0].equals("DISPLAYSTATS")) {
                System.out.println("Command: DISPLAYSTATS");
                displayStats(chars);

            }
            else if (inputLine[0].equals("FIGHT")) {
                System.out.println("Command: FIGHT");
                fightPlayers(chars, inputLine);

            }
            else if (inputLine[0].equals("EXIT")) {
                // if command is EXIT
                System.out.print("\nGoodbye.");
                break;
            }
            else {
                // If input is anything else
                System.out.println("Input is not valid. Please try again.");
            }
        } while (true); // end while Loop

    } // end of main method 

} // end of class

