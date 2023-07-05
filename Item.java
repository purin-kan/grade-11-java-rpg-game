public class Item{

    public static final int MUSHROOM = 1;
    public static final int CARROT = 2;
    public static final int BRAND = 3;
    

    public static final int SWORD = 6;
    public static final int POTION_OF_HEALING = 7;
    public static final int CHARM = 8;
    public static final int ARMOR = 9;


    int id;
    int price;
    String type; // item, weapon, armor, potion, ammo
    int number;

    String name;
    String description;

    int damage;

    public Item(int itemId){
        id = itemId;
    }
    
    public String toString(){
      return String.format("%s", name);
    }

}