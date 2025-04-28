import java.util.Scanner;
public class playerCharacter {
    // character stats

    // Define the stat names as constants
    private static final String STRENGTH = "Strength";
    private static final String LIFE = "Constitution";
    private static final String WEAPON_DAMAGE = "Weapon Damage";
    private static final String ARMOR_VALUE = "Armor Value";
    private static final String GOLD = "Gold";

    // Stats array to store the character's stats values
    private static double[] stats = {10, 10, 0, 0, 30};

    // Array to store descriptions for each stat
    private String[] statDescription = {STRENGTH, LIFE, WEAPON_DAMAGE, ARMOR_VALUE, GOLD};

//    Unused game over method
//    public static void gameOverText(int input){
//        switch (input){
//            case 1:
//                System.out.println("Insert combat gameovertext");
//                break;
//            case 2:
//                System.out.println("Inset puzzle gameovertext");
//                break;
//            Insert more ways to game over as needed
//        }
//    }

    public static void levelUp(){
        Scanner s = new Scanner(System.in);
        boolean correctInput=true;
        do{
            try{
                System.out.println("You feel power pour into you, how will you channel it?");
                System.out.println("1. Strength");
                System.out.println("2. Health");
                int userChoice = s.nextInt();
                if(userChoice==1){
                    double tempStrength = playerCharacter.getStrength()+1;
                    playerCharacter.setStrength(tempStrength);
                    System.out.println("Your Strength has increased by 1 to "+(int)tempStrength);
                    correctInput=true;
                }
                else if (userChoice==2){
                    double tempLife = playerCharacter.getLife()+1;
                    playerCharacter.setLife(tempLife);
                    System.out.println("Your Health has increased by 1 to "+(int)tempLife);
                    correctInput=true;
                }
                else{
                    System.out.println("Invalid choice, please enter 1 or 2");
                    correctInput=false;
                }
            }catch (Exception e){
                System.out.println("Invalid input, please enter an integer");
                correctInput=false;
                s.nextLine();
            }
        }while(!correctInput);
    }

    // Getter methods for the stats
    public static double getStrength() {
        return stats[0];
    }

    public static double getLife() {
        return stats[1];
    }

    public static double getWeaponDamage() {
        return stats[2];
    }

    public static double getArmorValue() {
        return stats[3];
    }

    public static double getGold() {
        return stats[4];
    }

    public static int attackDamage() {
        int damageDone = (int)Math.floor(getStrength()) + (int)Math.floor(getWeaponDamage());
        return damageDone;
    }
    // Setter methods
    public static void setStrength(double value) {
        stats[0] = value;
    }

    public static void setLife(double value) {
        stats[1] = value;
    }

    public static void setWeaponDamage(double value) {
        stats[2] = value;
    }
    public static void addWeaponDamage(double value){
        value = value + stats[2];
    }

    public static void setArmorValue(double value) {
        stats[3] = value;
    }

    public static void addGold(double addAmount) {
        stats[4] = Math.max(0, stats[4] + addAmount);
    }

    public static void removeGold(double removeAmount) {
        stats[4] = Math.max(0, stats[4] - removeAmount);
    }

    // Calculate total damage output
    public static double calculateDamage() {
        return getStrength() + getWeaponDamage();
    }

    // Calculate total health
    public static double calculateHealth() {
        return getLife() * 5;
    }

    // Calculate damage taken after armor reduction
    public static double calculateDamageTaken (double incomingDamage) {
        return Math.max(0, incomingDamage - getArmorValue());
    }
}

