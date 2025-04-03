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
class Room {

    int roomType;
    String Description;

    Room nextLeft;
    Room nextRight;
    Room nextRoom;

    public Room(int roomType, String Description){
        this.roomType = roomType;
        this.Description = Description;
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

    //placeholer enemy health

    int health;
    public void getEnemy(int enemyHealth){
        this.health = enemyHealth;
    }


    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);

        // room type and description is stored here

        Room r1 = new Room(0, "Outside");
        Room r2 = new Room(0, "Entrance");
        Room r3 = new Room(1, "Combat 1");
        Room r4 = new Room(2, "Combat 2");
        Room r5 = new Room(0, "Puzzle 1");
        Room r6 = new Room(0, "Combat 3");
        Room r7 = new Room(0, "");
        Room r8 = new Room(0, "room description");
        Room r9 = new Room(0, "room description");
        Room r10 = new Room(0, "room description");
        Room r11 = new Room(0, "room description");
        Room r12 = new Room(0, "room description");
        Room r13 = new Room(0, "room description");
        Room r14 = new Room(0, "room description");
        Room r15 = new Room(0, "room description");

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
        r14.connectRoom(r15);



        boolean running = true;
        Room currentRoom;
        int counter = 1;  //counter will keep track of what room we are in
        Combat c1 = new Combat();
        while (running){
            System.out.println("Welcome to the Text-Based RPG\n------------------------------\n\nBegin game: yes/no");
            String answer = s.nextLine();

            if (answer.equalsIgnoreCase("no")){
                System.out.println("YOU HAVE MISSED OUT ON A GREAT ADVENTURE");
                running =  false;
                return;
            }else{
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
            c1.CombatLoop();
            boolean checkForDeath= Combat.gameOverCheck();

            if(checkForDeath){
                //Enter bad ending text here

                running = false;
                return;
            }

            System.out.println("You survived the attack. Your foe has Dropped .......");
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



        }






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