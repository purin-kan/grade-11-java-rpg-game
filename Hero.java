import java.util.*;

class Hero {

  public static String name = "placeHolderFor_name";
  public static int ans = 0;
  
  public static String role = "... wait that's not number 1, 2 or 3... now what";
  public static String role_pic = "placeholderFor_role_pic";
  public static int health = 10;
  public static int strength = 0;
  public static int resilience = 0;
  public static int speed = 3;
  public static int gold = 10; 
  public static int s = 0;//temp. strength;
  public static int r = 0;//temp. resilience;
  public static int sp = 0;//temp. speed;
  public static int maxhealth = 10;
  public static int damage = 2;

  private static ArrayList<Item> inventory = new ArrayList<Item>();
  private static ArrayList<Quest> quests = new ArrayList<Quest>();


  public static void start() {
    name();
  }

  public static void name() {

    Main.clearScreen();
    System.out.print(ConsoleColors.DEFAULT);
    System.out.println("Who are you?\n");

    //name input
    System.out.print(ConsoleColors.input);
    name = Main.scan.nextLine();
    System.out.print(ConsoleColors.DEFAULT);

    //check if name is 2 to 10 chr long
    if (2 > name.length() || name.length() > 10) {
      System.out.print(ConsoleColors.system);
      System.out.println("\nname must be between 2 and 10 characters.\n\nI didn't make the rules.\nnow press enter and re enter your name.");
      Game.pressEnter();
      name();
      System.out.print(ConsoleColors.DEFAULT); 
    } 

    System.out.format("\n%sYou will be known as %s.", ConsoleColors.WHITE, ConsoleColors.nameColor());
    System.out.format("\n[%s] Yes, I am %s.\n[%s] Who's %s? that's not me.%s\n\n", ConsoleColors.num1(), name, ConsoleColors.num2(), name, ConsoleColors.DEFAULT);
    nameConfirm();
  }


  //answer input
  public static void nameConfirm() {  
    Game.input();
      
    //answer validation 
    if (ans != 1 && ans != 2) {
      System.out.print(ConsoleColors.system);
      System.out.println("Pro tip, enter the numbers: 1 or 2! \n\ntry again --> ");
      System.out.print(ConsoleColors.DEFAULT);
      nameConfirm();
    } 

    //accept
    if (ans == 1) {
      Main.clearScreen();
      generate();
    } 
    //deny 
    else if (ans == 2) {
      name();
    }
  }


  public static void generate() {

    health = 10;
    strength = 0;
    resilience = 0;
    speed = 0;
    gold = 10;

    System.out.format("Hello, %s", ConsoleColors.nameColor());
    System.out.format("\n\n%sChoose a role...\n[%s] Traveler\n[%s] Wizard\n[%s] Warrior%s\n\n", ConsoleColors.WHITE, ConsoleColors.num1(), ConsoleColors.num2(), ConsoleColors.num3(), ConsoleColors.DEFAULT);

    Game.input();

    //Traveler
    if (ans == 1) {
      role = " Traveler";
      strength = 1;
      resilience = 1;
      speed = 1;
      Art.setRolePicTraveler();
    }

    //Wizard
    if (ans == 2) {
      role = " Wizard";
      resilience = 1;
      speed = 1;
      Art.setRolePicWizard();
    }

    //Warrior
    if (ans == 3) {
      role = " Warrior";
      strength = 2;
      resilience = 1;
      Art.setRolePicWarrior();
    }

    int easter = 0;
    String easteregg = "Nooooo, take me back";
    if (ans > 3) {
        easteregg = "take me back, please";
        easter = 1;
    }

    
    //confirm role 
    System.out.format("\n%sAre you sure of being a%s?", ConsoleColors.WHITE, role);
    System.out.format("\n[%s] I am sure\n[%s] %s%s\n\n", ConsoleColors.num1(), ConsoleColors.num2(), easteregg, ConsoleColors.DEFAULT);

    Game.input();

    //easterEgg
    if (ans == 1 && easter == 1) {
      System.out.format("\nGoyHXJmEBXiBDUlg5j1cHd8NlKrA5pDrPXL2xbw6P0weCehjpDSm8RcdEr8KrF6ossBib1G62YahBPSzCX5Cr90d0uywNhlmDWAP9z4v5aqQSjVvEEWC8bGi\n[d] hUf0eBhcd\n[v] Ueb873bkf\n\n%sgreat you broke it. now you will have to re run the code. see you next time. bye  ", ConsoleColors.system);

      System.exit(0);
    } else if (ans == 2) {
        Main.clearScreen();
        generate();
      }


    if (ans == 1) {

      //skill points to assign
      gendisplay();
      assignPoints();
    }


    //easterEgg 
      if (ans == 2 && easter == 1) {
        System.out.format("\nGoyHXJmEBXiBDUlg5j1cHd8NlKrA5pDrPXL2xbw6P0weCehjpDSm8RcdEr8KrF6ossBib1G62YahBPSzCX5Cr90d0uywNhlmDWAP9z4v5aqQSjVvEEWC8bGi\n[d] hUf0eBdeh\n[v] Ueb873bkf\n%sgreat you broke it. now you will have to re run the code. don't do that next time. bye  ", ConsoleColors.system);

        System.exit(0);
      }

    if (ans == 2) {
      System.out.format("\n%sAre you sure that you're not sure?", ConsoleColors.WHITE);
      System.out.format("\n[%s] I am sure that I am not sure, take be back\n[%s] You know what? I change my mind, I am a %s.%s\n\n", ConsoleColors.num1(), ConsoleColors.num2(), role, ConsoleColors.DEFAULT);

      Game.input();

      if (ans == 1) {
        Main.clearScreen();
        generate();
      }
      if (ans == 2) {

        
        gendisplay();
        assignPoints();
      }
    }
  }


