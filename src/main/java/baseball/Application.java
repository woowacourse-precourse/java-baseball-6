package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 게임을 시작하는 기능
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean retry = true;

        Computer computer = new Computer();

        // 게임 시작
        while (retry) {
            // 컴퓨터가 숫자 3개를 뽑는 기능
            List<Integer> computerPickNumber = computer.getPickNumber();

            while (true) {
                // 사용자가 입력한 숫자를 저장하는 기능
                System.out.print("숫자를 입력해주세요 : ");
                Optional<List<Integer>> result = getUserInputNumber();
                if (result.isEmpty()) return;
                List<Integer> userInputNumber = result.get();

                // 스트라이크와 볼 개수 집계
                int[] score = computer.calculateScore(computerPickNumber, userInputNumber);

                // 집계 결과 출력
                computer.printResult(score);

                // 집계 결과 출력 후 게임 종료 기능
                if (score[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;  // 게임 종료
                }
            }

            // 게임 종료 후 사용자가 계속 게임할지 선택을 입력받는 기능
            while (true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int isRetry = Integer.parseInt(Console.readLine());
                if (isRetry == 2) {
                    retry = false;
                    break;
                } else if (isRetry == 1) {
                    computer.pickNumber.clear();
                    break;
                }
            }
        }
        System.out.println("게임 종료");
    }

    public static Optional<List<Integer>> getUserInputNumber() throws IllegalArgumentException{
        String[] userInputString = Console.readLine().split("");

        // 사용자가 입력한 숫자가 올바른 형식인지 검사
        boolean result = isCorrectNumber(userInputString);
        if (!result) {
            return Optional.empty();
        }

        List<Integer> userInputNumber = Arrays.stream(userInputString)
                .map(Integer::parseInt)
                .toList();
        return Optional.of(userInputNumber);
    }

    // 사용자가 입력한 숫자가 올바른 형식인지 검사하는 기능
    public static boolean isCorrectNumber(String[] stringArray) throws IllegalArgumentException {
        try {
            // 배열의 길이가 3 이상이면 에러 발생 및 게임 종료
            if (stringArray.length > 3) {
                throw new IllegalArgumentException();
            }
            // 숫자 변환
            List<Integer> integerList = Arrays.stream(stringArray)
                    .map(Integer::parseInt)
                    .toList();
            // 숫자 0 검사 및 중복 검사
            for (int i = 0; i < integerList.size(); i++) {
                for (int j = i + 1; j < integerList.size(); j++) {
                    if (integerList.get(i).equals(0) || integerList.get(j).equals(0)) {
                        throw new IllegalArgumentException();
                    } else if (integerList.get(i).equals(integerList.get(j))) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}

class Computer {
    public List<Integer> pickNumber = new ArrayList<>();

    public List<Integer> getPickNumber() {
        while (pickNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!pickNumber.contains(randomNumber)) {
                pickNumber.add(randomNumber);
            }
        }
        return pickNumber;
    }

    // 컴퓨터가 뽑은 숫자와 사용자가 입력한 숫자를 비교하는 기능
    public int[] calculateScore(List<Integer> computerPickNumber, List<Integer> userInputNumber) {
        int[] counts = new int[2]; // counts[0]는 스트라이크 개수, counts[1]은 볼 개수
        for (int i = 0; i < computerPickNumber.size(); i++) {
            for (int j = 0; j < userInputNumber.size(); j++) {
                if (computerPickNumber.get(i).equals(userInputNumber.get(j))) {
                    if (i == j) {
                        counts[0]++;  // strike
                    } else {
                        counts[1]++;  // ball
                    }
                }
            }
        }
        return counts;
    }

    // 집계 결과 출력 기능
    public void printResult(int[] counts) {
        if (counts[1] == 0 && counts[0] == 0) {
            System.out.println("낫싱");
        } else if (counts[0] == 0) {
            System.out.println(counts[1] + "볼");
        } else if (counts[1] == 0) {
            System.out.println(counts[0] + "스트라이크");
        } else {
            System.out.println(counts[1] + "볼 " + counts[0] + "스트라이크");
        }
    }
}
