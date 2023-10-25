package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer = new ArrayList<>();

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame(){
        makeRandomAnswer();
        int[] userInputIntArr;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputStr = Console.readLine();
            userInputIntArr = getUserNumber(userInputStr);
        } while (!guessCorrectAnswer(userInputIntArr));
    }

    private void makeRandomAnswer(){
        answer.clear();
        while(answer.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNum)){
                answer.add(randomNum);
            }
        }
        for (Integer integer : answer) {
            System.out.println(integer.toString());
        }
    }

    private boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStr = Console.readLine();
        if(inputStr.equals("1")){
            return true;
        }else if(inputStr.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
        }
    }

    private boolean guessCorrectAnswer(int[] userInput){
        int strike = countStrike(userInput);
        int ball = countBall(userInput);
        ball -= strike;
        printResult(strike, ball);

        return strike == 3;
    }

    private int[] getUserNumber(String userInputStr) throws IllegalArgumentException{
        if(userInputStr.length() != 3){
            throw new IllegalArgumentException("잘못된 길이의 입력입니다.");
        }
        int[] userInputIntArr = new int[3];
        for(int i = 0; i < 3; i++){
            if(userInputStr.charAt(i) < '1' || userInputStr.charAt(i) > '9'){
                throw new IllegalArgumentException("잘못된 범위의 입력입니다.");
            }
            for(int j = 0; j < i; j++){
                if(userInputStr.charAt(i) == userInputStr.charAt(j))
                    throw new IllegalArgumentException("잘못된 입력입니다. 서로 다른 3자리 수를 입력하세요.");
            }
            userInputIntArr[i] = Integer.parseInt(userInputStr.substring(i, i + 1));
        }
        return userInputIntArr;
    }

    private int countStrike(int[] userInput){
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if(userInput[i] == answer.get(i)){
                strike++;
            }
        }
        return strike;
    }

    private int countBall(int[] userInput){
        int ball = 0;
        for (int i : userInput) {
            if(answer.contains(i)){
                ball++;
            }
        }
        return ball;
    }

    private void printResult(int strike, int ball){
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
