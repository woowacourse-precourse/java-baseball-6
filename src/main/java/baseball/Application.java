package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

            int[] computerNumbers = generateComputerNumbers();
            System.out.println(Arrays.toString(computerNumbers));

    }

    // 컴퓨터 랜덤 숫자 3개 생성
    private static int[] generateComputerNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int number;
            do {
                number = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, number));
            numbers[i] = number;
        }
        return numbers;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인
    private static boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    // 게임 진행
    // 사용자가 입력한 값 유효성 확인
    // 문자열 입력 값 -> 정수 배열로 변환
    // 스트라이크 수 계산
    // 볼 수 계산 (스트라이크 포함)
    // 결과 출력

}
