/*
TO DO:
0. make enemies in their own class
1. Make Room Types Functional (Make all kinds of rooms)
2. Finish Map (make layout)
3. Finish Combat Loop
4. Create Map
5. Fill out room types
6. Make enemies for rooms
7. Finalize rooms
8. Make menu driver
9. finalize and test
*/


// enemy types are INT so to call them i.e. call enemy:1,2,3

//roomType controls whether room will be noncombat or combat, with number thresholds indicating enemy type I.E 0-1 is non-combat, anything higher determines type of enemy


// nextRoom is the default if there is only one way to go.
// if there are two ways to go

//Navigation menu will read the values of nextRight and nextLeft and if either one is null, then menu will simply have a next-room option, otherwise present a choice

// room type and description is constructed here
import java.util.Scanner;
import java.util.Random;
class Room {

    int roomType;
    String Description;
    int enemyChosen;

    Room nextLeft;
    Room nextRight;
    Room nextRoom;

    public Room(int roomType, String Description, int enemyChosen){
        this.roomType = roomType;
        this.Description = Description;
        this.enemyChosen = enemyChosen;
    }

    public void connectLeft(Room nextLeftRoom){
        this.nextLeft = nextLeftRoom;
    }

    public void connectRight(Room nextRightRoom){
        this.nextRight = nextRightRoom;
    }

    public void connectRoom(Room nextRoom){
        this.nextRoom = nextRoom;
    }
}
//Idea on how to travel from room to room
//    public static void roomTraversal(Room startRoom){
//        Room currentRoom = startRoom;
//        while(currentRoom !=null){
//            currentRoom.displayRoomInfo();
//            currentRoom = currentRoom.nextRoom;
//        }
//    }


//public void getGameOverCheck(){
//        gameOverCheck();
//    }
//    public static boolean getDeathCheck(){
//        return deathCheck;
//    }


public class Main {

    //placeholder enemy health

    int health;
    public void getEnemy(int enemyHealth){
        this.health = enemyHealth;
    }

