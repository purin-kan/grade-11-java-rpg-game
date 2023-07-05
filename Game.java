import java.util.*;

class Game {

  /*
  public static String exampleLocation(){
    do {
      Main.clearScreen();

        //Tell the story
        //Show the keywords for the user type in
        System.out.println("Make your selection: ");

        String selection = Input.getString();    

      if (selection.equalsIgnoreCase("example")){
        // do whatever
        // return the next location

        return Locations.TOWN;

      } else if (selection.equalsIgnoreCase("example 2")){
        // do whatever
        // return the next location
        return Locations.TOWN;

        } else {
          Menu.doMenu(selection);
          }
    } while (true);    
  }
  */
  
  public static Random random = new Random();  
  
  public static void pressEnter() {
    Main.scan.nextLine();
  }

  public static void input() {
    System.out.print(ConsoleColors.input);
    Hero.ans = Main.scan.nextInt();
    Game.pressEnter();
    System.out.print(ConsoleColors.DEFAULT); 
  }

  public static String keyword(String text){
    return ColorText.colorize(text, ConsoleColors.GREEN);
  }

  public static String systemText(String text){
    return ColorText.colorize(text, ConsoleColors.system);
  }

  public static void prompt(){
    System.out.format("\n%s\n", systemText("-->"));
  }

  public static void wait(int sec) {
    try {
        sec = sec * 1000;
        Thread.sleep(sec);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
        }  
  }


  public static void start() {

    String nextLocation = Locations.INTRO;
    
    do {
        if(nextLocation.equals(Locations.INTRO)){
          nextLocation = doIntro();
        } else if(nextLocation.equals(Locations.GENERATOR)){
          nextLocation = doGenerator();
        }  else if(nextLocation.equals(Locations.STORY)){
          nextLocation = doSTORY();
        } else if(nextLocation.equals(Locations.TOWN)){
          nextLocation = doTown();
        } else if(nextLocation.equals(Locations.GUILD)){
          nextLocation = doGuild();
        } else if(nextLocation.equals(Locations.TAVERN)){
          nextLocation = doTavern();
        } else if(nextLocation.equals(Locations.CAVE)){
          nextLocation = doCave();
        } else if(nextLocation.equals(Locations.INN)){
          nextLocation = doInn();
        } else if(nextLocation.equals(Locations.PATH)){
          nextLocation = doPath();
        } else if(nextLocation.equals(Locations.AFTERLIFE)){
          nextLocation = doAfterlife();
        } else if(nextLocation.equals(Locations.ROOFEDFOREST)){
          nextLocation = doRoofedForest();
        } else if(nextLocation.equals(Locations.DEMONCONTINENT)){
          nextLocation = doDemonContinent();
        } else if(nextLocation.equals(Locations.ROOFEDFORESTNOENTRY)){
          nextLocation = doRoofedforestNOENTRY();
        } else if(nextLocation.equals(Locations.MAINHALL)){
          nextLocation = doMainhall();
        } else if(nextLocation.equals(Locations.BASEMENT)){
          nextLocation = doBasement();
        } else if(nextLocation.equals(Locations.STUDY)){
          nextLocation = doStudy();
        } else if(nextLocation.equals(Locations.THRONE)){
          nextLocation = doThrone();
        } 

        else{
         System.out.println("UNEXPECTED LOCATION: " + nextLocation);
         pressEnter();
         nextLocation = Locations.AFTERLIFE;
        }

    } while (!nextLocation.equals(Locations.QUIT));
    System.out.println("\nGame Over");
  }
  
  public static String doIntro(){

    Art.title();

    return Locations.GENERATOR;
  }


  public static String doGenerator(){

    Hero.start();

    return Locations.STORY;
  }


