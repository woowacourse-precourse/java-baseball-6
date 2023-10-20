package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        String computerStr = makeRandomString();

        while (true) {
            int strikes = 0; // 스트라이크 개수 초기화
            int balls = 0; // 볼 개수 초기화

            System.out.print("숫자를 입력하세요 : ");
            var readData = Console.readLine();

            if (isUniqueThreeDigit(readData)) {

                for (int i = 0; i < 3; i++) {
                    var readChar = readData.charAt(i);

                    for (int j = 0; j < 3; j++) {
                        var computerChar = computerStr.charAt(j);

                        if (readChar == computerChar) { // 같은 숫자인 경우
                            if (i == j) {
                                strikes++; // 같은 자리에 같은 숫자면 스트라이크 증가
                            } else {
                                balls++; // 다른 자리에 같은 숫자면 볼 증가
                            }
                        }
                    }
                }

                // 둘 다 있는 경우
                if (strikes > 0 && balls > 0) {
                    System.out.println(String.format("%d볼 %d스트라이크", balls, strikes));
                }
                // 볼만 있는 경우
                else if (strikes == 0 && balls > 0) {
                    System.out.println(String.format("%d볼", balls));
                }
                // 스트라이크만 있는 경우
                else if (balls == 0 && strikes > 0) {
                    System.out.println(String.format("%d스트라이크", strikes));
                }
                // 둘 다 없는 경우
                else {
                    System.out.println("낫싱");
                }

                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    while (true) {
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        String continueData = Console.readLine().trim();

                        // 게임 재시작
                        if (continueData.equals("1")) {
                            computerStr = makeRandomString();
                            break;
                        }
                        // 게임 종료
                        else if (continueData.equals("2")) {
                            return;
                        }
                        // 재시작도, 종료도 아닌 다른 값을 넣은 경우
                        else {
                            System.out.println("1이나 2를 입력하세요.");
                        }
                    }
                }

            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static String makeRandomString() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : computer) {
            sb.append(num);
        }

        return sb.toString();
    }

    private static boolean isUniqueThreeDigit(String str) {
        if (str.length() != 3) {
            return false; // 길이가 3이 아님
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!Character.isDigit(ch)) {
                return false; // 숫자가 아닌 문자 포함하면 안됨.
            }

            for (int j = i + 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    return false; // 중복된 숫자가 있으면 안됨.
                }
            }
        }

        return true;
    }
}
