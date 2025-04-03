import java.util.Scanner;

public class Combat{

    private static double DAMAGE;
    private static boolean IN_COMBAT =true ;
    private static boolean deathCheck = false;

    public static boolean gameOverCheck(){
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
            System.out.println("Testing: " + playerCharacter.getLife() + "..." + enemyLife);
            System.out.println("What will you do?");
            System.out.println("1. Attack");
            System.out.println("2. Evade");


            //Add an avoid option, forfeiting rewards

            //Include an "Invalid Selection"

            userChoice = sc.nextInt();

            switch(userChoice){

                case 1:
                    System.out.println("You attack the "+enemyName+" for "+playerCharacter.attackDamage());
                    enemyLife= enemyLife-playerCharacter.attackDamage();
                    if (enemyLife<=0){
                        IN_COMBAT=false;
                        return;
                    }
                    break;

                case 2:
                    System.out.println("You block the enemy attack");
                    break;
            }

            if (userChoice != 2) {
                System.out.println("The " + enemyName+" attacks you for " + enemyDamage+".");
                int newCharHealth = (int)(playerCharacter.getLife() - enemyDamage);
                playerCharacter.setLife(newCharHealth);
                int charLife=(int)playerCharacter.getLife();
                if (charLife <=0){
                    IN_COMBAT=false;
                    deathCheck=true;
                    return;
                }
            }
            else if (userChoice==2){
                System.out.println("You evade the enemy attack, they only nick you");
                int newCharHealth = (int)(playerCharacter.getLife()-1);
                playerCharacter.setLife(newCharHealth);
                int charLife=(int)playerCharacter.getLife();
                if (charLife <=0){
                    IN_COMBAT=false;
                    deathCheck=true;
                    return;
                }
            }


        }while (IN_COMBAT);


    }
}