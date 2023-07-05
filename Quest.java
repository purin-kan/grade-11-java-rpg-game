import java.util.ArrayList;

public class Quest{

    public static final int CAVE = 1;
    public static final int JOURNEY = 2;


    public int id;

    public String name;
    public String description;

    public int rewardGold;
    public int rewardXP;

    //not static, every quest has it own list of reward items
    public ArrayList<Item> rewardItems = new ArrayList<Item>();

    boolean isCompleted;

    public Quest(int questId){
        id = questId;
    }

    public String toString(){
      return String.format("%s", name);
    }

}