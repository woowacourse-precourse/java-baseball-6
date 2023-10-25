package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import baseball.verification.InputVerification;

public class Application {
    public static int[] setRandom(){
        int i = 0;
        int[] answer = new int[3];

        while(i < 3){
            answer[i] = Randoms.pickNumberInRange(1,9);
            if(Arrays.stream(answer).distinct().count() > i){
                i++;
            }
        }
        return answer;
    }
    public static void printResult(int ball, int strike){
        if(ball != 0){
            System.out.print(ball+"볼 ");
        }
        if(strike != 0){
            System.out.print(strike+"스트라이크");
        }
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
    public static void printClear() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void calculateScore(int[] computer, int[] human){
        Score score = new Score();

        for (int i = 0; i < 3; i++) {
            if (computer[i]==human[i]) {
                score.setStrike();
                continue;
            }
            for(int j=0; j < 3; j++){
                if (i==j){continue;}
                if (computer[j] == human[i]) {
                    score.setBall();
                }
            }
        }
    }
    public static String inputUser(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
    public static void startGame() {
        String strInput;
        int[] answer = setRandom();
        int[] intInput = new int[3];
        Score score = new Score();

        while (true) {
            score.init();

            strInput = inputUser();
            InputVerification.checkNumber(strInput);

            for (int i = 0; i < 3; i++) {
                intInput[i] = Integer.parseInt(strInput.substring(i, i + 1));
            }
            InputVerification.checkDuplication(intInput);
            calculateScore(answer, intInput);
            printResult(score.getBall(), score.getStrike());

            if(score.getStrike() == 3){
                printClear();
                break;
            }
        }
    }

    public static void playGame(){
        String game = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(game.equals("1")) {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = Console.readLine();
            InputVerification.checkMenu(game);
        }
    }
    public static void main(String[] args) {
        playGame();
        // TODO: 프로그램 구현
    }
}
