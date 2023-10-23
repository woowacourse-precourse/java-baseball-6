package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터가 숫자 3개를 고른다.
        List<Integer> computer = chooseNumByComputer();

        while (true) {
            String userInputStr = getUserInputStr();

            // 유저의 입력이 숫자로만 이루어지지 않았을 경우 애플리케이션 종료
            if (!isUserInputValidate(userInputStr)) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    break;
                }
            }

            // 유저가 숫자 3개를 고른다.
            List<Integer> user = chooseNumByUser(userInputStr);

            System.out.println("computer = " + computer);
            System.out.println("user = " + user);

            System.out.println("countStrike(computer, user) = " + countStrike(computer, user));
            System.out.println("countBall(computer, user) = " + countBall(computer, user));
            
            // TODO 게임 종료 판단 기능 추가 시 삭제
            break;
        }
        System.out.println("숫자 야구 게임 애플리케이션을 종료합니다.");
    }

    /**
     * 컴퓨터와 유저의 숫자 리스트를 비교해 볼 수를 판별하여 반환한다.
     * 
     * @param computer 컴퓨터가 고른 숫자 리스트
     * @param user 유저가 고른 숫자 리스트
     * @return 카운트한  수
     */
    private static Integer countBall(List<Integer> computer, List<Integer> user){
        Integer result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if(user.contains(computer.get(i)) && user.indexOf(computer.get(i)) != i){
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
        while (computer.size() < 3) {
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
        System.out.println("숫자를 입력해주세요 : ");
        return scanner.next();
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
     * 유저가 입력한 문자열이 모두 숫자이면 true return
     *
     * @param userInput 유저가 입력한 문자열
     * @return 유저가 입력한 문자열이 모두 숫자이면 true 아니면 false
     */
    private static boolean isUserInputValidate(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) return false;
        }
        return true;
    }
}