    //test


    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);

        // room type and description is stored here

       /* Room r1 = new Room(0, "Outside",1);
        Room r2 = new Room(0, "Entrance",1);
        Room r3 = new Room(1, "Combat 1",1);
        Room r4 = new Room(2, "Combat 2",1);
        Room r5 = new Room(0, "Puzzle 1",1);
        Room r6 = new Room(0, "Combat 3",1);
        Room r7 = new Room(0, "",1);
        Room r8 = new Room(0, "room description",1);
        Room r9 = new Room(0, "room description",1);
        Room r10 = new Room(0, "room description",1);
        Room r11 = new Room(0, "room description",1);
        Room r12 = new Room(0, "room description",1);
        Room r13 = new Room(0, "room description",1);
        Room r14 = new Room(0, "room description",1);
        Room r15 = new Room(0, "room description",1);

        r1.connectRoom(r2);
        r2.connectRoom(r3);

        r3.connectLeft(r4);
        r3.connectRight(r5);

        r4.connectRoom(r6);
        r6.connectRoom(r8);

        r5.connectRoom(r7);
        r7.connectLeft(r8);

        r8.connectRight(r10);
        r10.connectLeft(r13);
        r10.connectRight(r12);
        r13.connectRoom(r14);

        r7.connectRight(r9);
        r9.connectLeft(r10);
        r9.connectRight(r11);
        r11.connectLeft(r12);
        r12.connectRoom(r14);
        r14.connectRoom(r15);*/

        // main running to give a way to end the game while in map
    boolean running = true;
    while (running) {
        //loops 15 random rooms
        for (int i = 0; i <= 14; i++) {
            //weighs the odds so there is a 80% chance to have either a combat or puzzle room
            //20% chance to show the trader menu
           int weight = (int) (Math.random() * 100);
           int roomSelect;
           if (weight < 80) {
               roomSelect = (int) (Math.random() * 2) + 1;
           } else {
               roomSelect = 3;
           }

            //this switch statement is 1-3 and picks what type of room will be shown
            switch (roomSelect) {
                case 1:
                    // picks a random puzzle room (there are 5 puzzles)
                    int puzzleRoomSelect = (int) (Math.random() * 5) + 1;

                    System.out.println("Puzzle: " + puzzleRoomSelect);
                    // switch for all 5 of the puzzles
                    switch (puzzleRoomSelect) {
                        case 1: // puzzle 1: ect...

                            System.out.println("You enter a dimly entered room lit by one torch.\n" +
                                               "The light's grasp is enough to illuminate another torch on the " +
                                               "left side of the wall though it’s unlit");

                            System.out.println("1. Light the other torch");
                            System.out.println("2. Extinguish the torch");
                            System.out.println("3. Evade the room");

                            int puzzleMenu = s.nextInt();

                            if (puzzleMenu == 1) {
                                System.out.println("You pick up the torch and light the other torch with it.\n" +
                                                   "Then you bring back the torch to its original position.\n" +
                                                   "With both torches illuminated in view you notice that the torch you just lit has a different holder");

                                System.out.println("1. Investigate the torch");
                                System.out.println("2. Leave");

                                int puzzleMenu1 = s.nextInt();

                                if(puzzleMenu1 == 1){
                                    System.out.println("You go over to the torch and look around it, noticing thin slits around the holder." +
                                                     "\nYou try to grab the torch to see what happens." +
                                                     "\nIt doesn’t come out but it starts to pull down." +
                                                     "\nYou pull down and then the wall starts to go up a few feet." +
                                                     "\nRevealing a jeweled sword.");

                                    System.out.println("1. Take the sword");
                                    System.out.println("2. Leave the sword and go down the stairs");

                                    int puzzleMenu2 = s.nextInt();
                                    if (puzzleMenu2 == 1){
                                        System.out.println("You pick up the sword and replace your current one.");
                                        playerCharacter.addWeaponDamage(2);
                                        System.out.println("You gained +2 to weapon damage");
                                    }else {
                                        System.out.println("You head down the stairs");
                                    }
                                }else {System.out.println("You head down the stairs");}

                            } if (puzzleMenu == 2 ) {
                                System.out.println("You take the torch then throw it on the ground.\n" +
                                                   "You put your foot down on it and all too suddenly start stomping as maniacal cackles begin to bellow throughout the room.\n" +
                                                   "With the torch gone and no light in sight you start to make your way to where you remember the staircase.\n" +
                                                   "You feel out the emptiness and then begin your first step down into the darkness.\n" +
                                                   "There is no stomping this time instead your foot hits the edge of the stair and off balance you fall and slide down to the bottom taking damage.");
                            } else {
                                System.out.println("You take your leave and head down the stairs.");

                        }
                            break;

                        case 2: // Puzzle 2: Frozen Apple Puzzle

                            System.out.println("As you get closer to the room, you feel colder and colder.");
                            System.out.println("You reach the room and are shivering at this point.");
                            System.out.println("At the center is a frozen block with a blue apple inside.");
                            System.out.println("Underneath the ice is a trap door.");
                            System.out.println("At the corners of the room are dragon statues—");
                            System.out.println("three are facing each other while one is facing the center.");
                            System.out.println("Each has a torch inside its mouth.");

                            System.out.println("\n1. Leave the room");
                            System.out.println("2. Investigate the statues");

                            int puzzle2Menu = s.nextInt();

                            if (puzzle2Menu == 1) {
                                System.out.println("You look around seeing no exits but the trapdoor.");
                                System.out.println("You go to the back of the wall and then charge at the ice block,");
                                System.out.println("pushing it back and leaving the trapdoor available.");
                                System.out.println("You open the door revealing a ladder which you then climb down.");
                            }
                            else if (puzzle2Menu == 2) {
                                System.out.println("You head over to the turned statue.");
                                System.out.println("You notice the smoothness of the statue and start running your fingers over it.");
                                System.out.println("You feel a little give as a piece of scale presses down slightly.");

                                System.out.println("\n1. Press the button");
                                System.out.println("2. Investigate the other statues");

                                int statueMenu = s.nextInt();

                                if (statueMenu == 1) {
                                    System.out.println("As the button pushes down, oil begins to spit out and flames shoot from the statue’s mouth.");
                                    System.out.println("Once fully pushed, the fire continuously starts spitting.");
                                    System.out.println("The ice melts slightly, but the ice block still remains.");

                                    System.out.println("\n1. Push the button again");
                                    System.out.println("2. Leave the apple and head down the ladder");

                                    int flameMenu = s.nextInt();

                                    if (flameMenu == 1) {
                                        System.out.println("You push the button again and the ice remains.");
                                        System.out.println("You push it again and finally the ice melts, revealing a blue apple on the ground.");
                                        System.out.println("You try to pick up the apple but it's ice cold and too hard to take a bite.");
                                        System.out.println("You run it to the statue and place it in the mouth.");
                                        System.out.println("You push the button again and flames erupt.");
                                        System.out.println("The apple does not survive the encounter.");
                                        System.out.println("You resignedly walk toward the trapdoor and open it, heading down the ladder—one solemn step at a time.");
                                    } else {
                                        System.out.println("You kick the apple aside, open the trapdoor, and head down the ladder.");
                                    }

                                }
                                else if (statueMenu == 2) {
                                    System.out.println("You head over to another statue and, sure enough, the scale can be pushed down.");
                                    System.out.println("You go to the others and they follow suit.");
                                    System.out.println("Under each statue, you notice a circular cut of stone.");

                                    System.out.println("\n1. Turn the statues");

                                    int rotateMenu = s.nextInt();

                                    if (rotateMenu == 1) {
                                        System.out.println("You rotate each statue to face the ice block.");
                                        System.out.println("You then start at one statue, pressing its button, and repeat for each.");
                                        System.out.println("The flames converge on the ice block—the fiery orange turns green.");
                                        System.out.println("The fires die out, and the apple now lies on the floor, but it is red.");

                                        System.out.println("\n1. Eat the apple");
                                        System.out.println("2. Kick the apple out of the way and open the trapdoor");

                                        int appleMenu = s.nextInt();

                                        if (appleMenu == 1) {
                                            System.out.println("You pick up the apple and eat it.");
                                            System.out.println("It makes you feel revitalized.");
                                            double tempLife =  playerCharacter.getLife() + 10;
                                            playerCharacter.setLife(tempLife);
                                            System.out.println("You gained +10 health.");
                                        } else {
                                            System.out.println("You kick the apple aside, open the trapdoor, and head down the ladder.");
                                        }
                                    }
                                }
                            }

                            break;

                        case 3: // Puzzle 3: Glowing Orb and Engraved Stones

                            System.out.println("You enter a new room. Moisture sets upon your skin and a dampness fills the air.");
                            System.out.println("Above you, an orb is attached to the ceiling, letting out a blue glow throughout the room.");
                            System.out.println("A wooden podium stands in the center with an open slot and four circular stones, each engraved:");
                            System.out.println("A bird, a fish, a wolf, and a goblin. A door sits on the wall past it all.");

                            System.out.println("\n1. Leave the room");
                            System.out.println("2. Throw your weapon at the glowing orb");
                            System.out.println("3. Go over to mess with the podium");

                            int puzzle3Menu = s.nextInt();

                            if (puzzle3Menu == 1) {
                                System.out.println("You walk over to the door, open it, and leave.");
                            }
                            else if (puzzle3Menu == 2) {
                                System.out.println("You chuck your weapon at the orb.");
                                System.out.println("It shatters and a shard falls on you, injuring you.");
                                System.out.println("In pain, you quickly take your leave.");
                                double tempLife = playerCharacter.getLife();

                                playerCharacter.setLife(tempLife+5); // adjust damage value as needed
                            }
                            else if (puzzle3Menu == 3) {
                                System.out.println("You approach the podium and inspect the stones.");

                                System.out.println("\n1. Put in the bird stone");
                                System.out.println("2. Put in the fish stone");
                                System.out.println("3. Put in the wolf stone");
                                System.out.println("4. Put in the goblin stone");

                                int stoneChoice = s.nextInt();

                                switch (stoneChoice) {
                                    case 1:
                                        System.out.println("Feathers rain down upon you as the podium retreats into the ground.");
                                        System.out.println("You are upset and decide to leave.");
                                        break;
                                    case 2:
                                        System.out.println("The glowing orb above opens up and a fish falls onto you.");
                                        System.out.println("It seems to disappear into your flesh.");
                                        System.out.println("You feel stronger. (+1 Strength)");
                                        double tempStrength =  playerCharacter.getStrength() + 1;
                                        playerCharacter.setStrength(tempStrength);
                                        System.out.println("You walk to the door and try to rip it off the seams.");
                                        System.out.println("It fails, so you leave—embarrassed, but stronger.");
                                        break;
                                    case 3:
                                        System.out.println("You hear a howl that fills you with confidence...");
                                        System.out.println("But then it continues, growing painful to your ears.");
                                        System.out.println("You quickly take your leave.");
                                        break;
                                    case 4:
                                        System.out.println("Nothing happens.");
                                        System.out.println("Immense disappointment washes over you.");
                                        System.out.println("You leave the room as fast as humanly possible.");
                                        break;
                                }
                            }

                            break;

                        case 4: // Puzzle 4: Phoenix Flame and Royal Rug

                            System.out.println("You enter a room. Your feet shift on a beautiful red rug below you.");
                            System.out.println("It almost makes you slip, but you regain your composure.");
                            System.out.println("The rug is absolutely stunning—fit for royalty.");
                            System.out.println("Ahead is a phoenix statue with a raging flame below it. To the right is a door.");

                            System.out.println("\n1. Leave the room");
                            System.out.println("2. Pick up the rug and then leave");
                            System.out.println("3. Burn the rug");

                            int puzzle4Menu = s.nextInt();

                            if (puzzle4Menu == 1) {
                                System.out.println("You seek to escape the heat of the flame and walk to the exit.");
                            }
                            else if (puzzle4Menu == 2) {
                                System.out.println("You pick up the rug and look at the raging flame with abject horror.");
                                System.out.println("The thought of burning this rug fills you with disdain.");
                                System.out.println("You wrap it around yourself securely and take your leave.");
                            }
                            else if (puzzle4Menu == 3) {
                                System.out.println("Burn the rug, burn the rug, burn the rug.\nThese thoughts cloud your judgment.\nA smile settles upon your face and takes this rug and without hesitation chuck it into the fire.\nA mighty squawk is heard and it fills you with strength.\nYou gallantly exit the mighty warmth you were a part of. ");
                                System.out.println("These thoughts cloud your judgment.");
                                System.out.println("A smile settles upon your face as you chuck the rug into the fire.");
                                System.out.println("A mighty squawk is heard and it fills you with strength.");
                                System.out.println("You gallantly exit, embraced by the warmth you became part of.");
                                double tempStrength =  playerCharacter.getStrength() + 1;
                                playerCharacter.setStrength(tempStrength); // Optional buff
                            }

                            break;

                        case 5: // Puzzle 5: Mirror of Reflection

                            System.out.println("You enter a room and in front of you lies a massive mirror.");
                            System.out.println("The reflection shows the room—but the lighting is coming from the mirror.");
                            System.out.println("There are torches in the reflection, but not in the real room.");
                            System.out.println("Behind the mirror, you find a door. You return to face your reflection.");

                            System.out.println("\n1. Insult your reflection");
                            System.out.println("2. Leave the room");
                            System.out.println("3. Compliment yourself");

                            int puzzle5Menu = s.nextInt();

                            if (puzzle5Menu == 1) {
                                System.out.println("You berate yourself—calling yourself a filthy, impoverished fool.");
                                System.out.println("The reflection betrays you and begins to twist into something darker.");
                                System.out.println("Its face grows grimmer than your own.");
                                System.out.println("Your heart grows still and heavy.");
                                System.out.println("You quickly look away and exit the room.");
                                double tempLife = playerCharacter.getLife();

                                playerCharacter.setLife(tempLife-5); // Health decrease
                            }
                            else if (puzzle5Menu == 2) {
                                System.out.println("You decide not to engage in vanity any further.");
                                System.out.println("You leave with an accomplished look on your face.");
                            }
                            else if (puzzle5Menu == 3) {
                                System.out.println("“Hello gorgeous,” “handsome,” “good looking”—you shower yourself with praise.");
                                System.out.println("You can't help but smile at the warmth rising in your chest.");
                                System.out.println("Oddly, the reflection grins harder than you.");
                                System.out.println("Even so, you leave the room glowing with self-love.");
                                double tempLife = playerCharacter.getLife();
                                playerCharacter.setLife(tempLife+5); // Health increase
                            }

                            break;


                    }
                    break;

                case 2:
                    int combatRoomSelect = (int) (Math.random() * 7) + 1;

                    System.out.println("Combat: " + combatRoomSelect);

                    switch (combatRoomSelect) {
                        case 1:

                            System.out.println("You enter a room, each corner is lit up with a faint torch.");
                            System.out.println("A framed picture of a Crowned Cat hangs on the right wall.");
                            System.out.println("On the left wall there’s a gutter at the bottom middle of the wall and a door to the right.");
                            System.out.println("There are two pressure plates on the ground.");
                            System.out.println("A rat scurries across the left pressure plate. Its weight barely pressed it down and nothing happened.");

                            System.out.println("\nWhat do you do?");
                            System.out.println("1. Follow the guidance of the rat");
                            System.out.println("2. Stare vacantly");
                            System.out.println("3. Attack");
                            System.out.println("4. Evade");
                            System.out.println("5. Jump and try to land on both plates at the same time");

                            int ratChoice = s.nextInt();

                            switch (ratChoice) {
                                case 1:
                                    System.out.println("You step on the plate. You hear the sound of grinding stones to your right.");
                                    System.out.println("The picture rises up revealing a small dark tunnel only illuminated by the room's light.");
                                    System.out.println("The sound of squeaking grows and a faint pattering of footsteps makes its way towards you.");
                                    System.out.println("The same rat you saw before sits in the corner and you swear it has a smirk on its face.");
                                    System.out.println("Before you can ogle the rat any further, the footsteps grow louder along with the squeaks.");
                                    System.out.println("You look to your right and a swarm of rats is making a beeline to the room.");

                                    Combat c2 = new Combat(); // creates combat loop
                                    c2.CombatLoop(5); // you'll assign the enemy here

                                    if (!running) {
                                        System.out.println("The rats were too much... You fall amidst fur and teeth.");
                                        return;
                                    }

                                    System.out.println("With the swarm dispersed, you make your way toward the door and exit.");
                                    break;

                                case 2:
                                    System.out.println("You stare emptily toward the tunnel as rats begin to plop down onto the floor.");
                                    System.out.println("As the room fills up, you hear the sound of the pressure plate on your right begin to move.");
                                    System.out.println("Part of the ceiling in front of the two plates opens up and a goblin falls down—injuring a few rats.");
                                    System.out.println("The rats begin to climb up the goblin, gnawing and biting. It shrieks and flails, throwing them off.");
                                    System.out.println("The rats scurry into the gutter. Now it’s just you and a battered, teary-eyed goblin.");

                                    Combat c3 = new Combat(); // combat with weakened goblin
                                    c3.CombatLoop(6); // again, you handle the enemy logic

                                    if (!running) {
                                        System.out.println("You fall to a goblin already half-defeated. A tragic end.");
                                        return;
                                    }

                                    System.out.println("You dispatch the pitiful goblin. The door creaks open, and you walk through.");
                                    break;

                                case 3:
                                    System.out.println("You strike with haste.");

                                    Combat c4 = new Combat();
                                    c4.CombatLoop(7);

                                    if (!running) {
                                        System.out.println("You wonder how you lost to a weakened goblin. You draw your final breath.");
                                        return;
                                    }

                                    System.out.println("You quickly dispatch the rat-strewn goblin and take your leave through the door.");
                                    break;

                                case 4:
                                    System.out.println("You decide you are better than the rats.");
                                    System.out.println("Instead of hurting the already devastated goblin, you exit through the door with pride.");
                                    break;

                                case 5:
                                    System.out.println("You jump and try to hit both plates at once.");
                                    System.out.println("Midair, you realize the plates are farther apart than you thought.");
                                    System.out.println("You land in an awkward split. Ouch. (-1 HP)");
                                    playerCharacter.setLife(playerCharacter.getLife()-1);
                                    System.out.println("Nothing happens. You limp toward the door and leave.");
                                    break;

                                default:
                                    System.out.println("You stand around awkwardly as chaos unfolds.");
                                    break;
                            }

                            break;
                        case 2:
                            System.out.println("You enter a room. The walls have a mossy overgrowth.\nA nice wooden door leads elsewhere.\nInsects are roaming about and a large torch stands above it illuminating the entire room.\nAcross from the door however lies a titan.\nThe moss covers it and it seems to have been immoble for quite some time.");
                            // (Insert full room description and flavor text as needed)

                            Combat titan1 = new Combat();
                            titan1.CombatLoop(4); // Titan enemy

                            if (!running) {
                                System.out.println("As the titan swings down, breaking your sword in half and pummeling you into the ground.\nYour blood flows in between the cracks of the flow and contrasts with the green moss.");
                                return;
                            } else {
                                System.out.println("The titan crumbles with your last strike.\nIts structural integrity is weakened by its inactivity.\nYou walk away accomplished.");
                            }

                            break;

                        case 3:
                            System.out.println("When you enter a room it is expansive.\nRed curtains drape from the ceiling and a throne sits upon an elevated throne.\nA skeleton resides in the throne.\nBy the side of the throne a suit of armor rests kneeling.\nBehind the throne a set of stairs continues upward.\nThe suit of armor starts to come to life and raises up with sword in hand.");

                            Combat knight = new Combat();
                            knight.CombatLoop(2); // Knight enemy

                            if (!running) {
                                System.out.println("You fall to the ground impaled. In your dying light you see the knight return to kneel.");
                                return;
                            } else {
                                System.out.println("You knock the knight’s helmet off. It falls to the ground as you ascend the staircase.");
                            }

                            break;

                        case 4:
                            System.out.println("You step into what once may have been a dining hall.\nA long, rotting table stretches across the room, filled with moldy dishes and broken goblets.\nA chandelier swings gently above, though there’s no wind.\nOn further inspection a goblin is holding onto the chandelier.");

                            Combat goblin1 = new Combat();
                            goblin1.CombatLoop(1); // Goblin enemy

                            if (!running) {
                                System.out.println("The goblin is alive. You are dead. However it seems displeased.\nIt grabs a rotted apple and tries to stuff into your soon to be lifeless mouth.\nA tear forms on its eye as you draw your final breath.");
                                return;
                            } else {
                                System.out.println("The goblin joins the rotted food as its entrails align with the platter.\nNothing changes in this room; it all looks as inhospitable as it did with life.");
                            }

                            break;

                        case 5:
                            System.out.println("You enter a room. A surprising warmth clings to your skin and makes you feel embraced.");
                            System.out.println("You look around and observe the -A boulder is heading your way-");

                            while (true) {
                                System.out.println("\nWhat do you do?");
                                System.out.println("1. Dodge");
                                System.out.println("2. Address the Ogre");
                                System.out.println("3. Keep staring at the chandelier");
                                System.out.println("4. Evade");

                                int choice = s.nextInt();
                                s.nextLine(); // Consume newline

                                if (choice == 1) { // Dodge
                                    System.out.println("You jump to the side avoiding the boulder.");
                                    System.out.println("At the end of the room an ogre is snarling at you, beating his chest with one arm, and his other arm has just such large muscles flexed which happen to be holding another boulder.");
                                    System.out.println("Oh but above you see just the most dazzling chandelier hanging above you.");

                                    Combat ogre = new Combat();
                                    ogre.CombatLoop(3);

                                    if (!running) {
                                        System.out.println("You fall to the ground. Your head facing the chandelier now broken and barely lit lying on the floor. A dying smile is lit by a dying light.");
                                        return;
                                    } else {
                                        System.out.println("You pierce the ogre’s skull mid-swing. The moon glows behind the chandelier as you rest briefly.");
                                    }
                                    break;

                                } else if (choice == 2) { // Address the Ogre
                                    System.out.println("“Stop it,” you scream.");
                                    System.out.println("The ogre is mute and its response is to throw a boulder at you. You jump to the side avoiding it.");
                                    System.out.println("“Please listen,” you shout. A boulder is thrown again—this time the boulder hits the chandelier.");
                                    System.out.println("Devastation unfolds, and an anger like you’ve never known before washes over you.");
                                    System.out.println("Before you know it, you are face to face with the Ogre.");

                                    Combat ogre = new Combat();
                                    ogre.CombatLoop(3);

                                    if (!running) {
                                        System.out.println("You fall to the ground. Your head facing the chandelier now broken and barely lit lying on the floor. A dying smile is lit by a dying light.");
                                        return;
                                    } else {
                                        System.out.println("The anger of you still just won’t go away.");
                                        System.out.println("A lifeless corpse on the ground. An hour passes. A lifeless corpse now hangs in place of the chandelier.");
                                    }
                                    break;

                                } else if (choice == 3) { // Stare at chandelier
                                    System.out.println("Your eyes transfixed, you wonder how this chandelier still stands.");
                                    System.out.println("With a boulder-tossing ogre denting the walls and floors, how does it stay lit?");
                                    System.out.println("You’ve just been accepting things as is—but really, how does this dungeon operate?");
                                    System.out.println("Most importantly, why are you so drawn to the light?");
                                    System.out.println("These questions don’t last long as a boulder soon hits you.");

                                    double tempLife = playerCharacter.getLife();
                                    playerCharacter.setLife(tempLife+5);

                                    System.out.println("You fall to the ground and have taken damage.");
                                    System.out.println("You remain lying just looking up at the glow.");
                                    System.out.println("The ogre comes over to view your corpse...");
                                    System.out.println("His fist raises into the air to slam down.");
                                    System.out.println("The sun is blocked by the moon.");
                                    System.out.println("You raise your sword—his fist jams into it.");
                                    System.out.println("The ogre writhes in pain, swinging you around. You jump forward...");
                                    System.out.println("The sword pierces its skull, killing it. You fall with the ogre—his body cushions your fall.");
                                    System.out.println("You now lay on the moon with a full view of the sun. After a brief repose, you get up and head out of the room.");
                                    break;

                                } else if (choice == 4) { // Evade
                                    System.out.println("You start running to the right intuitively and there the door stands.");
                                    System.out.println("You open it and hear a large crash behind you. A piece of wood goes flying past.");
                                    System.out.println("You look back and see a destroyed door and a boulder now resides in its place.");
                                    System.out.println("The space above the boulder allows the nice light of the chandelier to come through.");
                                    break;

                                } else {
                                    System.out.println("Invalid choice. Try again.");
                                }
                            }

                            break;


                        case 6:
                            System.out.println("You enter a room. The walls, floor, and ceiling are all a dark rich wood. There's a door directly across from you.");
                            System.out.println("A single beam of light shines from above onto a small wooden table in the center of the room.");
                            System.out.println("On that table sits a miniature house with two small doors... it looks oddly familiar.");

                            while (true) {
                                System.out.println("\nWhat do you do?");
                                System.out.println("1. Evade - Run to the exit without engaging.");
                                System.out.println("2. Start banging the walls, looking for an enemy.");
                                System.out.println("3. Eat the small room.");
                                System.out.println("4. Leave quietly to reflect.");

                                int choice6 = s.nextInt();
                                s.nextLine(); // Clear newline

                                if (choice6 == 1) {
                                    System.out.println("You want nothing to do with this. You sprint to the door without looking back.");
                                    break;

                                } else if (choice6 == 2) {
                                    System.out.println("You begin banging on the walls, yelling 'Come out, come out!'");
                                    System.out.println("Suddenly, a square section of the wall flips and smacks you. You crouch and see a goblin!");
                                    System.out.println("It sprints out, checks the table protectively, then stares at you, poised.");

                                    while (true) {
                                        System.out.println("\nWhat do you do?");
                                        System.out.println("1. Attack the goblin");
                                        System.out.println("2. Leave and reflect");

                                        int subChoice = s.nextInt();
                                        s.nextLine();

                                        if (subChoice == 1) {
                                            System.out.println("You smash the miniature house and table—infuriating the goblin!");
                                            Combat goblin2 = new Combat();
                                            goblin2.CombatLoop(1);

                                            if (!running) {
                                                System.out.println("The goblin leaps and bites your neck. Blood pools on the wooden floor...");
                                                return;
                                            } else {
                                                System.out.println("You feel satisfied that your whims were answered. You leave the room.");
                                            }
                                            break;

                                        } else if (subChoice == 2) {
                                            System.out.println("A strange guilt washes over you. You decide to leave and reflect.");
                                            break;
                                        } else {
                                            System.out.println("Invalid option. Try again.");
                                        }
                                    }
                                    break;

                                } else if (choice6 == 3) {
                                    System.out.println("You stare at the small replica. Something unhinges in your brain.");
                                    System.out.println("You scoop up the small room and eat it. It's oddly sweet with a woody aroma.");
                                    System.out.println("You hear banging from within the walls, but feel full and calm. You walk away.");
                                    break;

                                } else if (choice6 == 4) {
                                    System.out.println("You feel guilt creep in. Better to leave than mess with this madness. You exit the room.");
                                    break;

                                } else {
                                    System.out.println("Invalid input. Choose again.");
                                }
                            }

                            break;


                        case 7:
                            System.out.println("You push open a resistant door. A musty scent fills your nose as grey solemn bricks enclose the room.");
                            System.out.println("A titan waits ahead in silence, its frame unmoving but ready.");

                            while (true) {
                                System.out.println("\nWhat do you do?");
                                System.out.println("1. Evade and flee immediately.");
                                System.out.println("2. Taunt the titan and begin a proper fight.");
                                System.out.println("3. Try to rush past it recklessly.");

                                int choice7 = s.nextInt();
                                s.nextLine(); // Clear newline

                                if (choice7 == 1) {
                                    System.out.println("You run as fast as you can. The titan hurls a blow, but you’re simply too fast.");
                                    System.out.println("You make it behind it and escape into a dark tunnel.");
                                    break;

                                } else if (choice7 == 2) {
                                    System.out.println("You charge up and then retreat, goading it. The titan begins marching your way...");

                                    while (true) {
                                        System.out.println("\nDo you:");
                                        System.out.println("1. Stand your ground and fight");
                                        System.out.println("2. Attempt to flee again");

                                        int subChoice7 = s.nextInt();
                                        s.nextLine();

                                        if (subChoice7 == 1) {
                                            System.out.println("You brace yourself and fight the titan head-on.");
                                            Combat titan2 = new Combat();
                                            titan2.CombatLoop(4);

                                            if (!running) {
                                                System.out.println("Your legs are crushed. You regret not running—but you’re glad you can’t outrun death.");
                                                return;
                                            } else {
                                                System.out.println("You manage to defeat the titan. Valor washes over you. You feel strong. You move on.");
                                            }
                                            break;

                                        } else if (subChoice7 == 2) {
                                            System.out.println("You dodge and sprint. Once again, you're fast enough to make it to the tunnel.");
                                            break;

                                        } else {
                                            System.out.println("Invalid choice. Try again.");
                                        }
                                    }
                                    break;

                                } else if (choice7 == 3) {
                                    System.out.println("You recklessly rush the titan. It moves fast—faster than you expected!");
                                    Combat titan2 = new Combat();
                                    titan2.CombatLoop(4);

                                    if (!running) {
                                        System.out.println("Your legs are crushed. You regret not running—but you’re glad you can’t outrun death.");
                                        return;
                                    } else {
                                        System.out.println("You somehow manage to defeat the titan. Valor surges through your veins. You continue onward.");
                                    }
                                    break;

                                } else {
                                    System.out.println("Invalid input. Choose again.");
                                }
                            }

                            break;


                    }


                    break;

                case 3:
                    System.out.println("TRADER");
                    Trader.tradeInitiate();
                    break;
            }
        }
    }

       /* boolean running = true;
        Room currentRoom;
        int counter = 1;  //counter will keep track of what room we are in
        Random rand = new Random();
        Combat c1 = new Combat();

        while (running){

            System.out.println("Welcome to the Text-Based RPG\n------------------------------\n\nBegin game: yes/no");
            String answer = s.nextLine();

            if (answer.equalsIgnoreCase("no")){
                System.out.println("YOU HAVE MISSED OUT ON A GREAT ADVENTURE");
                running =  false;
                return;
            }else if (answer.equalsIgnoreCase("yes")){
                System.out.println("Welcome young traveler you have stumbled upon a mighty castle and enter through its large gate into a well lit room.\n" +
                        "In this room there is only a door ahead and a large sword laying on the ground.......");
            }
            currentRoom = r1.nextRoom;

            counter++; //Room two
            System.out.println(currentRoom.Description); // Will have to go into deeper detail when room info is ready

            currentRoom = r2.nextRoom;
            counter++; //room 3 First combat room

            System.out.println("You enter into a dark room with a cloaked figure at the end. In a Sudden movement " +
                    " the rooms torches erupt revealing foe that has come across your path");
            System.out.println(currentRoom.Description);
            System.out.println(counter);

            int enemyChosen = r3.enemyChosen;
            c1.CombatLoop(enemyChosen);
            running = c1.afterCombatChecks();

            if (!running){
                //Enter game over (death) text here
                return;
            }


            System.out.println("There are two doors on each side of the room. Which way do you go left or right");
            answer = s.nextLine();
            if (answer.equalsIgnoreCase("Left")){
                currentRoom =  r3.nextLeft;
                counter++;
            }else{
                currentRoom = r3.nextRight;
                counter+=2;

            }
            System.out.println(currentRoom.Description +" " +counter);



        }*/






        // opening desc.
        //





        //map looks like this [entrance => hallway => branchRoom => roomL OR roomR => entrance]


        // the map will be a series of rooms that we draw out before hand is always the same
        // setting is low fantasy: think knights, dragons, magic, etc...

        // interface will be menu based, with options to move, attack, etc...
        // character stats start at 1 and can be increased by leveling up
        // weapons can be found and will act as damage upgrades
        // armor can be found and will act as damage mitigation
        // gold can be found and can be used to buy items

        // we plan to make combat a do while loop that terminates when either the player or the enemy reaches 0 health.




    }
}