import java.util.ArrayList;

public class Monster{

    public String name;
    public int health;

    public int speed;
    public int damage;

    public int rewardGold;

    public ArrayList<Item> rewardItems = new ArrayList<Item>();

    public Monster(String monsterName){
        name = monsterName;
    }

    public void attack(){
        int attack = Game.random.nextInt(damage) + 1;

        Hero.takeDamage(attack);

        Game.wait(1);

    }

    public boolean checkDefeat(){
        if (health <= 0 ) {
            System.out.println(ConsoleColors.GREEN_BRIGHT);
            System.out.format("%s has been defeated!\n", name);
            System.out.println(ConsoleColors.DEFAULT);
            return true;
        } else {
            return false;
        }
    }

}