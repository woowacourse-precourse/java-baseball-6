package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        [] 게임 시작 문구 출력
//        [] 서로 다른 세 자리의 수 생성
//        [] 세 자리 수 입력받기
//        [] 잘못된 값이 입력됐는지 확인하기
//        [] 결과(스트라이크, 볼, 낫싱) 계산
//        [] 계산 결과 출력
//        [] (게임 종료시) 게임 종료 문구 출력
//        [] (게임 종료시) 재시작/종료를 구분하는 수(1또는 2) 입력받기

    }
}

class Computer {

    private List<Integer> number;

    public Computer() {
        this.number = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getNumber() {
        return number;
    }
}

class User {

    private int number;

    public User() {
        this.number = userInput();
    }

    private int userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public static boolean isValidGuess(int input) {
        List<Integer> digits = new ArrayList<>();
        digits.add(input / 100); // 100의자리
        digits.add((input % 100) / 10); // 10의자리
        digits.add(input % 10); // 1의자리

        return digits.stream().distinct().count() == 3; // digits 안의 수가 서로 다른 세 수인지 확인
    }
}

