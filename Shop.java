import java.util.ArrayList;

public class Shop{

    public static ArrayList<Item> itemsForSale = new ArrayList<Item>();

    public static boolean firstTime = true;


    public static void stockShelf(){

        if (firstTime == true){

            firstTime = false;

            Item sword = new Item(Item.SWORD);
            sword.name = "Short Sword";
            sword.price = 3;
            itemsForSale.add(sword);

            Item potion = new Item(Item.POTION_OF_HEALING);
            potion.name = "Potion of Healing";
            potion.price = 2;
            itemsForSale.add(potion);

            Item charm = new Item(Item.CHARM);
            charm.name = "Charm";
            charm.price = 5;
            itemsForSale.add(charm);

            Item armor = new Item(Item.ARMOR);
            armor.name = "Armor";
            armor.price = 5;
            itemsForSale.add(armor);
            
        } 

    }

    public static void doShop(){

        Shop.stockShelf();

        boolean shoppingComplete = false;

        do {
            Main.clearScreen();
            System.out.println("Here is what I have for sale \n");

            int i = 1;

            for (Item item : itemsForSale){
                System.out.format("%d. %s%s%s : %d gold\n", i, ConsoleColors.WHITE, item.name, ConsoleColors.DEFAULT, item.price);
                i++;
            }

            System.out.format("\nYou have %d gold.\n\n", Hero.gold);

            Hero.showInventory();

            System.out.format("\n\nChoose the item %s or %s the shop.\n\n. . .\n\n", Game.keyword("number"), Game.keyword("leave"));

            
            //If the user typed an Integer
            if (Main.scan.hasNextInt()){
    
                int choice = Input.getInt() - 1;
                if (choice < itemsForSale.size() && choice >= 0){
                    Item item = itemsForSale.get(choice);
                    if (Hero.gold >= item.price){
                        Hero.gold -= item.price;
                        Hero.addItem(itemsForSale.remove(choice));
                        Game.prompt();
                        Game.pressEnter();

                    } else {
                        System.out.format("\nSorry, afraid you don't have enough for that %s\n", item.name);
                        Game.prompt();
                        Game.pressEnter();
                      }

                } else {
                    System.out.format("\n%s", Game.systemText("Sorry that is not a valid choice"));
                    Game.prompt();
                    Game.pressEnter();
                  }

            //typed in string
            } else {
                String selection = Input.getString();

                if (selection.equalsIgnoreCase("leave"))
                {
                    shoppingComplete = true;
                } else {
                    System.out.println("Sorry that is not a valid choice");
                    Game.prompt();
                    Game.pressEnter();
                  }
              }


        } while (shoppingComplete == false);



    }

    public static boolean hasItem(int id){
        for (Item i: Shop.itemsForSale){
            if (i.id == id){
                return true;
            }
        }
 
        return false;
    }

}