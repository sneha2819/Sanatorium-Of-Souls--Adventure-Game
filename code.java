package code.netjava;
import java.util.Scanner;

import java.util.Stack;
import java.util.ArrayList;

   class Inventory {
       private ArrayList<String> items;

       public Inventory() {
           items = new ArrayList<>();
       }

       public void addItem(String item) {
           items.add(item);
       }

       public void showInventory() {
           System.out.println("Inventory: " + items);
       }

       public void remove(String item) {
        items.remove(item);
       }

       public boolean isEmpty() {
           return items.isEmpty();
       }

   }

class HauntedHospitalGame {

static class BinaryTreeNode {

       String data;

       BinaryTreeNode left, right;

       public BinaryTreeNode(String item) {
           data = item;
           left = right = null;
       }

}

   private BinaryTreeNode rootNode;
   private Inventory inventory;

   public HauntedHospitalGame() {

       // Initialize the binary tree with two rooms.
       rootNode = new BinaryTreeNode("Operation Theatre");
       rootNode.left = new BinaryTreeNode("Patients Room");
       rootNode.right = new BinaryTreeNode("Doctor's Room");
       inventory = new Inventory();
       inventory.addItem("Napkin");
       inventory.addItem("Hammer");
       inventory.addItem("Axe");
       inventory.addItem("Blowtorch");
   }

