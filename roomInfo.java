public class  Room {

    //Here is the roomInfo attribues or subclasses
    
    protected String name;
    protected String description;

    // This will be the constructor for the room properties
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // This is the method that we can use to display room information (Its abstract so it can be used in the other sub classes)
    
    public abstract void displayInfo();
}

// Here is the subclasses that represent all of the different types of rooms

public class CombatRoom extends Room {
    public CombatRoom(String name, String description) {
        super(name, description); // This is using that constructor from roomInfo ***
    }

@Override
    public void displayInfo() {
        System.out.println("Combat Room: " + name);
        System.out.println(description);
        // We can add more logic here IE: rewards or whatever we want
    }
}

public class PuzzleRoom extends Room {
    public PuzzleRoom(String name, String description) {
        super(name, description);
    }

@Override
    public void displayInfo() {
        System.out.println("Puzzle Room: " + name);
        System.out.println(description);
    }
}

public class EntranceRoom extends Room {
    public EntranceRoom(String name, String description) {
        super(name, description);
    }

    @Override
    public void displayInfo() {
        System.out.println("Entrance Room: " + name);
        System.out.println(description);
    }
}

// Here we have a class that can manage the rooms it will handle all of the storing and intializing of the rooms in the game

import java.util.HashMap;
import java.util.Map;

public class RoomInfo {

    // This is the map for the room numbers
    
    private Map<Integer, Room> rooms;

    public RoomInfo() {
        rooms = new HashMap<>();

        // This is what will load the rooms into the map
        
        initializeRooms();
    }

    // This method is what will actually add all of the ooms to the map ***********
    
    private void initializeRooms() {
        rooms.put(0, new EntranceRoom("Mysterious Gate", "You stand at the beginning of an ancient labyrinth."));
        rooms.put(1, new CombatRoom("Goblin Den", "A group of goblins charge as you enter the room."));
        rooms.put(2, new PuzzleRoom("Hall of Riddles", "You must solve the riddle to proceed."));
        
        // We can add the other 15 rooms here
        
        for (int i = 3; i < 15; i++) {
            rooms.put(i, new CombatRoom("Combat Room " + i, "Filler combat room description."));
        }
    }

    // ********** This is how we will call the class in other classes to display the information *******
    
    public void displayRoomInfo(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.displayInfo();
        } else {
            System.out.println("Room does not exist.");
        }
    }
}
