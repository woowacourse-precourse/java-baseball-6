package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class Application {
    private final static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final static String GAME_END ="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String CHOOSE_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String NOTHING = "낫싱";
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";

    private static void checkUserNum(String user) {
        if (user.length() != 3 || user.chars().distinct().count() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> calculateStrikeBall(String userNum, List<Integer> computerNum){
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++) {
            int userDigit = Character.getNumericValue(userNum.charAt(i));
            int computerDigit = computerNum.get(i);

            if (userDigit == computerDigit) {
                strike++;
            } else if (computerNum.contains(userDigit)) {
                ball++;
            }
        }

        result.add(strike);
        result.add(ball);

        return result;
    }

    private static String makeAnswer(int strike, int ball) {
        String answer = "";
        if (strike == 0 && ball == 0) {
            answer = NOTHING;
        } else {
            if (ball > 0) {
                answer += ball+BALL+" ";
            }
            if (strike > 0) {
                answer += strike+STRIKE;
            }
        }

        return answer;
    }

    private static void gameStart(int replay) {
        List<Integer> computer;

        while (replay == 1) {
            computer = makeComputerNum();
            replay = baseballGame(computer);
        }
    }

    private static int isReplay() {
        System.out.println(GAME_END+'\n'+CHOOSE_REPLAY);

        return Integer.parseInt(Console.readLine());                            // = replay
    }

    private static int baseballGame(List<Integer> computerNum) {

        System.out.print(INPUT_NUMBER);
        String userNum = Console.readLine();

        checkUserNum(userNum);

        List<Integer> result = calculateStrikeBall(userNum, computerNum);
        int strike = result.get(0);
        int ball = result.get(1);

        String answer = makeAnswer(strike, ball);
        System.out.println(answer);

        if (strike != 3) {
            return baseballGame(computerNum);
        } else {
            return isReplay();
        }
    }

    private static List<Integer> makeComputerNum() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
    public static void main(String[] args) {
        int replay = 1;
        System.out.println(GAME_START);
        gameStart(replay);
    }
}