   public void startGame() {
  final String ANSI_RESET = "\u001B[0m";
  final String ANSI_RED = "\u001B[31m";
  final String ANSI_BLUE = "\u001B[34m";
  final String ANSI_GREEN = "\u001B[32m";
 
  System.out.println("\n\n");
  System.out.println("*********************************WELCOME TO SANATORIUM OF SOULS*********************************");
       Scanner sc = new Scanner(System.in);
       BinaryTreeNode currentNode = rootNode;
       //int score = 0;
       int flag = 0;
     
       if (currentNode != null) {

           System.out.println(ANSI_BLUE + "You wake up in a dark and mysterious room on a bed. You have someone's blood all over your hands;\n"
            + "but you cannot remember anything from before. You feel scared. You must escape." + ANSI_RESET);

           System.out.println("Can you escape the haunted hospital?");
           System.out.println();

           System.out.println("You are in " + currentNode.data);

           System.out.println("Enter 'escape' to try to escape or 'inventory' to check your inventory:");

           String input = sc.nextLine().toLowerCase();


           if (input.equals("escape")) {
          System.out.println();

            System.out.println(ANSI_BLUE + "You look for an exit from the room, but only see the door at the opposite end.\n"
            + "You hear a strange banging noise, and you run towards the door." + ANSI_RESET);

            System.out.println(ANSI_RED + "You open the door, but a bloodthirsty monster lies on the other end,\nit smells you, and you die!"+ ANSI_RESET);

            flag = 1;

            System.out.println("Game Over. Thank you for playing!");


               }
           else if(input.equals("inventory")){
          System.out.println();

                   inventory.showInventory();

                   inventory.remove("Napkin");

                   System.out.println(ANSI_BLUE + "You wipe your hands on the napkin, removing any traces of blood from your hands,\nand head towards the door." );
                   System.out.println();

                   System.out.println("You find a key on the floor and use it to open the doors of the Operation Theatre.\nA message glows: YOU HAVE ESCAPED THE FIRST LEVEL SUCCESSFULLY." + ANSI_RESET);

                   System.out.println("Once outside the room, you hear someone screaming in the other room. What do you do? \n1. Help them \n2. Ignore");// Player escapes first room

                   int choice = sc.nextInt();

                   switch(choice) {

                   case 1:

                    if (currentNode.left!=null)

                    currentNode = currentNode.left;
                    break;
                       
                   case 2:

                    System.out.println(ANSI_RED + "Your ignorance costs you! A zombie finds you because of the screams and kills you. \nBetter luck next time!"+ ANSI_RESET);
                    flag = 1;
                    System.out.println("Game Over. Thank you for playing!");                
                    break;

                   }

               }

           else {
               System.out.println("Invalid input. Try again.");
           }
       }

       
       if(currentNode!=null) {
      System.out.println();
    System.out.println("You enter the second room.");

        System.out.println("You are in " + currentNode.data);
        System.out.println("You try to find the person who is screaming, and see them on the floor behind a curtain. \nWhat do you do? \n1. Use inventory to help them \n2. Ignore");

        int ch1 = sc.nextInt();

        switch(ch1) {

        case 1:
        System.out.println();

        System.out.println(ANSI_RED + "You use all the inventory elements to help the person, but their wounds are too severe. \nThey die, but there is too much blood. Smelling the blood, \nthe zombies find you, and you die." + ANSI_RESET);
        flag = 1;

        System.out.println("Game Over. Thank you for playing!");
        break;

        case 2:
        System.out.println();
        System.out.println(ANSI_BLUE + "You look at the dying person and decide there is nothing you can do to save them. \nSo you ignore their cries, and walk away."+ ANSI_RESET);

        System.out.println("However, the blood is still flowing, and you must hide! \nWhere do you want to hide? \n1. Cupboard \n2. Under Table");

        int ch2 = sc.nextInt();

        switch(ch2) {

        case 1:

        System.out.println(ANSI_BLUE + "You quickly hide inside the cupboard. The zombie arrives almost immediately. \nThankfully, the strong wood of the cupboard masks your scent, and the zombie goes away.");

        System.out.println("As you breathe a sigh of relief, you see a message scribbled on the door \nof the cupboard that says: THE ESCAPE IS IN DR. HYDE'S OFFICE!");
        System.out.println();

        System.out.println("You exit the room quietly and enter the dilapidated lobby of the hospital. \nIn the dim lights, you can just barely make out the silhouette of the dead bodies on the floor.");

        System.out.println("As your eyes adjust to the dark, you see the scary zombie at the other side of the lobby; \nand behind the zombie, the door to Hyde's office." + ANSI_RESET);
        System.out.println();

        System.out.println("To enter the office, you must kill the monster. You can use the various objects in your inventory.");

        inventory.showInventory();

        while(!inventory.isEmpty()) {
        System.out.println("Which weapon would you like to use?");

        String ch3 = sc.next().toLowerCase();

        if(ch3.equals("axe")) {

        inventory.remove("Axe");

        System.out.println(ANSI_RED + "You hit the monster with an axe!\nBut it does not die, it simply regenerates its missing parts" + ANSI_RESET);
        System.out.println();

        inventory.showInventory();
       
        }

        else if(ch3.equals("hammer")) {

        inventory.remove("Hammer");

        System.out.println(ANSI_RED + "You hit the monster with a hammer and it slows him down, but not enough! \nZombies are only defeated by fire!" + ANSI_RESET);
        System.out.println();

        inventory.showInventory();
       
        }

        else if(ch3.equals("blowtorch")) {

        inventory.remove("BlowTorch");

        System.out.println(ANSI_BLUE + "Your blowtorch incinerates the zombie! It is finally dead!" + ANSI_RESET);
        System.out.println();

        System.out.println("Proceed to Doctor Hyde's office!");

        currentNode = rootNode.right;

       
        break;
       
        }

        }
        case 2:
        System.out.println(ANSI_RED + "You hide under the table, but the zombie spots you shivering and kills you!" + ANSI_RESET);
        flag = 1;
        System.out.println("Game over. Thank you for playing!");
        }
       
       }
   }

       
       if(currentNode!=null) {

        System.out.println(ANSI_BLUE + "You enter the office. You see the Doctor lying on the floor, severely hurt. \nHe looks at you and says, \nWELL DONE, YOU HAVE COME TILL HERE! BUT YOU MUST KILL ME IN ORDER TO SAVE YOURSELF AND THE WORLD!");
        System.out.println();

        System.out.println("He further says, YOUR WORK IS NOT YET DONE! YOU MUST GO TO MY LABORATORY ACROSS THE COUNTRY\nAND GET THE ANTIDOTE TO STOP THIS DISEASE! BUT YOU MUST SACRIFICE ME." + ANSI_RESET);
        System.out.println();

        System.out.println("What do you do? \n1. Save the doctor (1) \n2. Let the doctor die (2)");

        int ch4 = sc.nextInt();

        switch(ch4) {

        case 1:

        System.out.println(ANSI_RED + "You try to save the doctor, but it is too late. He is already dying,\nand he wants to tell you something. But smelling his blood, more zombies come in, \nand kill both of you, and the world goes back into chaos." + ANSI_RESET);

        flag = 1;

        System.out.println("Game Over. Thank you for playing!");

        break;

        case 2:

        System.out.println(ANSI_GREEN + "You leave the doctor alone, with a heavy heart, and leave the building alive. \nHis saccrifice was the final piece needed for your escape. \nWith a dedicated mindset, you now embark on your journey to retrieve the antidote." );

        System.out.println("YOU WIN!" + ANSI_RESET);

        flag = 1;

        System.out.println("Game Over. Thank you for playing!");

        }

        }
       
       System.out.println("Would you like to play again? \n1. Restart \n2. Exit");

       int choicemain = sc.nextInt();

       switch(choicemain) {

       case 1:

       startGame();

        break;

       case 2:

        System.exit(0);

       }

       }

   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
       HauntedHospitalGame game = new HauntedHospitalGame();
       game.startGame();
   }
}
