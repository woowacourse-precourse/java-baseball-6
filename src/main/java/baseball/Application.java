package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 숫자 생성
        List<Integer> computer = createComputerNumberList();

        // 사용자 입력 값 숫자 리스트로 변환
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> user = getThreeNumbersFromString(userInput);

        // 컴퓨터와 사용자의 숫자 비교
        ComparisonResult result = CompareNumberList(computer, user);
        System.out.println(result);
        System.out.println("컴퓨터 숫자 리스트: " +
                computer.stream().map(Object::toString).collect(Collectors.joining()));
    }

    /**
     * 컴퓨터가 3자리의 수를 만들 때 사용 됩니다.
     * @return 1부터 9까지 서로 다른 수 3개가 담긴 리스트
     */
    public static List<Integer> createComputerNumberList() {
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
     * 숫자로 이루어진 문자열을 정수 리스트로 변환해 줍니다.
     * @param numbersStr 숫자 3개가 이루어진 문자열
     * @return 1부터 9까지의 서로 다른 수 3개가 담긴 리스트
     * @throws IllegalArgumentException
     *         입력된 문자열 길이가 3이 아닐 경우,
     *         숫자가 1부터 9까지가 아닐 경우,
     *         중복된 숫자가 존재할 경우
     */
    public static List<Integer> getThreeNumbersFromString(String numbersStr) {
        if (numbersStr.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        for (char numberChar:numbersStr.toCharArray()) {
            if (numberChar < '1' || numberChar > '9') {
                throw new IllegalArgumentException();
            }
            int number = numberChar - '1' + 1;
            if (result.contains(number)) {
                throw new IllegalArgumentException();
            }
            result.add(number);
        }
        return result;
    }

    /**
     * 두 리스트를 비교하여 볼과 스트라이크의 개수를 찾아냅니다.
     * @param computer 컴퓨터의 숫자 리스트
     * @param user 유저의 숫자 리스트
     * @return 볼과 스트라이크 개수를 포함한 결과
     */
    public static ComparisonResult CompareNumberList(List<Integer> computer, List<Integer> user) {
        if (computer.size() != 3 || user.size() != 3) {
            throw new IllegalArgumentException();
        }
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).intValue() == computer.get(i).intValue()) {
                strike++;
            }
            else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        return new ComparisonResult(ball, strike);
    }
}
