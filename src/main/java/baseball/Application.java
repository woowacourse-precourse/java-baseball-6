package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        int choice;
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = Integer.parseInt(Console.readLine());
        } while (choice != 2);
    }

    private static void playGame() {
        List<Integer> computer = new ArrayList<>();
        createRandomNumbers(computer);
        boolean isGameFinished = false;

        while (!isGameFinished) {
            int[] result = playSingleRound(computer);
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameFinished = true;
            }
        }
    }

    private static void createRandomNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static int[] playSingleRound(List<Integer> computer) {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        String[] inputDigits = userInput.split("");
        if (inputDigits.length != 3) {
            throw new IllegalArgumentException();
        }
        int[] counts = new int[2]; //인덱스 0은 스트라이크 , 1은 볼

        for (int i = 0; i < 3; i++) {
            int guess = Integer.parseInt(inputDigits[i]);
            int target = computer.get(i);

            if (guess == target) {
                counts[0]++;
            } else if (computer.contains(guess)) {
                counts[1]++;
            }
        }

        if (counts[1] > 0) {
            System.out.print(counts[1] + "볼 ");
        }
        if (counts[0] > 0) {
            System.out.print(counts[0] + "스트라이크");
        }
        if (counts[0] == 0 && counts[1] == 0) {
            System.out.println("낫싱");
        }
        System.out.println();

        return counts;
    }
}