    public static String doSTORY(){
      
      Main.clearScreen();
      System.out.format("Wakeup %s, \n", Hero.name);
      wait(1); 
      System.out.println("it has been 100 years.");
      wait(2);

      do{   
        Main.clearScreen();
        System.out.format("You find yourself in the middle of the forest. \nThere is a %s%s leading somewhere, maybe you should follow it...", keyword("path"), ConsoleColors.DEFAULT);
        System.out.format("\n\n%skeep an eye out for green texts.\ntry typing 'path' %s\n", ConsoleColors.system, ConsoleColors.DEFAULT);
      
        String selection = Input.getString();
        if (selection.equalsIgnoreCase("path")){
          System.out.println("\n\nThe path leads to a nearby town.");
          
          wait(2);
          return Locations.TOWN;
        } 
      } while (true);   
    }

    public static int beenToTavern = 0;

    public static String doTown(){
        do {
            Main.clearScreen();

            System.out.format("\nWhere should you go?\n %s, %s, %s, %s, %s", keyword("Tavern"), keyword("Path"), keyword("Inn"), keyword("Guild"), keyword("Cave"));

        
            System.out.println("\n\n. . . \n\n");

            String selection = Input.getString();    

            if (selection.equalsIgnoreCase("guild")){
                if (beenToTavern == 1){
                  System.out.println("\nYou proceed towards the guild.");
                  wait(1);
                  return Locations.GUILD;
                } else {
                    System.out.format("\n\nI should get more information first. \nMaybe I can ask someone in the Tavern");
                    wait(2);
                    return Locations.TOWN;
                  }
            } else if (selection.equalsIgnoreCase("path")){
                System.out.println("\nYou proceed along the gravel path...");
                wait(1);
                return Locations.PATH;

            } else if (selection.equalsIgnoreCase("cave")){
                System.out.println("\nYou proceed towards the cave...");
                wait(1);
                return Locations.CAVE;
                
            } else if (selection.equalsIgnoreCase("inn")){
                System.out.println("\nYou proceed towards the inn...");
                wait(1);
                return Locations.INN;

            } else if (selection.equalsIgnoreCase("tavern")){
                System.out.println("\nYou walk into the Tavern..");
                wait(1);
                return Locations.TAVERN;
            } else {
               Menu.doMenu(selection);
            }

        } while (true);    
    }


    public static String doCave(){

      boolean ratFightDone = false;
      do {
        Main.clearScreen();
        
        if (Hero.hasQuest(Quest.CAVE) == true && Hero.hasCompletedQuest(Quest.CAVE) == false){
          System.out.println("'The cave is damp, it would be a perfect place for rodents...'");
          wait(2);
          System.out.println("\nyou proceed further into the cave.\n");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.format("\n\nDeep into the cave you find a %s.\n'I can use this to prove to the Guild that I have been here.'\n", keyword("Cave Carrot"));

          Item carrot = new Item(Item.CARROT);
          carrot.name = "Cave Carrot";
          carrot.description = "These carrot are commonly found in damp caves in this region";
          Hero.addItem(carrot);

          Game.prompt();
          Game.pressEnter();

          System.out.println("You start to make your way back out.\n");
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(2);
          System.out.format("\n\n%sA wild Giant Rat appears!%s", ConsoleColors.WHITE, ConsoleColors.DEFAULT);

          Game.prompt();
          Game.pressEnter();          
          
          Monster rat = new Monster("Rat");
          rat.damage = 1;
          rat.health = 8;
          rat.speed = 3;


          Hero.fight(rat);

          if (Hero.health > 0){
            Main.clearScreen();

          } else {
              return Locations.AFTERLIFE;
            }


          ratFightDone = true;

          Hero.completeQuest(Quest.CAVE);
          System.out.format("%s%d Gold remaining%s", ConsoleColors.system, Hero.gold, ConsoleColors.DEFAULT);

          System.out.println("\n\nI should report back to the guild.");

          Game.prompt();
          Game.pressEnter();

        } else {
          System.out.format("\n'Why would I want to go in there?'\n\n%s", systemText("-->"));
          Game.pressEnter();

          return Locations.TOWN;
          }
      } while (ratFightDone == false);

      return Locations.TOWN;
    }

