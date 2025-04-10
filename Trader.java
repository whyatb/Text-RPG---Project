import java.sql.SQLOutput;
import java.util.Scanner;
public class Trader {
//Maybe add a check for max health so as to not overheal player
    public static void tradeInitiate(){
        Scanner sc = new Scanner(System.in);
        boolean stillTrading=false;
        System.out.println("Welcome weary adventurer!");
        System.out.println("I have ways to make you stronger, if you have ways to make me richer.");
        System.out.println("Browse from my stock, please, pick what fancies you.");
        do{
            boolean correctInput=true;
            do{
                try{

                    System.out.println("1. 5 Gold: Scroll of power [+Strength]");
                    System.out.println("2. 10 Gold: Potion of health [Heals 10 health on purchase]");
                    System.out.println("3. 10 Gold: Increase weapon damage [+Weapon Damage]");
                    int userChoice = sc.nextInt();
                    if (userChoice==1){
                        double tempStrength = playerCharacter.getStrength()+1;
                        double tempGold = playerCharacter.getGold()-5;
                        if(tempGold<0){
                            System.out.println("You seem a bit strapped for gold.");
                            System.out.println("Come back to me when you have some more, I can't give you this for now.");
                        }
                        else{
                            playerCharacter.setStrength(tempStrength);
                            playerCharacter.removeGold(5);
                            System.out.println("Good choice my friend.");
                            System.out.println("[New gold] ["+tempGold+"]");
                            System.out.println("[New Strength] ["+(int)tempStrength+"]");
                        }
                        correctInput=true;
                    }
                    else if (userChoice==2){
                        double tempLife = playerCharacter.getLife()+10;
                        double tempGold = playerCharacter.getGold()-10;
                        if(tempGold<0){
                            System.out.println("You seem a bit strapped for gold.");
                            System.out.println("Come back to me when you have some more, I can't give you this for now.");
                        }
                        else{
                            playerCharacter.setLife(tempLife);
                            playerCharacter.removeGold(10);
                            System.out.println("Excellent choice my friend!");
                            System.out.println("[New gold] ["+tempGold+"]");
                            System.out.println("[New health] ["+tempLife+"]");
                        }
                        correctInput=true;
                    }
                    else if(userChoice==3){
                        double tempWeaponDamage = playerCharacter.getWeaponDamage()+1;
                        double tempGold = playerCharacter.getGold()-10;
                        if(tempGold<0){
                            System.out.println("You seem a bit strapped for gold.");
                            System.out.println("Come back to me when you have some more, I can't give you this for now.");
                        }
                        else{
                            playerCharacter.setWeaponDamage(tempWeaponDamage);
                            playerCharacter.removeGold(10);
                            System.out.println("Wonderful choice my friend!");
                            System.out.println("[New gold] ["+tempGold+"]");
                            System.out.println("[New weapon damage] ["+tempWeaponDamage+"]");
                        }
                        correctInput=true;
                    }
                    else{
                        System.out.println("Invalid choice, please enter 1, 2, or 3");
                        correctInput=false;
                    }
                }catch (Exception e){
                    System.out.println("Invalid input, please enter an integer");
                    correctInput=false;
                    sc.nextLine();
                }
            }while (!correctInput);

            int userChoice;
            do{
                try{
                    System.out.println("Buying anything else?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    userChoice=sc.nextInt();
                    if (userChoice==1){
                        System.out.println("Excellent! What else will you have?");
                        stillTrading=true;
                        correctInput=true;
                    }
                    else if (userChoice==2){
                        System.out.println("Good luck my friend!");
                        stillTrading=false;
                        correctInput=true;
                    }
                    else{
                        System.out.println("Invalid choice, please enter 1 or 2");
                        correctInput=false;
                    }
                }catch (Exception e){
                    System.out.println("Invalid input, please enter an integer");
                    correctInput=false;
                    sc.nextLine();
                }
            }while(!correctInput);
        }while(stillTrading);
    }
}
