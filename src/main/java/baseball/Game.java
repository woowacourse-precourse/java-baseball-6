package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computerNumberList;
    private Score score;

    public Game(){
        this.computerNumberList = Computer.getNumber();
        this.score = new Score();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (score.isOut()){
            List<Integer> numberList = input();
            checkNumber(numberList);
            printResult();
        }
    }

    private void printResult() {
        String printString = "";
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        if (ballCount > 0) {
            printString = printString + ballCount +"볼";
        }

        if ((strikeCount > 0) && (ballCount > 0)){
            printString = printString + " ";
        }

        if (strikeCount != 0) {
            printString = printString + strikeCount + "스트라이크";
        }

        if ((strikeCount == 0) && (ballCount == 0)) {
            printString = "낫싱";
        }
        System.out.println(printString);
    }


    private void checkNumber(List<Integer> numberList) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == j) && (numberList.get(i) == computerNumberList.get(j))){
                    strikeCount += 1;
                } else if (numberList.get(i) == computerNumberList.get(j)) {
                    ballCount += 1;
                }
            }
        }

        score.setStrikeCount(strikeCount);
        score.setBallCount(ballCount);
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
