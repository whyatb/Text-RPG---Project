import java.util.Scanner;

public class Combat{

    private static double DAMAGE;
    private static boolean IN_COMBAT;
    private static boolean deathCheck = false;

    private static boolean gameOverCheck(){
        return deathCheck;
    }


    //combat loop takes in a variable that sets the type of enemy in the fight, then the enemystats class returns the stats using functions such as GoblinLife and KnightLife
    //These stats will be fed into temps variables for the loops

    public void CombatLoop(){

        Scanner sc = new Scanner(System.in);

        double enemyLife = 0;
        double enemyDamage = 0;
        String enemyName = "Null";
        int userChoice;

        int enemyType = Enemy.getRandomEnemyType();


        switch (enemyType){

            case 1:
                enemyLife = EnemyStats.goblinLife();
                enemyDamage = EnemyStats.goblinDamage();
                enemyName = "Goblin";
                break;

            case 2:
                enemyLife = EnemyStats.knightLife();
                enemyDamage = EnemyStats.knightDamage();
                enemyName = "Knight";
                break;

            case 3:
                enemyLife = EnemyStats.ogreLife();
                enemyDamage = EnemyStats.ogreDamage();
                enemyName = "Ogre";

            case 4:
                enemyLife = EnemyStats.titanLife();
                enemyDamage = EnemyStats.titanDamage();
                enemyName = "Titan";
        }

        System.out.println("You come upon a " + enemyName);

        do{

            System.out.println("What will you do?");
            System.out.println("1. Attack");
            System.out.println("2. Block");
            //Add an avoid option, forfeiting rewards

            //Include an "Invalid Selection"

            userChoice = sc.nextInt();

            switch(userChoice){

                case 1:
                    System.out.println("You attack the "+enemyName+" for "+Character.attackDamage());
                    enemyLife= enemyLife-Character.attackDamage();
                    if (enemyLife<=0){
                        IN_COMBAT=false;
                        return;
                    }
                    break;

                case 2:
                    System.out.println("You block the enemy attack");
                    break;
            }
            if (userChoice == 2){
                System.out.println("You block the attack, taking no damage");
            }
            else {
                System.out.println("The "+enemyName+" attacks you for "+enemyDamage+".");
                int newCharHealth = (int)(Character.getLife() - enemyDamage);
                Character.setLife(newCharHealth);
            }

            if (enemyLife<=0||Character.stats[1]<=0){
                IN_COMBAT=false;
            }
        }while (IN_COMBAT);
        int healthCheck;
        healthCheck = (int)Character.getLife();
        if (healthCheck <= 0){
            deathCheck = true;
        }
    }
}