    public static String doPath(){
      do {
        Main.clearScreen();
        
        if (Hero.hasItem(Item.MUSHROOM) == false){
          System.out.println("As you walk along the path you spot a mushroom on the ground.\n\n'might me useful for later..''");

          Item mushroom = new Item(Item.MUSHROOM);
          mushroom.name = "Red Mushroom";
          mushroom.description = "Commonly used to make medicine.";
          Hero.addItem(mushroom);

          Game.prompt();
          Game.pressEnter();
        }

        if (Hero.hasItem(Item.MUSHROOM) && Hero.hasQuest(Quest.JOURNEY) == false){
          System.out.println("Thick fog comes down, denying your entry...\n\n'There is nothing more to do here.'");
          Game.prompt();
          Game.pressEnter();
          
          return Locations.TOWN;

        } else if (Hero.hasItem(Item.MUSHROOM) && Hero.hasQuest(Quest.JOURNEY)){
          System.out.println("The think fog lifts away gently."); 

          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println("\nYou proceed beyond the strange barrier. ");

          Game.prompt();
          Game.pressEnter();
          
          return Locations.ROOFEDFOREST;
          
          }
      } while (true);
    }
  
    public static String doInn(){
      do {
            Main.clearScreen();

            System.out.format("\n Hello, welcome to stardrop inn.\nif would you like to stay with us for a night that will be 1 gold coin.\n\n%s, %s\n\n. . .\n\n", keyword("Stay"), keyword("Leave"));

            String selection = Input.getString();    

            if (selection.equalsIgnoreCase("stay")){
              Hero.gold = Hero.gold-1;
              System.out.format("\n%sGold -1\nYou have %d gold remaining.%s", ConsoleColors.system, Hero.gold, ConsoleColors.DEFAULT);
              
              wait(3);
              Main.clearScreen();
              System.out.println(".");
              wait(1);
              System.out.println(".");
              wait(1);
              System.out.println(".");
              wait(1);

              Hero.health = Hero.maxhealth;
              System.out.format("\nYou feel refreshed after a good night sleep.\n\n%sHealth Recovered!\n%d/%d Health Reamining\n\n-->%s", ConsoleColors.system, Hero.health, Hero.maxhealth, ConsoleColors.DEFAULT);
              
              Game.pressEnter();

              System.out.println("\nThank you for staying with us! Good Luck out there!");
              wait(2);
              return Locations.TOWN;

            } else if (selection.equalsIgnoreCase("leave")){
                System.out.println("\nYou left the Inn.");
                wait(1);
                return Locations.TOWN;
            } else {
               Menu.doMenu(selection);
            }
        } while (true);
    }

    public static String doTavern(){
      do {
        Main.clearScreen();
        System.out.format("Welcome to the tavern, \nYou see a %s at the counter, and a lone %s at a table.\n\n%s", keyword("man"), keyword("customer"), keyword("Leave"));


        System.out.println("\n\n. . . \n\n");

        String selection = Input.getString();    

        if (selection.equalsIgnoreCase("man")){
          
          Main.clearScreen();

          if (beenToTavern == 0){
            Hero.gold = Hero.gold - 2;
            System.out.format("\n'Haven't seen you around. What can I do for you?' asked the bartender.\nIf you gonna ask questions, you better pay up, 2 gold.\n\nYou paid 2 gold...\n%s%d %s\n\n'Tis the town of elveswood, located near the demon continent.\n recently things has gotten messy over there. An old bloke said he saw a piller of light from the old demon castle not long ago, can you believe him?\n\n. . .  \n\ninterested are ya?\n\nwell, not sure if I trust the feller but if you wanna go see what goodies you can find, go register at the guild, and fetch yourself some gear if you wanna come back alive.\n\n ", ConsoleColors.system, Hero.gold, systemText("Gold remaining"));
            beenToTavern = 1;
            Game.prompt();
            Game.pressEnter();
            
            return Locations.TOWN;  

          } else if (beenToTavern == 1) {

              System.out.println("\n'Tis the town of elveswood, located near the demon continent.\n recently things has gotten messy over there. An old bloke said he saw a piller of light from the old demon castle not long ago, can you believe him?\n\n. . .  \n\ninterested are ya?\n\nwell, not sure if I trust the feller but if you wanna go see what goodies you can find, go register at the guild, and fetch yourself some gear if you wanna come back alive.'\n\n ");
              Game.prompt();
              Game.pressEnter();
          } else {
            //checking 
            System.out.println("error");
          }

        } else if (selection.equalsIgnoreCase("customer")){
            System.out.println("\nThe guy is drinking very heavily. He looks drunk, better leave him alone.");
            Game.prompt();
            Game.pressEnter();    

            return Locations.TAVERN;

        } else if (selection.equalsIgnoreCase("leave")){
          
          return Locations.TOWN;

        } else {
             Menu.doMenu(selection);
          }
      } while (true);    
    }