  public static void gendisplay() {
    
    Main.clearScreen();
    System.out.format("%s\n%sHealth:%s %d/%d\n%sGold:%s %d\n%sRole:%s %s\n%s", ConsoleColors.nameColor(), ConsoleColors.choice, ConsoleColors.DEFAULT, health, maxhealth, ConsoleColors.choice, ConsoleColors.DEFAULT, gold, ConsoleColors.choice, ConsoleColors.DEFAULT, role, role_pic);
    System.out.format("%s\nStats:%s", ConsoleColors.WHITE, ConsoleColors.DEFAULT);
    System.out.format("\nstrength: %d\nresilience: %d\nspeed: %d", strength + s, resilience + r, speed + sp);
  }

  public static void display() {
    
    Main.clearScreen();
    System.out.format("%s\n%sHealth:%s %d/%d\n%sGold:%s %d\n%sRole:%s %s\n%s", ConsoleColors.nameColor(), ConsoleColors.choice, ConsoleColors.DEFAULT, health, maxhealth, ConsoleColors.choice, ConsoleColors.DEFAULT, gold, ConsoleColors.choice, ConsoleColors.DEFAULT, role, role_pic);
    System.out.format("%s\nStats:%s", ConsoleColors.WHITE, ConsoleColors.DEFAULT);
    System.out.format("\nstrength: %d\nresilience: %d\nspeed: %d", strength, resilience, speed);
  }
  
  static int points = 2;
  


  public static void pointsValue() {
    
    if (points > 0) {
      assignPoints();
    }
    else if (points == 0){
      gendisplay();
      statconfirm();
    }
  }


