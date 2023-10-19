package baseball;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static boolean successFlag = false;

    public static void main(String[] args) {
        startGame();
        int answerNumber = generateAnswerNumber();
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
            printHint(number, answerNumber);
        }
    }

    private static void startGame() {
        // 게임 시작 멘트 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 입력 숫자와 정답 숫자를 비교하여 숫자 야구 힌트를 준다.
     * @param inputNumber 서로 다른 1~9 숫자로 구성된 세자리 수, 입력 숫자
     * @param answerNumber 서로 다른 1~9 숫자로 구성된 세자리 수, 정답 숫자
     */
    private static void printHint(int inputNumber, int answerNumber) {
        // number에 대한 힌트 출력

        // 3스트라이크
        if (inputNumber - answerNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            successFlag = true;
            return;
        }

        String[] inputArray = String.valueOf(inputNumber).split("");
        String[] answerArray = String.valueOf(answerNumber).split("");
        // 스트라이크 개수 세기
        int strike = 0;
        for (int idx=0; idx<3; idx++){
            if (inputArray[idx].equals(answerArray[idx])) {
                strike++;
            }
        }

        // 볼 개수 세기
        int ball = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i == j){
                    continue;
                }
                if (inputArray[i] == answerArray[j]) {
                    ball++;
                }
            }
        }

        // 결과 출력
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        return;
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
        // 사용자 인풋에 동일 숫자 존재시 예외 발생
        if (isDuplicated(inputString)) {
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
        if (option == 1) {
            return true;
        }
        if (option == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    // 사용자 입력 문자열로부터 옵션 선택 번호 검증
    private static int getOptionNumber(String inputString) {
        if(!inputString.equals("1") && !inputString.equals("2")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    public static int generateAnswerNumber() {
        // 정답 번호 생성하기 (서로 다른 세 자리의 숫자로 구성)
        // 생성한 세 자리 양수를 리턴
        int pickedNumber = 0;
        while(true) {
            pickedNumber = pickNumberInRange(111, 999);

            String numberString = String.valueOf(pickedNumber);
            // 0을 포함하면 다시 뽑기
            if (numberString.contains("0")){
                continue;
            }
            if (isDuplicated(numberString)) {
                continue;
            }
            // 다시 뽑기 조건에 해당하지 않는 경우, while문을 벗어난다.
            break;
        }
        return pickedNumber;
    }

    private static boolean isDuplicated(String numberString) {
        // 중복 숫자가 존재하면 다시 뽑기
        int[] numberCount = new int[10];
        boolean stopFlag = false;
        for (int idx = 0; idx< numberString.length(); idx++) {
            int element = numberString.charAt(idx) - '0';
            if (++numberCount[element] >= 2) {
                stopFlag = true;
                break;
            };
        }
        return stopFlag;
    }
}
