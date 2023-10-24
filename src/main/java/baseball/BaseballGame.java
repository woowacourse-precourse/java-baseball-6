package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame implements Game{
    private final int answerNumber = generateAnswerNumber();

    public BaseballGame() {
    }

    /**
     * 컴퓨터가 정답 번호를 생성한다.
     *
     * @return 중복 숫자가 없는 세자리 정수
     */
    private int generateAnswerNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3){
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(pickedNumber)) {
                computer.add(pickedNumber);
                sb.append(pickedNumber);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    @Override
    public void startAnnounce(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 게임 한판이 끝날 때까지 수행한다.
     *
     * @return 게임 리플레이 여부의 true / false
     */
    @Override
    public boolean playGame() {
        while(true) {
            // 1. 입력 받기
            int number = inputNumber();
            // 2. 결과 확인하기
            boolean success = getResult(number, answerNumber);
            // 3. 게임 승리시 리플레이 여부 반환
            if (success) {
                return isContinue();
            }
        }
    }

    /**
     * 사용자에게 리플레이 옵션을 선택하게 한다.
     *
     * @return 리플레이 여부의 true / false
     */
    private boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if (inputString.equals("1")) {
            return true;
        }
        if (inputString.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }


    /**
     * 입력 숫자와 정답 숫자를 비교하여 숫자 야구 힌트를 준다.
     *
     * @param inputNumber 서로 다른 1~9 숫자로 구성된 세자리 수
     * @param answerNumber 서로 다른 1~9 숫자로 구성된 세자리 수
     * @return 성공 여부의 true / false
     */
    private boolean getResult(int inputNumber, int answerNumber) {
        if (inputNumber - answerNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        String[] inputArray = String.valueOf(inputNumber).split("");
        String[] answerArray = String.valueOf(answerNumber).split("");
        int strike = countStrike(inputArray, answerArray);
        int ball = countBall(inputArray, answerArray);

        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }

        return false;
    }

    private int countStrike(String[] inputArray, String[] answerArray) {
        int strike = 0;
        for (int idx=0; idx<3; idx++){
            if (inputArray[idx].equals(answerArray[idx])) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(String[] inputArray, String[] answerArray) {
        int ball = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i == j){
                    continue;
                }
                if (inputArray[i].equals(answerArray[j])) {
                    ball++;
                }
            }
        }
        return ball;
    }

    /**
     * 사용자로부터 올바른 숫자를 입력받는다.
     *
     * @return 검증 완료된 세자리 정수
     */
    private int inputNumber() {
        // 사용자로부터 올바른 숫자 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        return checkInputNumber(inputString);
    }

    /**
     * 사용자의 숫자 인풋값의 유효성을 검증한다.
     *
     * @param inputString 사용자가 입력한 숫자 문자열
     * @return 사용자 입력 문자열을 int로 파싱한 값
     */
    private int checkInputNumber(String inputString) {
        int number;
        try {
            // 검증1: int로 파싱 가능해야 한다.
            number = parseNumber(inputString);
            // 검증1: 사용자 인풋이 3자리여야 한다.
            checkInputLength(inputString);
            // 검증2: "0"이 포함되지 않아야 한다.
            checkInvalidNumber(inputString);
            // 검증3: 동일 숫자 존재하지 않아야 한다.
            checkDuplicated(inputString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("[숫자 입력 오류] %s", e.getMessage()));
        }
        return number;
    }

    /**
     * 사용자 입력 검증 1 - 사용자는 숫자만 입력해야 한다.
     *
     * @param inputString 사용자가 입력한 숫자 문자열
     * @return 숫자 문자열을 int로 파싱한 결과값
     * @throws IllegalArgumentException if 문자열의 int 파싱이 불가능
     */
    private int parseNumber(String inputString) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(inputString);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
        return number;
    }

    /**
     * 사용자 입력 검증 2 - 사용자 입력 문자열은 길이가 3이어야 한다.
     *
     * @param inputString 사용자가 입력한 문자열
     * @throws IllegalArgumentException if 문자열 길이가 3이 아님
     */
    private void checkInputLength(String inputString) throws IllegalArgumentException {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 사용자 입력 검증 3 - 사용자 입력 문자열에 0이 포함되지 않아야 한다.
     *
     * @param inputString 사용자가 입력한 문자열
     * @throws IllegalArgumentException if 문자열에 0이 포함됨
     */
    private void checkInvalidNumber(String inputString) throws IllegalArgumentException {
        if (inputString.contains("0")){
            throw new IllegalArgumentException("0은 포함할 수 없습니다.");
        }
    }

    /**
     * 사용자 입력 검증 4 - 사용자가 입력한 숫자 문자열은 중복된 숫자를 가지면 안 된다.
     *
     * @param numberString 사용자가 입력한 숫자 문자열
     * @throws IllegalArgumentException if 중복 숫자가 존재함
     */
    private void checkDuplicated(String numberString) throws IllegalArgumentException {
        Set<Character> numberSet = new HashSet<>();
        for (char uniqueNumber : numberString.toCharArray()){
            if(!numberSet.add(uniqueNumber)){
                throw new IllegalArgumentException("중복 숫자를 입력하면 안 됩니다.");
            }
        }
    }
}
