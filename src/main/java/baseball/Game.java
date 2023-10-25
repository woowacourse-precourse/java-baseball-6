package baseball;

import java.util.HashSet;
import java.util.List;


public class Game {

    private static final int INPUT_NUMBER_LENGTH = 3;
    private static final int RESTART = 1;
    private static final int END = 2;
    private static Computer computer;
    private static Player player;

    public static void startGame(List<Integer> computerSelectNumbers) {
        startMessage();
        String input = player.inputNumber();
        compare(computerSelectNumbers, input);
    }

    public static String startMessage() {
        return "숫자를 입력해주세요: ";
    }

    public static String restartMessage() {
        return "게임을 새로 시작하려면"+RESTART+", 종료하려면 "+END+"를 입력하세요.";
    }

    public static void compare(List<Integer> computer, String input) {
        int cntStrike = 0;
        int cntBall = 0;
        HashSet<Integer> checkRepetition = new HashSet<>();

        for(int i=0; i<computer.size(); i++) {
            int num = player.inputStrParseInt(input,i);
            Exception.numberRangeValidation(num);
            checkRepetition.add(num);

            if((num) == computer.get(i)) {
                cntStrike += 1;
            }
            else if (computer.contains(num)) {
                cntBall += 1;
            }

        }
        Exception.checkOverlap(checkRepetition);

        countResult(cntStrike, cntBall);
        gameResult(computer, cntStrike, cntBall);

    }

    public static void countResult(int cntStrike, int cntBall) {
        if (cntStrike == 0 && cntBall == 0) {
            System.out.println("낫싱");
        } else if (cntStrike == 0 && cntBall > 0 ) {
            System.out.println(cntBall + "볼");
        } else if (cntStrike > 0 && cntBall > 0) {
            System.out.println(cntBall + "볼 "+ cntStrike + "스트라이크");
        } else if (cntStrike > 0 && cntBall == 0 ) {
            System.out.println(cntStrike + "스트라이크");
            if (cntStrike ==INPUT_NUMBER_LENGTH) {
                System.out.println(INPUT_NUMBER_LENGTH+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }

    public static void gameResult(List<Integer> computer, int cntStrike, int cntBall) {
        if (cntStrike == INPUT_NUMBER_LENGTH && cntBall == 0) {
            restartOrNot();
        } else {
            startGame(computer);
        }
    }

    public static void restartOrNot() {
        restartMessage();
        int num = player.inputRestartStatus();
        if (num == RESTART) {
            gameRestart();
        } else if (num == END) {
            return;
        } else {
            Exception.inputRestartStatusValidation();
        }
    }

    public static void gameRestart() {
        List<Integer>  computerSelectNumbers = computer.selectNumbers();
        startGame(computerSelectNumbers);
    }




}
