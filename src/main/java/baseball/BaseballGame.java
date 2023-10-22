package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void playGame() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

        boolean isPlay = true;
        while (isPlay) {
            List<Integer> computer = generateRandomNumber.getNumberList();

            playOneGame(computer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            isPlay = getIsPlay();
        }
    }

    private void playOneGame(List<Integer> computer) {

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> inputNumberList = getInputNumberList();
            int strike = checkStrike(computer,inputNumberList);
            int ball = checkBall(computer,inputNumberList);

        }

    }

    private int checkStrike(List<Integer> computer, List<Integer> input){
        int count =0;
        for(int i=0; i<3; i++){
            if(computer.get(i) == input.get(i)){
                count++;
            }
        }
        return count;
    }

    private int checkBall(List<Integer> computer, List<Integer> input){
        int count =0;
        for(int i=0; i<3; i++){
            int comNumber = computer.get(i);
            for (int j = 0; j < 3; j++) {
                int inputNumber = input.get(j);
                if (i != j && comNumber == inputNumber) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private List<Integer> getInputNumberList() {
        String inputNumber = Console.readLine();
        List<Integer> numberList = new ArrayList<>();
        int validatedNumber = validateNumber(inputNumber);

        int count = 100;
        for (int i = 0; i < 3; i++) {
            int tmp = validatedNumber / count;
            numberList.add(tmp);
            validatedNumber %= count;
            count /= 10;
        }
        return numberList;
    }

    private Integer validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 999 || number < 100) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


    private boolean getIsPlay() {
        String input = Console.readLine();
        if (input != "1" || input != "2") {
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }

}
