package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void gameStart() {
        String selectInput = "";
        while (!selectInput.equals("2")) {

            System.out.println("숫자 야구 게임을 시작합니다.");

            // 랜덤 숫자 뽑기
            List<Character> randomNumberList = setRandomNumber();

            // 게임 로직
            gameLogic(randomNumberList);

            // 재시작 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selectInput = Console.readLine();
        }
        System.out.println("게임을 종료합니다.");
    }

    public static List<Character> setRandomNumber() {
        List<Character> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

    public static void gameLogic(List<Character> randomNumberList) {
        while (true) {

            // 사용자 입력 받기
            StringBuilder inputStringBuilder = getInput();

            // 입력값 검증
            numberValidation(inputStringBuilder);

            // 입력값 기반으로 스트라이크 개수 세기
            int strikeCount = getStrikeCount(randomNumberList, inputStringBuilder);

            // 입력값 기반으로 볼 개수 세기
            int ballCount = getBallCount(randomNumberList, inputStringBuilder);

            // 스트라이크 개수, 볼 개수 결과에 따른 문장 출력
            System.out.println(getResult(strikeCount, ballCount));

            if (strikeCount == 3) {
                break;
            }
        }
    }

    public static StringBuilder getInput() {
        // 사용자 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        StringBuilder inputStringBuilder = new StringBuilder(Console.readLine());
        return inputStringBuilder;
    }

    public static void numberValidation(StringBuilder inputStringBuilder) {
        // 문자열 길이가 3인지 검증
        if (inputStringBuilder.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 문자열 첫 글자가 0인지 검증
        if (inputStringBuilder.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }
    }

    public static int getStrikeCount(List<Character> randomNumberList, StringBuilder inputStringBuilder) {
        int strikeCount = 0;
        for (int i = 0; i < randomNumberList.size(); i++) {
            if (inputStringBuilder.charAt(i) == randomNumberList.get(i)) {
                strikeCount++;
                inputStringBuilder.replace(i, i + 1, "s");
                continue;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(List<Character> randomNumberList, StringBuilder inputStringBuilder) {
        int ballCount = 0;
        for (int i = 0; i < inputStringBuilder.length(); i++) {
            if (inputStringBuilder.charAt(i) == 's') {
                continue;
            }
            for (int j = 0; j < randomNumberList.size(); j++) {
                if (inputStringBuilder.charAt(j) == 's' || inputStringBuilder.charAt(j) == 'b') {
                    continue;
                }
                if (inputStringBuilder.charAt(i) == randomNumberList.get(j)) {
                    ballCount++;
                    String changeChar = inputStringBuilder.substring(j, j + 1);
                    inputStringBuilder.replace(i, i + 1, changeChar);
                    inputStringBuilder.replace(j, j + 1, "b");
                    continue;
                }
            }
        }
        return ballCount;
    }

    public static String getResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + "볼";
        }
        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        return null;
    }

    public static void main(String[] args) {
        gameStart();
    }
}
