package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;


public class Game {
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 9;
    private static final int INPUT_NUMBER_LENGTH = 3;
    private static final int RESTART = 1;
    private static final int END = 2;
    private static Computer computer;
    private static Player player;

    // 3개 숫자를 요청
    public static void startGame(List<Integer> computerSelectNumbers) {
        String input = player.inputNumbers();
        int len = input.length();
        checkInputSize(len);
        compare(computerSelectNumbers, input);

    }


    public static void compare(List<Integer> computer, String input) {
        int cntStrike = 0;
        int cntBall = 0;
        HashSet<Integer> checkRepetition = new HashSet<>();

        for(int i=0; i<computer.size(); i++) {
            int num = stringToInt(input, i);
            numberRangeValidation(num);
            checkRepetition.add(num);

            if((num) == computer.get(i)) {
                cntStrike += 1;
            }
            else if (computer.contains(num)) {
                cntBall += 1;
            }

        }
        checkOverlap(checkRepetition);
        countResult(cntStrike, cntBall);
        gameResult(computer, cntStrike, cntBall);

    }
    public static void checkInputSize(int len) {
        if(len != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 "+INPUT_NUMBER_LENGTH+"개를 입력하세요.");
        }
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


    public static void checkOverlap(HashSet<Integer> array) {
        if(array.size() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("서로 다른 "+INPUT_NUMBER_LENGTH+"자리의 수를 입력하세요.");
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
        String input = inputRestartStatus();
        int num = stringToInt(input,0);
        if (num == RESTART) {
            gameRestart();
        } else if (num == END) {
            return;
        } else {
            inputRestartStatusValidation();
        }
    }

    public static String inputRestartStatus() {
        System.out.println("게임을 새로 시작하려면"+RESTART+", 종료하려면 "+END+"를 입력하세요.");
        return Console.readLine();
    }


    public static void inputRestartStatusValidation() {
        throw new IllegalArgumentException(RESTART+","+END+" 이외의 값은 입력할 수 없습니다.");
    }

    public static void gameRestart() {
        List<Integer>  computerSelectNumbers = computer.selectNumbers();
        startGame(computerSelectNumbers);
    }


    public static void numberRangeValidation(int num) {
        if (num<START_NUMBER | num>LAST_NUMBER) {
            throw new IllegalArgumentException(START_NUMBER+"~"+LAST_NUMBER+"를 이용한 "+INPUT_NUMBER_LENGTH+"자리의 수만 입력할 수 있습니다.");
        }
    }

    public static int stringToInt(String str, int i) {
        int num = Character.getNumericValue(str.charAt(i));
        return num;
    }


}
