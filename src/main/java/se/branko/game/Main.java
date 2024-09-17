package se.branko.game;
import java.util.Scanner;

public class Main {
    int playerHp;
    String playerWeapon;
    Scanner scan;
    Scanner inputScan = new Scanner(System.in);
    String playerName;
    int choice;
    int monsterHp;
    int silverRing;
    int guardHp;
    boolean hasMailChestpiece = false;


    public static void main(String[] args) {

        Main game;
        game = new Main();
        game.playerSetup();
        game.townGate();



    }
    public void playerSetup(){

        guardHp = 90;
        playerHp = 50;
        monsterHp = 70;
        playerWeapon = "Rusty Dagger";

        System.out.println("Your hp is: " + playerHp);
        System.out.println("Your weapon is: " + playerWeapon);
//

        scan = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        playerName = scan.nextLine();
        System.out.println(" ");
        System.out.println("********WELCOME********");
        System.out.println("Hello "+playerName+ ", Lets start your adventure!");

    }
    public void townGate(){
        System.out.println(" ");
        System.out.println("------------------------------------");
        System.out.println("\n");
        System.out.println("You are at the gate of the town.\n");
        System.out.println("Press ENTER to continue");
        inputScan.nextLine();
        System.out.println("A guard is standing in front of you.\n\n");
        System.out.println("What do you want to do?");
        System.out.println("1. Talk to the guard");
        System.out.println("2. Attack the guard");
        System.out.println("3. Leave");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();

        if(choice == 1){
            if(silverRing==1){
                ending();
            }else {
                System.out.println("Guard: So... you are " + playerName + "? I dont know you, " + playerName + ". Step aside!");
                inputScan.nextLine();
                townGate();
            }
        }
        else if(choice == 2){
            if(playerWeapon.equals("The sword of a thousand truths")){
                fight2();
            } else {
                playerHp = playerHp - 10;
                System.out.println("The guard blocks your attack with ease and pushes you down to the ground!" +
                        "\n(You received 10 damage)");
                System.out.println("Your HP is: " + playerHp);
                townGate();
            }
        }
        else if(choice == 3){
            crossRoads();
        }
        else{
            townGate();
        }

    }
    public void crossRoads(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You are at a crossroad. If you go south you will go back to the town.\n\n");
        System.out.println("1: North");
        System.out.println("2: East");
        System.out.println("3: South");
        System.out.println("4: West");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            north();
        }
        else if(choice == 2){
            east();
        }
        else if(choice == 3){
            townGate();
        }
        else if(choice == 4){
            west();
        }
        else{
            crossRoads();
        }


    }
    public void north(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You have walked north and reached a glowing river.\n");
        inputScan.nextLine();
        System.out.println("You drink from the river and rest at the river side.\n" +
                "You feel rested and restored some health!");
        inputScan.nextLine();
        playerHp = playerHp + 10;
        System.out.println("\nYour health is now: " + playerHp);
        System.out.println("\n\n1: To go back to the crossroads");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            crossRoads();
        }
        else{
            north();

        }
    }
    public void east(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You have walked east and reached a big forest.");
        System.out.println("\n--------------------------------------------------\n ");
        inputScan.nextLine();
        System.out.println("You look down on the ground and see something... Something shiny..");
        inputScan.nextLine();
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("Its a giant glowing sword!");
        inputScan.nextLine();
        System.out.println("You read the fine imprint on the sword and it says:'This is the Sword of a thousand truths'");
        System.out.println("\n--------------------------------------------------\n ");
        inputScan.nextLine();
        System.out.println("You equip the sword");
        playerWeapon = "The sword of a thousand truths";
        System.out.println("Your weapon: " + playerWeapon);
        inputScan.nextLine();
        System.out.println("\n\n1: Go back to the crossroads");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            crossRoads();
        }
        else{
            east();
        }


    }
    public void west(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You have walked west which took you down a long scary path..");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run like a bitch");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            fight();
        }
        else if(choice == 2){
            crossRoads();
        }
        else{
            west();
        }
    }
    public void fight2(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("Your hp is: " + playerHp);
        System.out.println("Guards hp is: " + guardHp);
        System.out.println("\n1: Attack");
        System.out.println("2: Run");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            attack2();
        }
        else if(choice == 2){
            crossRoads();
        }
        else{
            fight2();
        }
    }
    public void fight(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("Your hp is: " + playerHp);
        System.out.println("Goblin hp is: " + monsterHp);
        System.out.println("\n1: Attack");
        System.out.println("2: Run lol");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
        if(choice == 1){
            attack();
        }
        else if(choice == 2){
            crossRoads();
        }
        else{
            fight();
        }
    }
    public void attack2(){

        int playerDamage = 0;


        if(playerWeapon.equals("The sword of a thousand truths")){
            playerDamage = new java.util.Random().nextInt(30);
        }
        System.out.println("You attacked the guard, dealing "+ playerDamage +" damage");
        guardHp = guardHp - playerDamage;
        System.out.println("Guard health is: " + guardHp);

        if(guardHp < 1){
            win2();
        } else if (guardHp > 0) {

            int guardDamage = new java.util.Random().nextInt(20);

            System.out.println("The guards attacks you with his claymore dealing "+ guardDamage +" damage");

            playerHp = playerHp - guardDamage;
            System.out.println("Player hp is: " + playerHp);

            if(playerHp < 1){
                dead();
            }
            else if (playerHp > 0) {
                fight2();
            }
        }


    }
    public void attack(){


        int playerDamage = 0;



        if(playerWeapon.equals("Rusty Dagger")){
            playerDamage = new java.util.Random().nextInt(10);
        } else if (playerWeapon.equals("The sword of a thousand truths")) {
            playerDamage = new java.util.Random().nextInt(30);
        }

        System.out.println("You attacked the goblin, dealing " + playerDamage +" damage");

        monsterHp = monsterHp - playerDamage;

        System.out.println("Goblin HP is: " + monsterHp);

        if(monsterHp < 1){
            win();
        }
        else if(monsterHp > 0){
            int monsterDamage = 0;
            monsterDamage = new java.util.Random().nextInt(10);

            System.out.println("The goblin attacked you " + monsterDamage +" damage");

            playerHp = playerHp - monsterDamage;
            System.out.println("Player Hp is: " + playerHp);

            if (playerHp < 1){
                dead();
            } else if (playerHp > 0) {
                fight();
            }

        }
    }
    public void dead(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You are dead!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n--------------------------------------------------\n ");
    }
    public void win2(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You successfully killed the asshole guard!");
        System.out.println("The guard dropped a mail chestpiece!");
        System.out.println("You obtained and equipped the mail chestpiece\n\n");
        System.out.println("The chestpiece gives 50+ health points!");
        System.out.println("\n--------------------------------------------------\n ");

        hasMailChestpiece = true;
        playerHp += 50;
        System.out.println("\n\nPlayer HP is: " + playerHp);
        System.out.println("------------------------------");
        System.out.println("You can now enter the town...");
        System.out.println("\n1: To enter town");
        System.out.println("\n----------------------------");

        choice = scan.nextInt();
        if(choice == 1){
            town();
        }
        else{
            win2();
        }



    }
    public void town(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("***********EJ KLART********************");
        System.out.println("You walk in to town, and continue walking until you reach the cathedral.");
        System.out.println("In front of the cathedral door stands a big guard.\n\n");
        System.out.println("What do you want to do?");
        System.out.println("1:Talk to guard");
        System.out.println("2:Walk over to the water fountain next to the cathedral");
        System.out.println("3:Attack the guard");
        System.out.println("\n--------------------------------------------------\n ");

        choice = scan.nextInt();
       //INTE KLART!
    }
    public void win(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("You killed the goblin!!");
        System.out.println("The goblin dropped a ring");
        System.out.println("You obtained the ring\n\n");
        System.out.println("1: Go back to the crossroads");
        System.out.println("\n--------------------------------------------------\n ");

        silverRing =1;

        choice = scan.nextInt();
        if(choice == 1){
            crossRoads();
        }
        else {
            win();
        }


    }
    public void ending(){
        System.out.println("\n--------------------------------------------------\n ");
        System.out.println("Guard: Oh you killed that goblin!? Thats great!");
        System.out.println("You seem to be a trustworthy guy "+ playerName +"!\n");
        System.out.println("Welcome in to our town!");
        System.out.println("----------THE END------------");
        System.out.println("\n--------------------------------------------------\n ");
    }
    public void fight3(){
        System.out.println("\n------------------------------------------------\n ");

    }
}

