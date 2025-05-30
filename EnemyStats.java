import java.util.Random;
public class EnemyStats{

    private static double LIFE = 10;
    private static double DAMAGE = 5;

    public static double goblinLife(){
        return Math.floor(LIFE * .75);
    }
    public static double goblinDamage(){
        return Math.floor(DAMAGE * .75);
    }


    public static double knightLife(){
        return Math.floor(LIFE * 1);
    }
    public static double knightDamage(){
        return Math.floor(DAMAGE * 1);
    }


    public static double ogreLife(){
        return Math.floor(LIFE * 1.5);
    }
    public static double ogreDamage(){
        return Math.floor(DAMAGE * 1.25);
    }


    public static double titanLife(){ return Math.floor(LIFE * 2);}
    public static double titanDamage(){ return Math.floor(DAMAGE * 1.75);}

    public static double ratSwarmLife(){ return Math.floor(LIFE * 1);}
    public static double ratSwarmDamage(){ return Math.floor(DAMAGE  *.2);}

    public static double beatenGoblinLife(){ return Math.floor(LIFE * .5);}
    public static double beatenGoblinDamage(){ return Math.floor(DAMAGE  *.7);}

    public static double ratCoveredGoblinLife(){ return Math.floor(LIFE * 1.2);}
    public static double ratCoveredGoblinDamage(){ return Math.floor(DAMAGE  * .4);}

    public static double finalBossLife(){return Math.floor(LIFE * 5);}
    public static double finalBossDamage(){return Math.floor(DAMAGE * 5);}

    public static double getLIFE(){return LIFE;}
    public static double getDAMAGE(){return DAMAGE;}



}

//TEMP FOR RANDOM TEST
class Enemy{
    // This method returns a random enemy type (1 for Goblin, 2 for Knight, 3 for Ogre)
    public static int getRandomEnemyType() {
        // Generate a random number between 1 and 4
        //rand function, is zero-indexed
        Random rand = new Random();
        return rand.nextInt(4)+1;
        // min is inclusive
        //int min = 1;
        // max is exclusive
        //int max = 5;
        //return (int)Math.floor(Math.random() * (max - min) + min);
        //return (int)(Math.random() * 2) + 1;
    }

}