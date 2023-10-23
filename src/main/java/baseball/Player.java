package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private int number;
    private int[] numbers = new int[10];

    private Player(){
        String stringNumber = Console.readLine();

        if(isCorrectNumber(stringNumber)){
            this.number = Integer.parseInt(stringNumber);
        }
    }

    private boolean isCorrectNumber(String stringNumber) {
        if(isDistinctNumber(stringNumber) && isPositiveNumber(stringNumber) && isOnetoNine(stringNumber)
                && isOnlyNumber(stringNumber) && isThreeCount(stringNumber)){
            return true;
        }

        throw new IllegalArgumentException();
    }

    private boolean isThreeCount(String stringNumber) {
        return stringNumber.length() == 3;
    }

    private static boolean isOnlyNumber(String stringNumber) {
        return stringNumber.matches("[1-9]+");
    }

    private boolean isOnetoNine(String stringNumber) {
        return stringNumber.contains("0");
    }

    private boolean isPositiveNumber(String stringNumber) {
        return Integer.parseInt(stringNumber) > 0;
    }

    private boolean isDistinctNumber(String stringNumber) {
        for (int i = 0; i < 3; i++){
            int number = stringNumber.charAt(i) - '0';
            numbers[number]++;
            if(numbers[number] > 1){
                return false;
            }
        }
        return true;
    }

    public static Player nextNumberOf(){
        return new Player();
    }

    public int getNumber() {
        return number;
    }

}