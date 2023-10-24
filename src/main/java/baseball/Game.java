package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public int gameStatus = 0;
    public int strike = 0;
    public int ball = 0;

    private ArrayList<Integer> randomNumber;

    public void setRandomNumber() {
        RandomNumber randomNumberGenerator = new RandomNumber();
        this.randomNumber = randomNumberGenerator.getRandomNumber();
        // System.out.println(randomNumber);
    }
    public void playGame() {
        this.strike = 0;
        this.ball = 0;
        System.out.print("숫자를 입력해주세요 : ");
        UserInput userInput = new UserInput();
        userInput.setUserInput();
        ArrayList<Integer> userNumber = userInput.getUserNumber();
        checkAnswer(userNumber);
        printHint();
    }
    public void checkAnswerOld(ArrayList<Integer> arrayList) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (randomNumber.get(i) == arrayList.get(j)) {
                    if (i == j) {
                        this.strike += 1;
                    }
                    else {
                        this.ball += 1;
                    }
                    break;
                }
            }
        }
    }
    public void checkAnswer(ArrayList<Integer> userNumber){
        int totalHit = 0;
        for (int i=0; i<3; i++) {
            if (randomNumber.contains(userNumber.get(i))) totalHit+=1;
            if (randomNumber.get(i) == userNumber.get(i)) this.strike+=1;
        }
        this.ball = totalHit-this.strike;
    }
    public void printHint() {
        if (ball == 0) {
            if (strike == 0) {
                System.out.println("낫싱");
            }
            else {
                System.out.println(strike + "스트라이크");
            }
        }
        else {
            if (strike == 0) {
                System.out.println(ball + "볼");
            }
            else {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            }
        }
    }
    public void checkGameStatus() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        this.gameStatus = Integer.parseInt(readLine());
    }
}
