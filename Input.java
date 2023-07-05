class Input { 


    //all methods go here

    public static void pressEnterToContinue(){
        System.out.println("PRESS ENTER TO CONTINUE");
        Main.scan.nextLine();
    }


    // IN JAVA you can have methods with the same name, but different parameters
    // this is called OVERLOADING

    //gets the integer from the user
    public static int getInt(){
        int i = Main.scan.nextInt();
        Main.scan.nextLine();

        return i;
    }

    //prints a message and then gets the integer from the user
    public static int getInt(String msg){
        System.out.print(msg);
        int i = Main.scan.nextInt();
        Main.scan.nextLine();

        return i;
    }

    //gets the String from the user
    public static String getString(){
        return Main.scan.nextLine();
    }

    //prints a message and then gets the String from the user
    public static String getString(String msg){
        System.out.print(msg);
        return Main.scan.nextLine();
    }

    //gets the next Double from the user and returns it
    public static double getDouble(){
        double d = Main.scan.nextDouble();
        Main.scan.nextLine();

        return d;
    }
}