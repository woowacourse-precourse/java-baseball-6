package baseball;

import org.mockito.exceptions.verification.WantedButNotInvoked;

import java.util.*;

public class PlayBaseball {
    public String answerGenerator() {
        Set<Integer> selectedNumbers = new HashSet<>();
        Random random = new Random();

        while (selectedNumbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 1부터 9 사이의 난수 생성
            selectedNumbers.add(randomNumber);
        }

        return selectedNumbers.toString();
    }

    public int[] comparePlayResult(int[] playResult, String answer, char[] userInput) {
        int temp;

        for(int i = 0; i < 3; i++) {
            temp = answer.indexOf(userInput[i]);
            if (temp > 0) {
                if (temp == i) {
                    playResult[0]++;
                } else {
                    playResult[1]++;
                }
            } else {
                playResult[2] = 1;
            }
        }
        return playResult;
    }


    public void compareTry(int[] answer, int[] userTry) {
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer[i] == userTry[j]) {
                    if (i == j) {
                        result[0]++; // 정확한 위치의 숫자 (스트라이크)
                    } else {
                        result[1]++; // 다른 위치의 숫자 (볼)
                    }
                } else {
                    result[2] = -1;
                }
            }
        }

        if (result[2] == -1) {
            System.out.println("낫싱");
        }
        if (result[1] > 0) {
            System.out.println(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.println(result[0] + "스트라이크 ");
        }

    }

    public void playBall() {

    }


    public void printResult(int[] result) {
        if (result[2] == -1) {
            System.out.println("낫싱");
        }
        if (result[1] > 0) {
            System.out.println(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.println(result[0] + "스트라이크 ");
        }
    }

    public void playBall2() {
        String answer = answerGenerator();
        int[] playResult = {0, 0, 0};

        System.out.println("answer is : " + answer);
        System.out.println("playResult init : " + Arrays.toString(playResult));

        Scanner scanner = new Scanner(System.in);


        while (true) {
            int userInput;
            while (true) {
                try {
                    System.out.print("숫자를 입력하세요 : ");
                    userInput = scanner.nextInt();
                    System.out.println("userInput is : " + userInput);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
                }
            }
            char[] userTry = Integer.toString(userInput).toCharArray();
            playResult = comparePlayResult(playResult, answer, userTry);
            System.out.println("playResult : " + Arrays.toString(playResult));
            printResult(playResult);

            if (playResult[0] == 3) {
                break;
            } else {
                playResult[0] = 0;
                playResult[1] = 0;
                playResult[2] = 0;
            }
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
