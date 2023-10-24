package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    static List<Integer> computer;

    public static void main(String[] args) {
        printStartMessage();
        int isPlay = 1;
        while (isPlay == 1) {
            playBaseball();
            isPlay = endGame();
        }
        System.out.println("게임이 종료되었습니다.");
    }

    /**
     * 숫자야구 한판을 진행하는 메서드
     */
    private static void playBaseball() {
        makeRandomNumber();
        boolean isFinish = false;
        int number = 0;
        while (!isFinish) {
            number = inputThreeNumber();
            isFinish =judgeStrikeAndBall(number);
        }
    }

    /**
     * 숫자야구를 종료할지, 계속할지를 결정하는 메서드
     */
    private static int endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        checkEndNumberIsValid(str);
        int endNumber = Integer.parseInt(str);
//        //종료
//        if (endNumber == 2) {
//            isPlay = 2;
//        }
//        //재시작
//        if (endNumber == 1) {
//            isFinish = false;
//        }
        return endNumber;
    }

    /**
     * 입력받은 값이 1과 2중 하나인지 판단하는 메서드
     *
     * @param str
     */
    private static void checkEndNumberIsValid(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("1과 2중 하나를 입력해야합니다.");
        }
        if (!str.equals("1") && !str.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 볼, 스트라이크를 판별하는 메서드
     *
     * @param number
     */
    private static boolean judgeStrikeAndBall(int number) {
        int strikeCnt = 0;
        int ballCnt = 0;
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < 3; i++) {
            char c = stringNumber.charAt(i);
            if (c == (computer.get(i) + '0')) {
                strikeCnt++;
            } else {
                if (computer.contains(c - '0')) {
                    ballCnt++;
                }
            }
        }
        //종료
        System.out.println(getJudgeMessage(strikeCnt, ballCnt));
        if(strikeCnt == 3) return true;
        return false;

    }

    /**
     * 볼과 스트라이크 개수마다 출력할 메세지를 결정하는 메서드
     *
     * @param strikeCnt
     * @param ballCnt
     * @return 출력할 메세지
     */
    private static String getJudgeMessage(int strikeCnt, int ballCnt) {
        StringBuilder sb = new StringBuilder();

        if (ballCnt > 0) {
            sb.append(ballCnt).append("볼");
        }
        if (strikeCnt > 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(strikeCnt).append("스트라이크");
        }

        if (strikeCnt == 3) {
            sb.append("\n").append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        if (sb.isEmpty()) {
            sb.append("낫싱");
        }
        return sb.toString();
    }

    /**
     * 사용자에게 3자리 숫자를 입력받는 메서드
     *
     * @return 입력받은 3자리 숫자
     */
    private static int inputThreeNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        checkTreeNumbersAreValid(str);
        return Integer.parseInt(str);
    }

    /**
     * 입력받은 값이 3자리 숫자가 맞는지 확인하는 메서드
     *
     * @param str
     */
    private static void checkTreeNumbersAreValid(String str) {
        //3자리를 입력했는지 확인.
        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
        try {
            int num = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        //중복제거
        Set<Character> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueNumbers.add(str.charAt(i));
        }
        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
        }

    }

    /**
     * 임의의 숫자 3개를 생성하는 메서드
     */
    private static void makeRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    /**
     * 시작 메세지를 출력함
     */
    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
