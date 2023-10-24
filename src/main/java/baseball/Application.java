package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = generateNumber();

        int[] result = playGameWithGetGuessNumber(computerNumbers);

    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int[] playGameWithGetGuessNumber(List<Integer> computerNumbers) {
        while (true) {
            int[] result = new int[2]; // 볼, 스트라이크
            System.out.println("숫자를 입력해주세요 : ");
            String guessString = Console.readLine(); // 사용자 숫자 입력
            String[] parts = guessString.split("");
            System.out.println(guessString);

            int[] intArray = new int[parts.length];
            //intArray 에 문자를 숫자로 변경해서 변수에 할당
            for (int i = 0; i < parts.length; i++) {
                intArray[i] = Integer.parseInt(parts[i]);
            }

            // 잘못된 숫자 입력되었는지 판별하는 코드
            if (!isCorrectGuess(intArray)) {
                throw new IllegalArgumentException();

            }

            // 스트라이크, 볼 검증 코드
            for (int i = 0; i < 3; i++) {
                if (intArray[i] == computerNumbers.get(i)) {
                    result[1]++;
                } else if (computerNumbers.contains(intArray[i])) {
                    result[0]++;

                }
            }
            if (result[0] > 0 && result[1] == 0) {
                System.out.println(result[0] + "볼");
            } else if (result[0] == 0 && result[1] > 0) {
                System.out.println(result[1] + "스트라이크");
            } else if (result[0] > 0 && result[1] > 0) {
                System.out.println(result[0] + "볼" + result[1] + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                String answer = Console.readLine();
                if ("1".equals(answer)) {
                    computerNumbers = generateNumber();
                    // 게임 재시작 하는 경우에 랜덤 숫자 갱신 필요
                } else if ("2".equals(answer)) {
                    break;
                }
                // 종료 처리 코딩 수정 필요

            }
        }


        return new int[1];
    }

    public static boolean isCorrectGuess(int[] intArray) {
        // 숫자배열이 3가지 아닐때
        if (intArray.length != 3) {
            return false;
        }
        // 1보다 작은숫자가 있는지 검사하는 코드
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 1) {
                return false;
            }

        }

        // 중복숫자가 있는지 확인하는 코드
        if (intArray[0] == intArray[1] || intArray[0] == intArray[2] || intArray[1] == intArray[2]) {
            return false;
        }
        return true;
    }
}













