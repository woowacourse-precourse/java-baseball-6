package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public static void play() { // 0. 게임을 실행하는 메서드
        String[] inputNums;
        List<Integer> answerNums;
        answerNums = pickThreeNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            inputNums = inputThreeNums();
            String result = countStrikeOrBall(inputNums, answerNums);
            if (result == "3스트라이크") {
                System.out.println(result);
                replayOrExit();
                break;
            } else {
                System.out.println(result);
            }
        }
    }

    public static List<Integer> pickThreeNumbers() { // 1. 컴퓨터가 가질 3개의 값을 초기화하는 메서드
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }

    public static String[] inputThreeNums() { // 3. 사용자로부터 숫자 3개를 입력받는 메서드
        String inputNums;
        String[] listedInputNums;
        System.out.println("숫자를 입력해주세요 : ");
        inputNums = Console.readLine();
        // 7. 사용자가 3개의 숫자만 입력해야 하는데 4개의 수를 입력했을 때
        if (inputNums.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        // 8. 사용자가 1~9사이의 숫자만 입력하지 않고, 0을 입력했을 때
        if (inputNums.contains("0")) {
            throw new IllegalArgumentException("1~9사이의 숫자를 입력해야 합니다.");
        }
        listedInputNums = inputNums.split("");
        return listedInputNums;
    }

//    public static String[] stringToArray(String inputString) { // 7. 사용자가 입력한 3개의 숫자를 배열로 변환하는 메서드
//         = inputString.split("");
//        return listedInputNums;
//    }

    public static void replayOrExit() { // 4. 게임 재시작 여부를 결정할 숫자를 입력받을 메서드
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String decide = Console.readLine();
        int number = Integer.parseInt(decide);

        if (number == 1) {
            play();
        } else if (number == 2) {
            return;
        } else {
            throw new IllegalArgumentException("Invalid input value : " + decide);
        }
    }

    public static String countStrikeOrBall(String[] playerNums,
                                           List<Integer> computerNums) { // 5. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 출력하는 메서드
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < playerNums.length; i++) {
            Integer num = Integer.parseInt(playerNums[i]);
            if (computerNums.contains(num)) {
                if (computerNums.get(i) == num) {
                    strike += 1;
                } else {
                    ball += 1;
                }
            }
        }

        if (strike == 3) {
            return "3스트라이크";
        } else if (strike == 2 && ball == 0) {
            return "2스트라이크";
        } else if (strike == 2 && ball == 1) {
            return "1볼 2스트라이크";
        } else if (strike == 1 && ball == 2) {
            return "2볼 1스트라이크";
        } else if (strike == 1 && ball == 1) {
            return "1볼 1스트라이크";
        } else if (strike == 1 && ball == 0) {
            return "1스트라이크";
        } else if (strike == 0 && ball == 3) {
            return "3볼";
        } else if (strike == 0 && ball == 2) {
            return "2볼";
        } else if (strike == 0 && ball == 1) {
            return "1볼";
        } else {
            return "낫싱";
        }
    }

}
