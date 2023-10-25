package baseball;

import baseball.feature.Confirm;
import baseball.feature.RandomNumberMaker;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        int restartToggle = 1;
        while (restartToggle == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 임의의 서로 다른 컴퓨터 숫자 3개 생성
            RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
            List<Integer> computerNums = randomNumberMaker.maker();

            // 문자열 리스트로 변환
            List<Integer> userNumbers;
            String result = "";
            // 볼, 스트라이크, 낫싱 판별
            Confirm baseballConfirm = new Confirm(computerNums);

            while (!result.equals("3스트라이크")) {
                // 입력, 문자열 리스트로 변환
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();

                // 사용자가 잘못된 값을 입력 했는지 확인
                checkValidity(inputNumber);

                userNumbers = makeUserNumber(inputNumber);

                baseballConfirm.takeNumbers(userNumbers);
                result = baseballConfirm.referee();
                System.out.println(result);

            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartInput = Console.readLine();

            // 사용자가 1,2가 아닌 잘못된 값을 입력 했는지 확인
            if (restartInput.equals("1") || restartInput.equals("2")) {
                restartToggle = Integer.parseInt(restartInput);
            } else {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요");
            }

        }


    }

    // 문자열을 int형 리스트로 변경하는 함수
    public static List<Integer> makeUserNumber(String userInput) {
        // 문자열의 각요소를 담을 리스트 생성
        List<Integer> UserNumbers = new ArrayList<>();
        // 문자열을 char 형 리스트로 만들고  char형 인자들을 int형으로 바꿈
        for (char numChar : userInput.toCharArray()) {
            UserNumbers.add(Character.getNumericValue(numChar));
        }

        return UserNumbers;
    }

    public static void checkValidity(String value) {
        //입력된 숫자가 3개인지 확인
        int valueSize = value.length();
        if (!(valueSize == 3)) {
            throw new IllegalArgumentException("3개의 수를 입력해 주세요");
        } else if (!isNumeric(value)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하지 마세요.");
        }
        //겹치는값이 없는지 확인
        Set<Character> charSet = new HashSet<>();
        for (char ch : value.toCharArray()) {
            // charSet에 이미 값이 있다면 서로다른 수가 아님
            if (charSet.contains(ch)) {
                throw new IllegalArgumentException("1~9까지의 서로 다른수 를 입력해주세요.");
            }
            charSet.add(ch);
        }
    }

    // 문자열이 숫자 형태인지 판별하는 메소드.
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
