package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public final static Integer numberCount = 3;
    private static Boolean isApplicationEnd = false;

    public static void main(String[] args) {
        System.out.println(MessageConstant.gameStartMsg);
        do {
            // 컴퓨터가 숫자 3개를 고른다.
            List<Integer> computer = chooseNumByComputer();

            // 게임 라운드 진행
            playGameRound(computer);
        } while (!isApplicationEnd);

        System.out.println(MessageConstant.gameApplicationFinishMsg);
    }

    /**
     * 유저가 정답을 맞출때까지 게임 라운드를 진행한다.
     *
     * @param computer 현재 게임의 정답 (숫자 리스트)
     */
    private static void playGameRound(List<Integer> computer) {
        while (true) {
            // 유저로부터 숫자 3개를 입력받는다.
            // 유저의 입력이 올바르지 않을 경우 애플리케이션 종료
            if (!User.inputAnswerStr()) {
                isApplicationEnd = true;
                throw new IllegalArgumentException();
            }

            if (isAnwerCorrect(computer)) {
                break;
            }
        }
    }

    private static boolean isAnwerCorrect(List<Integer> computer) {
        if (printRoundResult(computer, User.getNumberList())) {
            printGameOverMessage();
            if (isUserWantFinish()) {
                isApplicationEnd = true;
            }
            return true;
        }
        return false;
    }

    /**
     * 유저가 게임 종료를 원하면 true return
     *
     * @return 게임 종료 의사 여부
     */
    private static boolean isUserWantFinish() {
        return (restartOrFinish().equals("2"));
    }

    /**
     * 스트라이크 갯수와 볼 갯수를 출력하고 정답을 맞췄으면 true를 return
     *
     * @param computer 컴퓨터가 고른 숫자 리스트
     * @param user     사용자가 고른 숫자 리스트
     * @return 정답을 맞췄을 경우 true 아니면 false
     */
    private static boolean printRoundResult(List<Integer> computer, List<Integer> user) {
        Integer strikeCount = countStrike(computer, user);
        Integer ballCount = countBall(computer, user);

        if (ballCount > 0) {
            System.out.print(ballCount.toString() + MessageConstant.ballResultMsg);
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount.toString() + MessageConstant.strikeResultMsg);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(MessageConstant.nothingResultMsg);
        }
        System.out.println();

        return (strikeCount.equals(numberCount));
    }

    /**
     * 게임 종료 문구를 출력한다.
     */
    private static void printGameOverMessage() {
        System.out.println(MessageConstant.gameEndMsg);
    }

    /**
     * 게임을 재시작할 지, 종료할 지 유저의 입력을 받는다. 1. 재시작 2. 종료
     *
     * @return 유저의 선택(번호)
     */
    private static String restartOrFinish() {
        String result;
        while (true) {
            System.out.println(MessageConstant.gameRestartOrFinishMsg);
            result = Console.readLine();

            if (result.equals("1") || result.equals("2")) {
                break;
            }
            System.out.print(MessageConstant.invalidInputMsg);
        }
        return result;
    }


    /**
     * 컴퓨터와 유저의 숫자 리스트를 비교해 볼 수를 판별하여 반환한다.
     *
     * @param computer 컴퓨터가 고른 숫자 리스트
     * @param user     유저가 고른 숫자 리스트
     * @return 카운트한  수
     */
    private static Integer countBall(List<Integer> computer, List<Integer> user) {
        Integer result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (user.contains(computer.get(i)) && user.indexOf(computer.get(i)) != i) {
                result++;
            }
        }
        return result;
    }

    /**
     * 컴퓨터와 유저의 숫자 리스트를 비교해 스트라이크 수를 판별하여 반환한다.
     *
     * @param computer 컴퓨터가 고른 숫자 리스트
     * @param user     유저가 고른 숫자 리스트
     * @return 카운트한 스트라이크 수
     */
    private static Integer countStrike(List<Integer> computer, List<Integer> user) {
        Integer result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                result++;
            }
        }
        return result;
    }

    /**
     * 랜덤한 숫자 3개를 골라 리스트로 반환한다.
     *
     * @return 숫자 3개가 원소로 들어있는 List
     */
    private static List<Integer> chooseNumByComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberCount) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