    public static String doGuild(){
      do {
        Main.clearScreen();

        System.out.format("\nYou are welcomed by signs saying '%s' pointing to the %s and another that says '%s' pointing to the %s.\n\n%s\n\n. . .\n\n", keyword("Store"), keyword("left"), keyword("Commissions"), keyword("right"), keyword("Leave"));

        String selection = Input.getString();    

        if (selection.equalsIgnoreCase("store") || selection.equalsIgnoreCase("left")){
          
          Shop.doShop();

          return Locations.GUILD;

        } else if (selection.equalsIgnoreCase("Commissions") || selection.equalsIgnoreCase("right")){
          

          //dont have quest yet
          if (Hero.hasQuest(Quest.CAVE) == false && Hero.hasCompletedQuest(Quest.CAVE) == false){

            Main.clearScreen();

            System.out.format("\n'Hello, welcome to Elveswood Guild,\nif you would like to register as an adventurer and leave this town you must complete this quest!\n\n");

            Quest cave = new Quest(Quest.CAVE);
            cave.name = "Cave Exploration";
            cave.description = "To become an adventurer you must explore the near by cave and bring back something of proof.";
            cave.rewardGold = 5;
            Hero.addQuest(cave);

            Game.prompt();
            Game.pressEnter();
          } 
          //come back while still have quest 
          else if (Hero.hasQuest(Quest.CAVE) && Hero.hasCompletedQuest(Quest.CAVE) == false) {
            System.out.format("\n\nThe quest ain't gonna finish itself.\n\n");
            Game.prompt();
            Game.pressEnter();
          } 
          //quest Cave is done
          else if (Hero.hasCompletedQuest(Quest.CAVE)) {
            
            Main.clearScreen();

            System.out.format("\nYou have done well, completing your first quest.\n\nNow you are to investigate the nearby castle, there has been reports of weird sounds coming from there, beware. . . \n\n%s\n\n", systemText("It is reccommended to get a sword and armor from the store."));

            if (Hero.hasQuest(Quest.JOURNEY) == false){
              Quest journey = new Quest(Quest.JOURNEY);
              journey.name = "Journey to the castle!";
              journey.description = "You are to follow the path the Roofed forest into the castle on the Demon Continent.";
              //can never be completed(cannot return to town after roofed forst), gonna fail this and get a new quest to "find a way out" later in the game.
              Hero.addQuest(journey);
            }
            Game.prompt();
            Game.pressEnter();
          }
          return Locations.GUILD;

          } else if (selection.equalsIgnoreCase("leave")){
            return Locations.TOWN;

            } else {
              Menu.doMenu(selection);
              }
      } while (true);
    }

    public static String doRoofedForest(){

      Main.clearScreen();
      System.out.println("As you walk along the path, a forest slowly emerges from the horizon.");
      wait(1);
      System.out.println(".");
      wait(1);
      System.out.println(".");
      wait(1);
      System.out.println(".");
      wait(1);
      System.out.println("\nthe forst is dense, only a few rays of light are able to penetrate through the leafs. Thick trees lined the dimly lit path. \n\nYou feel an eerie presence watching you. . . \n\n\nWalking further along the path, you spot a tombstone-looking sign that reads:\n 'The Hero of the farlands, beware. . This forest of old. One may not return once more. . .");

      Game.prompt(); 
      Game.pressEnter();

      System.out.println("\n\nA POWERFUL GUST OF WIND SHOVES YOU OUT OF THE FOREST!"); 

      Game.prompt(); 
      Game.pressEnter();

      return Locations.DEMONCONTINENT;
    }

