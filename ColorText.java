public class ColorText{

  

    //Changes the foreground color to the RGB color given
    public static String rgb(int red, int green, int blue){

        return String.format("\033[38;2;%d;%d;%dm", red, green, blue);

    }


    //Changes the background color to the RGB color given
    public static String rgb_bg(int red, int green, int blue){

        return String.format("\033[48;2;%d;%d;%dm", red, green, blue);

    }

    public static String colorize(String text, String color){
        return color + text + ConsoleColors.DEFAULT;
    }

    public static void pink(){
        System.out.print(rgb(255,192,203));
    }

    public static String blue(String text){
        return colorize(text, ConsoleColors.BLUE);
    }

    public static String red(String text){
        return colorize(text, ConsoleColors.RED);
    }
}