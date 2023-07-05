import java.util.Scanner;
import java.util.ArrayList;

class Main {

  public static Scanner scan = new Scanner(System.in);
  public static void clearScreen() { 
   System.out.print("\033[H\033[2J"); 
   System.out.flush(); 
  }
  
  public static void main(String[] args) {
    
    Game.start();

  }
}