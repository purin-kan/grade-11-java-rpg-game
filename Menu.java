public class Menu{

    public static void doMenu(String selection){
        if (selection.equalsIgnoreCase("stats")){
            Main.clearScreen();
            Hero.display();
            Game.pressEnter();
            Game.prompt();
            
        } else if (selection.equalsIgnoreCase("inventory")){
            Main.clearScreen();
            Hero.showInventory();
            Game.pressEnter();
            Game.prompt();

        }  else if (selection.equalsIgnoreCase("quests")){
            Main.clearScreen();
            Hero.showQuests();
            Game.pressEnter();
            Game.prompt();

        } else {
            System.out.format("%s\nInvalid selection\ntry again %s-->", ConsoleColors.system, ConsoleColors.DEFAULT);
            Game.pressEnter();
        }
    }

}