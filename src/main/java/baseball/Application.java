package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainLoop:
        while (true) {  // 정답 후 종료 입력까지 반복
            List<Integer> computer = new ArrayList<>();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (computer.size() < 3) {   // 서로 다른 숫자 세 개 생성
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();  // 입력값

                if (checkInput(input)) {    // 입력값 검수
                    throw new IllegalArgumentException();
                }

                List<Integer> user = new ArrayList<>(); // 유저 입력 값 배열화
                for (int i = 0; i < input.length(); i++) {
                    user.add(Character.getNumericValue(input.charAt(i)));
                }

                int[] result = getResult(computer, user);   // 결과 : 스트라이크 볼 낫싱

                if (result[2] == 3) {   // 0개 맞춤
                    System.out.println("낫싱");
                } else {
                    if (result[1] != 0) {
                        System.out.print(result[1] + "볼 ");
                    }
                    if (result[0] != 0) {
                        System.out.print(result[0] + "스트라이크");
                    }
                    System.out.println();

                    if (result[0] == 3) {   // 정답 맞춘 경우
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        String checkEnd = Console.readLine();
                        if (checkEnd.length() > 1) {
                            throw new IllegalArgumentException();
                        } else if (checkEnd.charAt(0) == '2') {  // 종료
                            Console.close();
                            break MainLoop;
                        } else if (checkEnd.charAt(0) == '1') { // 재시작
                            break;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }
    }

    private static boolean checkInput(String str) { // 입력값 검수
        if (str.length() != 3) {    // 자릿수 검수
            return true;
        }
        for (int i = 0; i < 3; i++) {   // 숫자가 맞는지 검수
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return true;
            }
        }
        if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || // 서로 다른지 검수
                str.charAt(1) == str.charAt(2)) {
            return true;
        }

        return false;
    }

    private static int[] getResult(List com, List user) {
        int[] res = {0, 0, 3};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (com.get(i) == user.get(j)) {    // 숫자가 같을 때
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
}
