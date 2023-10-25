package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int strike = 0;
    private int ball = 0;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public List<Integer> getRandomNum(){
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        // System.out.println(Arrays.deepToString(randomNum.toArray()));
        return randomNum;
    }
    public List<Integer> getUserInput() throws IllegalArgumentException{
        List<Integer> userNum = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        // 예외 처리 0포함할 경우 OR 길이가 3보다 클 경우
        if(userInput.contains("0") || userInput.length() != 3){
            throw new IllegalArgumentException();
        }
        int inputNum = Integer.parseInt(userInput);

        userNum.add(inputNum / 100);
        userNum.add((inputNum % 100) / 10);
        userNum.add(inputNum % 10);

        return userNum;
    }
    void compareNum(List<Integer> randomNum, List<Integer> userNum){
        strike = 0;
        ball = 0;

        for (int i = 0; i < randomNum.size(); i++) {
            for (int j = 0; j < userNum.size(); j++) {
                if (randomNum.get(i).equals(userNum.get(j)) && i == j)
                    strike++;
                if (randomNum.get(i).equals(userNum.get(j)) && i != j)
                    ball++;
            }
        }

    }
    public int printHint(){
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");

        if(strike == 0 && ball != 0)
            System.out.printf("%d볼\n", ball);

        if(strike != 0 && ball == 0)
            System.out.printf("%d스트라이크\n", strike);

        if(strike !=0 && ball != 0)
            System.out.printf("%d볼 %d스트라이크\n", strike, ball);

        if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        return strike;
    }

    public int continueGame()throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        int userChoice = Integer.parseInt(userInput);
        if(!(userChoice == 1 || userChoice == 2))
            throw new IllegalArgumentException();

        return userChoice;

    }
}

