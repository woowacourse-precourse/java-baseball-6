package service;

import static domain.StringConstant.*;

public class PrintService {
     public static void printStartApplication() {
         System.out.println(START_APPLICATION_MESSAGE);
     }

     public static void printInputForm() {
         System.out.print(INPUT_FORM_MESSAGE);
     }

     public static void printCheckResult(int ball, int strike) {
         if (ball == 0 && strike == 0)
             System.out.print(NOTHING_STRING);

         if (ball > 0)
             System.out.printf("%d%s ", ball, BALL_STRING);

         if (strike > 0)
             System.out.printf("%d%s", strike, STRIKE_STRING);

         System.out.println();
     }

     public static void printCorrectAnswer() {
         System.out.println(CORRECT_ANSWER_MESSAGE);
     }

     public static void printRestartForm() {
         System.out.println(RESTART_FORM_MESSAGE);
     }

     public static void printCloseApplication() {
         System.out.println(CLOSE_APPLICATION_MESSAGE);
     }
}
