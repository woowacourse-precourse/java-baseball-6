package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>(); // 정답
        String strInput;    // String 형식 유저 값
        List<Integer> intInput = new ArrayList<>(); // int List 형식의 유저 값

        MainLoop:
        while (true) {
            makeRandomList(computer);   // 랜덤한 서로 다른 세 자리 수 생성
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                strInput = Console.readLine();  // 입력값

                checkInputLength(strInput, 3);  // 자릿수 검사
                checkInputRange(strInput, '0', '9');    // 값 범위 검사
                checkSameValue(strInput);   // 같은 값 존재 검사

                strToIntList(intInput, strInput);   // int 로 변환 저장

                int[] result = getResult(computer, intInput);   // {스트라이크, 볼, 낫싱}
                printResult(result);    // 결과 출력

                if (result[0] == 3) {   // 3스트라이크, 종료 분기
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String checkEnd = Console.readLine();

                    checkInputLength(checkEnd, 1);  // 자릿수 검사
                    checkInputRange(checkEnd, '1', '2');    // 값 범위 검사

                    if (checkEnd.charAt(0) == '1') {    // 재시작
                        break;
                    }
                    if (checkEnd.charAt(0) == '2') {    // 종료
                        break MainLoop;
                    }
                }
            }
        }
        Console.close();
    }

    private static void makeRandomList(List list) { // 랜덤한 서로 다른 세 자리 수 생성
        list.clear();   // 배열 초기화
        while (list.size() < 3) {   // 서로 다른 숫자 세 개 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
    }

    private static void checkInputLength(String input, int length) { // 자릿수 검사
        if (input.length() != length) {  // 자릿수가 맞지 않은 경우
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputRange(String input, char start, char end) { // 값 범위 검사
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < start || input.charAt(i) > end) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkSameValue(String input) { // 같은 값 존재 검사
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static void strToIntList(List list, String origin) {    // 입력받은 str을 int list 로 변환
        list.clear();   // 배열 초기화
        for (int i = 0; i < origin.length(); i++) {
            list.add(Character.getNumericValue(origin.charAt(i)));
        }
    }

    private static int[] getResult(List computer, List user) {
        int[] res = {0, 0, 3};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i) == user.get(j)) {    // 숫자가 같을 때
                    if (i == j) {   // 자리도 같을 때
                        res[0]++;
                    } else {        // 자리가 다를 때
                        res[1]++;
                    }
                }
            }
        }
        res[2] -= res[0] + res[1];

        return res;
    }

    private static void printResult(int[] result) {  // 결과 출력 메소드
        if (result[2] == 3) {
            System.out.println("낫싱");
            return;
        }
        if (result[1] != 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] != 0) {
            System.out.print(result[0] + "스트라이크");
        }
        System.out.println();
    }
}