    public static String doDemonContinent(){
      do {
        Main.clearScreen();
  
        System.out.format("You arrive at the Demon Continent.\n\nA huge castle stood in front of you.\nYou feel a force compelling you to %s.\n\n%s\n\n. . . \n\n", keyword("enter"), keyword("Leave"));
        
        String selection = Input.getString();    
  
        if (selection.equalsIgnoreCase("enter")){

          System.out.println("\nYou walk along the castle's draw bridge.");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println("\nBOOM!\n\nA winged demon landed in front of you!");
          wait(2);

          Monster wingdemon = new Monster("Winged Demon");
          wingdemon.damage = 2;
          wingdemon.health = 15;
          wingdemon.speed = 3;

          Hero.fight(wingdemon);

          System.out.println("The force of the demon's landing had broken the bridge.\n\nThere is no turning back.");
          
          Game.prompt();
          Game.pressEnter();

          if (Hero.health > 0){
            Main.clearScreen();

          } else {
              return Locations.AFTERLIFE;
            }
          
          return Locations.MAINHALL;
  
        } else if (selection.equalsIgnoreCase("leave")){
        
          return Locations.ROOFEDFORESTNOENTRY;
  
          } else {
            Menu.doMenu(selection);
            }
      } while (true); 
    }

    public static String doRoofedforestNOENTRY(){
      do{
        Main.clearScreen();
        System.out.println("ํYou make your way back to the forest.");
        wait(1);
        System.out.println(".");
        wait(1);
        System.out.println(".");
        wait(1);
        System.out.println(".");
        wait(1);
  
        System.out.format("\n\nVery Strong wind rages out of the forest path.\n\nYou can either %s head-first to the path, or head %s to the castle.\n\n. . .\n\n", keyword("run"), keyword("back"));
        
        String selection = Input.getString();    
  
        if (selection.equalsIgnoreCase("run")){

          System.out.println("\nYou tried running head-first towards the path.");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println(".");
          wait(1);
          System.out.println("The wind is too stong to break through.\nYou plummeted to the ground.");
          Hero.health = Hero.health - 1;
          if (Hero.checkDefeat()){
            return Locations.AFTERLIFE;
          }
          System.out.format("%s-1 Health, %d/%d Remaining%s", ConsoleColors.system, Hero.health, Hero.maxhealth, ConsoleColors.DEFAULT);
          wait(1);
          System.out.println("\n'I guess the only way to go is into the castle.'");

          Game.prompt();
          Game.pressEnter();
          
          return Locations.DEMONCONTINENT;
  
        } else if (selection.equalsIgnoreCase("back")){

          System.out.println("\nYou make your way back towards the castle.");
          wait(1);
          return Locations.DEMONCONTINENT;
  
          } else {
            Menu.doMenu(selection);
            }
      } while (true);    
    }

    public static String doMainhall(){
      do {
        Main.clearScreen();

        System.out.format("\nYou walked into the Mainhall of the castle.\nThere is a set of staris leading %s to a room, leading %s, and a giant %s in front of you.\n\n. . . \n\n", keyword("up"), keyword("down"), keyword("door"));

        String selection = Input.getString();    

      if (selection.equalsIgnoreCase("up")){

        return Locations.STUDY;

        } else if (selection.equalsIgnoreCase("down")){

            return Locations.BASEMENT;

          } else if (selection.equalsIgnoreCase("door")){

              if(Hero.hasItem(Item.BRAND)){
                return Locations.THRONE;
              } else{
                  System.out.println("\nMysterious forces deny your entry.");
                  wait(1);
                  return Locations.MAINHALL;
                }
            } else {
                Menu.doMenu(selection);
              }
      } while (true); 
      
    }

