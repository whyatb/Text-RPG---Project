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

//nodeType controls whether room will be noncombat or combat, with number thresholds indicating enemy type I.E 0-1 is non-combat, anything higher determines type of enemy


// nextRoom is the default if there is only one way to go.
// if there are two ways to go

//Navigation menu will read the values of nextRight and nextLeft and if either one is null, then menu will simply have a next-room option, otherwise present a choice

// node type and description is constructed here

class Node{

    int nodeType;
    String Description;

    Node nextLeft;
    Node nextRight;
    Node nextRoom;

    public Node(int nodeType, String Description){
        this.nodeType = nodeType;
        this.Description = Description;
    }

    public void connectLeft(Node nextLeftNode){
        this.nextLeft = nextLeftNode;
    }

    public void connectRight(Node nextRightNode){
        this.nextRight = nextRightNode;
    }

    public void connectRoom(Node nextNode){
        this.nextRoom = nextNode;
    }
}


public class Main {

    //placeholer enemy health

    int health;
    public void getEnemy(int enemyHealth){
        this.health = enemyHealth;
    }


    public static void main(String[] args) {

        System.out.println("Welcome to the Text-Based RPG\n------------------------------\n\nBegin game: yes/no");

        // node type and description is stored here

        Node r1 = new Node(0, "room description//Outside dungeon entrance");
        Node r2 = new Node(0, "room description//Inside dungeon entrance");
        Node r3 = new Node(1, "room description First Combat room");
        Node r4 = new Node(2, "room description//First puzzle room");
        Node r5 = new Node(0, "room description");
        Node r6 = new Node(0, "room description");
        Node r7 = new Node(0, "room description");
        Node r8 = new Node(0, "room description");
        Node r9 = new Node(0, "room description");
        Node r10 = new Node(0, "room description");
        Node r11 = new Node(0, "room description");
        Node r12 = new Node(0, "room description");
        Node r13 = new Node(0, "room description");
        Node r14 = new Node(0, "room description");
        Node r15 = new Node(0, "room description");

        boolean playing  = true;
        String enter = "";
        Combat c1 = new Combat();

        while(playing){
            System.out.println(r1.Description);
            r1.connectRoom(r2);
            System.out.println(r2.Description);
            r2.connectRoom(r3);
            System.out.println(r3.Description);
            if(r3.nodeType == 1){
                c1.CombatLoop();
                System.out.println("hi");
            }
            playing = false;
        }



        //r1.connectRoom(r2);
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




        // opening desc.
        //





        //map looks like this [entrance => hallway => branchRoom => roomL OR roomR => entrance]


        // the map will be a series of nodes that we draw out before hand is always the same
        // setting is low fantasy: think knights, dragons, magic, etc...

        // interface will be menu based, with options to move, attack, etc...
        // character stats start at 1 and can be increased by leveling up
        // weapons can be found and will act as damage upgrades
        // armor can be found and will act as damage mitigation
        // gold can be found and can be used to buy items

        // we plan to make combat a do while loop that terminates when either the player or the enemy reaches 0 health.




    }
}