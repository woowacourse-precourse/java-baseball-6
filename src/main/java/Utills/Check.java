package Utills;

import static Utills.Define.*;
public class Check {
    public static void checkIsValidAnswer(String answers) {
        checkStringlength(answers);
        checkIsZeroToNine(answers);
    }
    private static void checkIsZeroToNine(String answers){
        for (int i = 0; i < answers.length(); i++) {
            if (answers.charAt(i) < '0' || answers.charAt(i) > '9') {
                throw new IllegalArgumentException(answers);
            }
        }
    }
    private static void checkStringlength(String answers){
        if(answers.length() != MaxLength) {
            throw new IllegalArgumentException();
        }
    }
}
