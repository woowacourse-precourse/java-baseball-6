package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final static Integer numberCount = 3;
    private static Boolean isApplicationEnd = false;

    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            // 컴퓨터가 숫자 3개를 고른다.
            List<Integer> computer = chooseNumByComputer();

            while (true) {
                String userInputStr = getUserInputStr();
                System.out.println("userInputStr = " + userInputStr);

                // 유저의 입력이 올바르지 않을 경우 애플리케이션 종료
                if (!isUserInputValidate(userInputStr)) {
                    isApplicationEnd = true;
                    throw new IllegalArgumentException();
                }

                // 유저가 숫자 3개를 고른다.
                List<Integer> user = chooseNumByUser(userInputStr);

                Integer strikeCount = countStrike(computer, user);
                Integer ballCount = countBall(computer, user);

                // 이번 라운드 게임 결과 출력
                printRoundResult(strikeCount, ballCount);

                // 숫자를 3개 모두 맞혔을 경우 게임 종료
                if (strikeCount.equals(3)) {
                    printGameOverMessage();
                    if (restartOrFinish().equals("2")) {
                        isApplicationEnd = true;
                    }
                    break;
                }
            }
        } while (!isApplicationEnd);

        System.out.println("숫자 야구 게임 애플리케이션을 종료합니다.");
    }

    /**
     * 스트라이크 갯수와 볼 갯수를 출력한다.
     *
     * @param strikeCount 스트라이크 갯수
     * @param ballCount 볼 갯수
     */
    private static void printRoundResult(Integer strikeCount, Integer ballCount){
        if (ballCount > 0){
            System.out.print(ballCount.toString() + "볼 ");
        }
        if(strikeCount > 0){
            System.out.print(strikeCount.toString() + "스트라이크");
        }
        if(ballCount == 0 && strikeCount == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }

    /**
     * 게임 종료 문구를 출력한다.
     */
    private static void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 게임을 재시작할 지, 종료할 지 유저의 입력을 받는다.
     * 1. 재시작
     * 2. 종료
     *
     * @return 유저의 선택(번호)
     */
    private static String restartOrFinish() {
        String result;
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            result = Console.readLine();

            if(result.equals("1") || result.equals("2")) break;
            System.out.print("잘못 입력하셨습니다. 다시 입력해주세요. ");
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
            if (computer.get(i).equals(user.get(i))) result++;
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

    /**
     * 유저로부터 문자열을 입력받아 반환한다.
     *
     * @return 유저가 입력한 문자열
     */
    private static String getUserInputStr() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 문자열에 들어있는 숫자를 뽑아 숫자 리스트 형태로 변환하여 반환한다.
     *
     * @param userInput 유저가 입력한 문자열
     * @return 변환된 숫자 List
     */
    private static List<Integer> chooseNumByUser(String userInput) {
        List<Integer> num = new ArrayList<>();
        // 유저의 입력을 숫자 리스트로 변환
        for (int i = 0; i < userInput.length(); i++) {
            num.add(userInput.charAt(i) - '0');
        }
        return num;
    }

    /**
     * 유저가 입력한 문자열이 올바르면 true return
     *
     * @param userInput 유저가 입력한 문자열
     * @return 유저가 입력한 문자열이 올바르면 true 아니면 false
     */
    private static boolean isUserInputValidate(String userInput) {
        return (isUserInputAllNumbers(userInput) && userInput.length() == numberCount);
    }

    /**
     * 유저가 입력한 문장열이 모두 숫자로 이루어졌으면 true return
     *
     * @param userInput 유저가 입력한 문자열
     * @return 유저가 입력한 문자열이 모두 숫자이면 true 아니면 false
     */
    private static boolean isUserInputAllNumbers(String userInput){
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) return false;
        }
        return true;
    }
}
