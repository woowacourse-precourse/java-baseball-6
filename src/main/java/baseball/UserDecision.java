package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDecision {
    public static String userDecision(Scanner sc){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        try{
            String input = sc.next();
            checkUserDecision(input);
            return input;
        } catch (InputMismatchException e){
            throw new IllegalArgumentException("1 또는 2 입력");
        }
    }

    private static void checkUserDecision(String input) throws IllegalArgumentException{
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

}
