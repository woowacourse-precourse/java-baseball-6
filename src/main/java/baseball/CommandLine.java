package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;

public class CommandLine {

    private final static PrintStream PRESENTATION = System.out;

    public static void showln(String message){
        PRESENTATION.println(message);
    }

    public static void show(String message){
        PRESENTATION.print(message);
    }

    public static String input(){
        return Console.readLine();
    }

    public static String input(String message){
        show(message);
        return Console.readLine();
    }

}
