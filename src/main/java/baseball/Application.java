package baseball;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        startGame();

        int answerNumber = generateAnswerNumber();
        boolean successFlag = false;
        while(true) {
            // 성공했을 경우 게임 지속 여부 선택하기
            if (successFlag) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String inputString = readLine();
                int option = getOptionNumber(inputString);
                if (isContinue(option)){
                    answerNumber = generateAnswerNumber();
                    successFlag = false;
                } else {
                    break;
                }
            }

            // 큰 게임 진행은 아래 두 단계로 구성됨
            int number = inputNumber();
            printHint(number);
        }
    }

    private static void startGame() {
        // 게임 시작 멘트 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printHint(int number) {
        // number에 대한 힌트 출력
    }

    private static int inputNumber() {
        // 사용자로부터 숫자 입력 받기
        // checkNumber()으로 검증
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = readLine();
        return checkNumber(inputString);
    }

    private static int checkNumber(String inputString) {
        int number;
        // 사용자 인풋이 3자리가 아니면 예외 발생
        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 사용자 인풋에 "0"이 포함되면 예외 발생
        if (inputString.contains("0")) {
            throw new IllegalArgumentException();
        }
        // int로 파싱 불가능하면 예외 발생
        try {
            number = Integer.parseInt(inputString);
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
        return number;
    }


    private static boolean isContinue(int option) {
        // option값 유효성 검증 후,
        // option이 1이면 true, 2이면 false 리턴
        return true;
    }

    private static int getOptionNumber(String inputString) {
        // 사용자 입력 문자열로부터 옵션 선택 번호 검증
        // 올바르지 않으면 IllegalArgumentException
        return 0;
    }

    public static int generateAnswerNumber() {
        // 정답 번호 생성하기 (서로 다른 세 자리의 숫자로 구성)
        // 생성한 세 자리 양수를 리턴
        return 0;
    }
}
