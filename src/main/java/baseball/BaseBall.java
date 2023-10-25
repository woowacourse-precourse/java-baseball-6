package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBall {

    private final Scanner scanner;

    public BaseBall(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> getRandomList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public void play(List<Integer> randomList) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String next = scanner.next();

            List<Integer> inputIntList = checkIllegalInput(next);

            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < 3; i++) {
                if (inputIntList.get(i).equals(randomList.get(i))) {
                    strikeCount++;
                }

                if (randomList.contains(inputIntList.get(i))) {
                    ballCount++;
                }
            }
            ballCount -= strikeCount;

            if (ballCount + strikeCount == 0) {
                System.out.println("낫싱");
            } else {
                if (ballCount > 0 && strikeCount > 0) {
                    System.out.printf("%d볼 %d스트라이크%n", ballCount, strikeCount);
                } else if (strikeCount == 0) {
                    System.out.printf("%d볼%n", ballCount);
                } else {
                    System.out.printf("%d스트라이크%n", strikeCount);
                }
            }

            if (strikeCount == 3) {
                return;
            }
        }
    }

    public boolean endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String next = scanner.next();

        int nextInt = 0;
        try {
            nextInt = Integer.parseInt(next);
        } catch (Exception e) {
            throw new IllegalArgumentException("1과 2 중에 입력해주세요");
        }

        if (!List.of(1, 2).contains(nextInt)) {
            throw new IllegalArgumentException("1과 2 중에 입력해주세요");
        }

        return nextInt == 1;

    }

    /**
     * 사용자의 입력을 검증합니다.
     * 사용자 입력 조건: 사용자의 입력은 3자리의 서로 다른 자연수여야한다.
     */
    private List<Integer> checkIllegalInput(String next) {
        char[] chars = next.toCharArray();
        List<Integer> nextIntList = new ArrayList<>();
        for (Character c : chars) {
            nextIntList.add(Character.getNumericValue(c));
        }

        List<Integer> intListHasUniqueElement = nextIntList.stream().distinct().toList();
        if (intListHasUniqueElement.size() != 3) {
            throw new IllegalArgumentException("적절하지 않은 입력입니다. 사용자의 입력은 3자리의 서로 다른 자연수여야합니다.");
        }

        return intListHasUniqueElement;
    }
}
