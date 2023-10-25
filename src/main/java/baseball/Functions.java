package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Functions {

    // 1부터 9까지 서로 다른 3자리 숫자 생성
    static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    // 유저 추측 (인풋 받기)
    static List<Integer> getUserGuess() {
        List<Integer> guess = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        // 입력 받기
        String input = Console.readLine();

        // 입력 값 검증
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (int i = 0; i < 3; i++) {
            guess.add(Character.getNumericValue(input.charAt(i)));
        }// guess에 i번째 문자를 정수로 변환하여 추가

        return guess;
    }

    //입력값 유효성 체크
    static boolean isValidInput(String input) {
        if (input.length() != 3) { // 입력값의 길이가 3인지 체크
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);// i번째 문자 확인
            if (!Character.isDigit(c) || c < '1' || c > '9') {
                return false; // 입력값이 숫자인지 체크 || c가 1보다 크고 9보다 작은지 체크
            }
            //중복여부 확인
            for (int j = i + 1; j < input.length(); j++) {
                if (c == input.charAt(j)) {
                    return false;  // 중복된 숫자가 있으면 false 반환
                }
            }
        }

        return true;
    }

    // 컴퓨터 숫자와 유저의 추측값을 비교하는 함수
    static int[] compareNumbers(List<Integer> computerNumber, List<Integer> userGuess) {
        int[] result = {0, 0};  // result[0]: 스트라이크 개수, result[1]: 볼 개수

        for (int i = 0; i < 3; i++) {
            if (userGuess.get(i).equals(computerNumber.get(i))) {
                // 숫자와 위치가 일치하면 스트라이크
                result[0]++;
            } else if (computerNumber.contains(userGuess.get(i))) {
                // 숫자만 일치하면 볼
                result[1]++;
            }
        }

        return result;
    }

    // 추측 결과 출력 함수
    static void printResult(int[] result) {
        if(result[1] == 0 && result[0] == 0){
            System.out.println("낫싱"); // 볼과 스트라이크가 없으면 낫싱 출력
        }
        else if(result[1] == 0){
            System.out.println(result[0] + "스트라이크");
        }
        else if(result[0] == 0){
            System.out.println(result[1] + "볼");
        }
        else{
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }

    }





    // 재시작 여부 판단하는 함수
    static int getRestartNum() {
        int restartNum;
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restartNum = Integer.parseInt(Console.readLine());

            if (restartNum != 1 && restartNum != 2) { // 1과 2가 아니면 에러출력
                throw new IllegalArgumentException("1 또는 2를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        return restartNum;
    }
}

