package baseball;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private View view;
    private List<Integer> computerNumberList;
    private Score score;

    public Game(View view){
        this.computerNumberList = Computer.getNumber();
        this.score = new Score();
        this.view = view;
    }

    public void start() {
        view.printGameStartMessage();
        while (score.isOut()){
            List<Integer> numberList = input();
            checkNumber(numberList);
            view.printGameResultMessage(score);
        }
        view.printGameEndMessage();
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

        score.setScore(strikeCount, ballCount);
    }

    private List<Integer> input(){
        view.printInputMessage();
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
