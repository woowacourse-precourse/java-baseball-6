package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> userNumberSaved = new ArrayList<>();
    private static List<Integer> comNumberSaved = new ArrayList<>();

    private static List<Integer> stringToList(String number) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            String oneNum = number.substring(i, i + 1);
            Integer oneNumInt = Integer.parseInt(oneNum);
            ret.add(oneNumInt);
        }
        return ret;
    }

    private static void checkGameInputError(String input) throws IllegalArgumentException {
        boolean isException = false;

        if (input.length() != 3) {// 3자리 확인
            isException = true;
        } else {
            try {// 숫자형식으로 변환 시 예외발생 확인
                Integer.decode(input);
            } catch (NumberFormatException e) {
                isException = true;
            }

            for (byte oneNumChar : input.getBytes()) {// 1~9 확인
                if (oneNumChar < '1' || oneNumChar > '9') {
                    isException = true;
                    break;
                }
            }

            for (String oneNum : input.split("")) {// 숫자 중복 확인
                String inputErased = input.replaceFirst(oneNum, "");
                if (inputErased.contains(oneNum)) {
                    isException = true;
                    break;
                }
            }
        }
        if (isException) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkRestartInputError(String input) throws IllegalArgumentException {
        List<String> correctAnswer = List.of("1", "2");
        if (correctAnswer.contains(input) == false) {
            throw new IllegalArgumentException();
        }
    }

    private static void getUserNumber() {// 사용자의 입력을 List<Integer>으로 저장
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        checkGameInputError(userInput);
        userNumberSaved = stringToList(userInput);
    }

    private static void getComNumber() {// 컴퓨터의 입력을 List<Integer>으로 저장
        while (comNumberSaved.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumberSaved.contains(randomNumber)) {
                comNumberSaved.add(randomNumber);
            }
        }
    }

    private static int strikeCount() {// 스트라이크 개수 확인
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            Integer user = userNumberSaved.get(i);
            Integer com = comNumberSaved.get(i);
            if (user == com) {
                ret++;
            }
        }
        return ret;
    }

    private static int ballCount() {// 볼 개수 확인
        int ret = 0;
        for (Integer user : userNumberSaved) {
            for (Integer com : comNumberSaved) {
                if (user == com) {
                    ret++;
                }
            }
        }
        ret -= strikeCount();
        return ret;
    }

    private static boolean isNothing() { // 스트라이크, 볼의 결과값으로 낫싱 확인
        boolean ret = false;
        if (strikeCount() == 0 && ballCount() == 0) {
            ret = true;
        }
        return ret;
    }

    private static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static int printResult() { // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
        int ballCount = ballCount();
        int strikeCount = strikeCount();
        if (ballCount > 0) {
            System.out.print(ballCount + "볼");
        }
        if (strikeCount > 0) {
            if (ballCount > 0) {
                System.out.print(" ");
            }
            System.out.print(strikeCount + "스트라이크");
        } else if (isNothing()) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return strikeCount;
    }

    private static void printRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean askContinue() {// 재시작여부 입력 받기
        boolean ret = false;
        String userInput = Console.readLine();
        checkRestartInputError(userInput);
        if (userInput.compareTo("1") == 0) {
            ret = true;
        } else if (userInput.compareTo("2") == 0) {
            ret = false;
        }
        return ret;
    }

    private static void initNumberSaved() {
        userNumberSaved = new ArrayList<>();
        comNumberSaved = new ArrayList<>();
    }

    private static void game() {// 게임 진행
        printStart();
        boolean continueGame = true;
        getComNumber();
        while (continueGame) {
            getUserNumber();
            int result = printResult();
            if (result == 3) {
                printRestart();
                continueGame = askContinue();
                if (continueGame) {
                    initNumberSaved();
                    getComNumber();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            game();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
