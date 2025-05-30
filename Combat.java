import java.util.Random;
import java.util.Scanner;

public class Combat{

    private static double DAMAGE;
    private static boolean IN_COMBAT = true ;
    private static boolean deathCheck = false;
    private static boolean evaded = false;
    private static boolean enemySlain = false;
    private static boolean finalBossBool=false;

    public boolean afterCombatChecks(){
        Scanner  s = new Scanner(System.in);
        boolean running = true;
        boolean checkForDeath= Combat.gameOverCheck();
        boolean evasionCheck = Combat.evadedCheck();
        boolean slainEnemy = Combat.deadEnemyCheck();
        if(checkForDeath){
            running = false;
        }
        else if (evasionCheck){
            System.out.println("You evade the enemy entirely, running out of the room without a fight.");
            System.out.println("You feel as if you missed out on something by doing so...");
        }
        else if (slainEnemy&&finalBossBool){
            System.out.println("You have slain the Final Boss of this place.");
            System.out.println("As you exit the dungeon, sunlight streams across your face.");
        }
        else if (slainEnemy){
            System.out.println("You survived the attack. Your foe has dropped...");
            Random rand = new Random();
            int goldGained = rand.nextInt(1,11);
            System.out.println("You gained "+goldGained+" gold!");
            playerCharacter.addGold(goldGained);
            playerCharacter.levelUp();
        }
        return running;
    }

    public static boolean gameOverCheck(){
        return deathCheck;
    }

    public static boolean evadedCheck(){ return evaded;}

    public static boolean deadEnemyCheck(){ return enemySlain;}


    //combat loop takes in a variable that sets the type of enemy in the fight, then the enemystats class returns the stats using functions such as GoblinLife and KnightLife
    //These stats will be fed into temps variables for the loops

    public void CombatLoop(int enemyChosen){

        Scanner sc = new Scanner(System.in);



        double enemyLife = 0;
        double enemyDamage = 0;
        String enemyName = "Null";
        int userChoice;

        int enemyType = enemyChosen;


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
                break;

            case 4:
                enemyLife = EnemyStats.titanLife();
                enemyDamage = EnemyStats.titanDamage();
                enemyName = "Titan";
                break;
            case 5:
                enemyLife = EnemyStats.ratSwarmLife();
                enemyDamage = EnemyStats.ratSwarmDamage();
                enemyName = "Rat Swarm";
                break;
            case 6:
                enemyLife = EnemyStats.beatenGoblinLife();
                enemyDamage = EnemyStats.beatenGoblinDamage();
                enemyName = "Beaten Goblin";
                break;
            case 7:
                enemyLife = EnemyStats.ratCoveredGoblinLife();
                enemyDamage = EnemyStats.ratCoveredGoblinDamage();
                enemyName = "Rat Covered Goblin";
                break;
            case 8:
                enemyLife=EnemyStats.finalBossLife();
                enemyDamage=EnemyStats.finalBossDamage();
                enemyName="Boss";
        }

        int tempLife=(int)EnemyStats.getLIFE();
        int finalBossCheck = tempLife*4;
        if (enemyLife<=finalBossCheck){
            System.out.println("You come upon a " + enemyName);
        }
        else{
            finalBossBool=true;
            System.out.println("You enter the room of the Final Boss.");
            System.out.println("Shivers run down your spine as you confront what seems to be an insurmountable enemy.");
        }


        do{
            //System.out.println("Testing: " + playerCharacter.getLife() + "..." + enemyLife);

            //Include an "Invalid Selection"

            boolean correctInput=true;
            do{
                try{
                    System.out.println("What will you do?");
                    System.out.println("1. Attack");
                    System.out.println("2. Evade");
                    userChoice = sc.nextInt();
                    if (userChoice == 1) {
                        System.out.println("You attack the "+enemyName+" for "+playerCharacter.attackDamage());
                        enemyLife= enemyLife-playerCharacter.attackDamage();
                        if (enemyLife<=0){
                            IN_COMBAT=false;
                            enemySlain=true;
                            return;
                        }
                        System.out.println("The " + enemyName+" attacks you for " + enemyDamage+".");
                        int newCharHealth = (int)(playerCharacter.getLife() - enemyDamage);
                        playerCharacter.setLife(newCharHealth);
                        int charLife=(int)playerCharacter.getLife();
                        if (charLife <=0){
                            IN_COMBAT=false;
                            deathCheck=true;
                            return;
                        }
                        correctInput=true;
                    }
                    else if (userChoice==2){
                        evaded=true;
                        IN_COMBAT=false;
                        correctInput=true;
                    }
                    else {
                        System.out.println("Invalid choice, please enter 1 or 2");
                        correctInput=false;
                        sc.nextLine();
                    }
                }catch (Exception e){
                    System.out.println("Invalid input, please enter an integer");
                    correctInput=false;
                    sc.nextLine();
                }
            }while(!correctInput);
        }while (IN_COMBAT);
    }
}