  public static void assignPoints() {

    gendisplay();
    
    System.out.format("\n\n%sYou have %d points remaining.\n", ConsoleColors.WHITE, points);

    try {
      Thread.sleep(300);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    System.out.format("\nWhere would like to invest your points?%s", ConsoleColors.DEFAULT); 
    System.out.format("\n[%s] Strength\n[%s] Resilience\n[%s] Speed\n\n", ConsoleColors.num1(), ConsoleColors.num2(), ConsoleColors.num3());

    Game.input(); 

    if (ans == 1) {
      System.out.format("+1 Strength\n");
      s++;
    } 
    else if (ans == 2) {
      System.out.format("+1 Resilience\n");
      r++;
    }
    else if (ans == 3) {
      System.out.format("+1 Speed\n");
      sp++;
    }

    points--;
    pointsValue();
  }


  public static void statconfirm() {
    System.out.format("\n\n%sStats Updated!\n\nAre you happy with yourself?\n%s[%s] yeah, im good.\n[%s] i change my mind.%s\n\n", ConsoleColors.WHITE, ConsoleColors.choice, ConsoleColors.num1(), ConsoleColors.num2(), ConsoleColors.DEFAULT);

    Game.input();

    if (ans == 1) {
      
      strength = strength + s;
      resilience = resilience + r;
      speed = speed + sp;

      maxhealth = health + resilience;
      health = maxhealth;

      Main.clearScreen();
      gendisplay();

      //end of hero generation !!!
      
      
    }

    else if (ans == 2) {
      s = 0;
      r = 0;
      sp = 0;
      points = 2;

      Main.clearScreen();
      gendisplay();
      assignPoints();
    }
  }



    public static boolean hasCompletedQuest(int id){
        for (Quest q: Hero.quests){
            if (q.id == id && q.isCompleted == true){
                return true;
            }
        }

        return false;
    }

    public static void addQuest(Quest quest){
        Hero.quests.add(quest);

        System.out.println(ConsoleColors.WHITE);
        System.out.println("Quest Accepted: " + quest.name);
        System.out.println(ConsoleColors.DEFAULT);        
    }

    public static void showInventory(){
        System.out.println("INVENTORY");

        System.out.println(inventory);

    }    

    public static void showQuests(){
        System.out.println("QUESTS");

        System.out.println(quests);

    }

    public static void addItem(Item item){
        Hero.inventory.add(item);

        System.out.println(ConsoleColors.WHITE);
        System.out.format("\n%s added to inventory!",item.name);
        System.out.println(ConsoleColors.DEFAULT);        
    }

    public static boolean hasQuest(int id){
      for (Quest q: Hero.quests){
        if (q.id == id){
          return true;
        }
      }
      return false;
    }

    public static boolean hasItem(int id){
      for (Item i: Hero.inventory){
        if (i.id == id){
          return true;
        }
      }
        return false;
    }

    public static void completeQuest(int id){
      for (Quest q: Hero.quests){
        if (q.id == id){
          q.isCompleted = true;
          System.out.println(ConsoleColors.WHITE);
          System.out.println("Quest Complete: " + q.name);
          Hero.gold = Hero.gold + q.rewardGold;
          System.out.format("%d gold gained\n", q.rewardGold);
          
          for (Item i: q.rewardItems) {
            System.out.println("Item acquired: " + i.name);
            Hero.inventory.add(i);
          }
          System.out.println(ConsoleColors.DEFAULT);
        }
      }
    }

  public static int armor = 0;

  public static void takeDamage(int damage){
    if (Hero.hasItem(Item.ARMOR)) {
      armor = Game.random.nextInt(1);
    }
    Hero.health = Hero.health - (damage - armor);

    if (Hero.health < 0){
      Hero.health = 0;
    }

    System.out.println(ConsoleColors.RED);
    System.out.format("You take %d damage, %d/%d health remaining!\n", damage, Hero.health, Hero.maxhealth);
    System.out.println(ConsoleColors.DEFAULT);
  }

  public static int sword = 0;

  public static void attack(Monster enemy){

    if (Hero.hasItem(Item.SWORD)) {
      sword = 3;
    }
    int attack = Game.random.nextInt(Hero.damage) + 1 + Hero.strength + sword;

    enemy.health = enemy.health - attack;

    System.out.println(ConsoleColors.GREEN_BRIGHT);
    System.out.format("\n%s attacks %s for %d damage! %d health remaining.", Hero.name, enemy.name, attack, enemy.health);
    System.out.println(ConsoleColors.RESET);

    Game.wait(1);
  }

  public static boolean checkDefeat(){
    if (Hero.health <= 0 ) {
      //die
      System.out.println(ConsoleColors.RED);
      System.out.println("You have been defeated!");          
      System.out.println(ConsoleColors.DEFAULT);
      return true;
    } else {
      //alive
      return false;
      }
  }

  public static void fight(Monster enemy){
        Main.clearScreen();

        System.out.println("-----------------------------------------------------------");

        boolean fightOver = false;

        do {

            //Hero attacks first
            if (Hero.speed >= enemy.speed){
                Hero.attack(enemy);

                if (enemy.checkDefeat()){
                    fightOver = true;
                } else {
                    enemy.attack();

                    if (Hero.checkDefeat()){
                        fightOver = true;
                    }
                }

            //Enemy attacks first
            } else {
                enemy.attack();

                if (Hero.checkDefeat()){
                    fightOver = true;
                    
                } else {
                    Hero.attack(enemy);

                    if (enemy.checkDefeat()){
                       fightOver = true;
                    }
                }
            }
        } while (fightOver == false);
        Game.prompt();
        Game.pressEnter();
    }



    
}
