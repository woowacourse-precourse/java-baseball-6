package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computerNumberList;

    public Game(){
        this.computerNumberList = Computer.getNumber();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] result = {0, 0};
        while (isProgress(result)){
            List<Integer> numberList = input();
            result = checkNumber(numberList);
            printResult(result);
        }
    }

    private boolean isProgress(int[] result) {
        if (result[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    private void printResult(int[] result) {
        String printString = "";

        if (result[1] != 0) {
            printString = printString + result[1] +"볼";
        }

        if ((result[0] != 0) && (result[1] != 0)){
            printString = printString + " ";
        }

        if (result[0] != 0) {
            printString = printString + result[0] + "스트라이크";
        }

        if (printString.equals("")) {
            printString = "낫싱";
        }
        System.out.println(printString);
    }


    private int[] checkNumber(List<Integer> numberList) {
        int[] result = {0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == j) && (numberList.get(i) == computerNumberList.get(j))){
                    result[0] += 1;
                } else if (numberList.get(i) == computerNumberList.get(j)) {
                    result[1] += 1;
                }
            }
        }
        return result;
    }

    private List<Integer> input(){
        System.out.print("숫자를 입력해주세요 : ");
        String stringNumber = Console.readLine();
        if (!validation(stringNumber)) {
            throw new IllegalArgumentException();
        }
        List<Integer> numberArray = stringToList(stringNumber);
        return numberArray;
    }

    private List<Integer> stringToList(String stringNumber) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char charNumber = stringNumber.charAt(i);
            Integer number = Character.getNumericValue(charNumber);
            if (numberList.contains(number)) {
                throw new IllegalArgumentException();
            }
            numberList.add(number);
        }
        return numberList;
    }

    private boolean validation(String stringNumber) {
        boolean isNumeric = (stringNumber.length() == 3 && stringNumber.matches("[0-9]+"));
        return isNumeric;
    }
}