    public static String doBasement(){
      do {
        Main.clearScreen();
        System.out.format("\nYou walked down the stairs to find a basement.\nThere is a strange needle on a pedestal.\n\n%s, %s\n\n. . . \n\n", keyword("Touch"), keyword("Leave"));

        String selection = Input.getString();    
  
        if (selection.equalsIgnoreCase("touch")){
          Hero.health = Hero.health - 1;
          if (Hero.checkDefeat()){
            return Locations.AFTERLIFE;
          }
          System.out.format("%s\n-1 Health, %d/%d Remaining%s", ConsoleColors.system, Hero.health, Hero.maxhealth, ConsoleColors.DEFAULT);
          System.out.println("\nOuch!\nYou pricked yourself. . . \n\nblood dripped along the needle. The stone on the pedestal seems to have a slight glow.");

          Item brand = new Item(Item.BRAND);
          brand.name = "Odd Stone";
          Hero.addItem(brand);

          Game.prompt();
          Game.pressEnter();
          
          return Locations.MAINHALL;
  
        } else if (selection.equalsIgnoreCase("leave")){
          
          return Locations.MAINHALL;
  
          } else {
            Menu.doMenu(selection);
            }
      } while (true);    
    }

    public static int potionInStudy = 1;
  
    public static String doStudy(){
      do {
        Main.clearScreen();

        System.out.format("The stairs leads to a study. You see a %s on the table next to an open %s.\n\n%s\n\n. . . \n\n", keyword("potion"), keyword("book"), keyword("Leave"));

        String selection = Input.getString();    

      if (selection.equalsIgnoreCase("potion")){

        if(potionInStudy == 1){
          System.out.println("\nYou drunk the potion.");
          Hero.health = Hero.maxhealth;
          System.out.format("%s", systemText("Health restored!"));
          potionInStudy = 0;
          Game.prompt();
          Game.pressEnter();
          
          return Locations.STUDY;
          } else if(potionInStudy == 0){
              System.out.println("\nThe bottle is empty.");
              Game.prompt();
              Game.pressEnter();
          
              return Locations.STUDY;             
            }

      } else if (selection.equalsIgnoreCase("book")){
        Main.clearScreen();
        System.out.format("\nMILITARY REPORT 5: June 2nd, 2019\nToday the army grew by 120 units. In estimately 3 more days the army would be large enough to take over the Human town of Elveswood. \n\nAfter controlling that territory, we can initialize phase 2:\nEstablish safe transport route for resources to contruct a Semi-temporary Military base. . . . . . . . .\n\n\nAfter reading the papers on the table you hear a voice in your head\n%s", systemText("You must defeat the Demon Lord. . ."));
        
        Game.prompt();
        Game.pressEnter();
        
        return Locations.STUDY;

        } else if (selection.equalsIgnoreCase("leave")){
            return Locations.MAINHALL;
        } else {
          Menu.doMenu(selection);
          }
      } while (true);    
    }

    public static String doThrone(){
      Main.clearScreen();

      System.out.println("You push open the giant door to reveal a Throne room.\nInside, a strong looking figure wearing a crown of thorns. \nHe laughs at you.\n\nPathetic Human. You wish to challenge me? I'd like to see you try.");

      Game.prompt();
      Game.pressEnter();

      Monster lord = new Monster("Demon Lord");
      lord.damage = 3;
      lord.health = 30;
      lord.speed = 2;


      Hero.fight(lord);

      if (Hero.health > 0){
        Main.clearScreen();

      } else {
          return Locations.AFTERLIFE;
        }

      Main.clearScreen();
      System.out.format("%s, you did it. You saved the town. You can rest easy now.\n\nThank you\n\n\n\nCongratulations, You Won!! ", Hero.name);
      
      return Locations.QUIT;
      
    }
  
    public static String doAfterlife(){

      Main.clearScreen();
      System.out.format("You have died. \n\nTips: \nStrength increases your damage\nResilience increases your max health\nSpeed allows you to attack first\nA sword from the shop increases your damage\nArmor from the shop decreases damage taken\nIn the study, there is a potion where you can restore health before the final fight\n\nBetter luck next time");

      return Locations.QUIT;
    }






  }



  


