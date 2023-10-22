package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int[] randomValue() {
        int[] numberOfAnswer = new int[3]; // 컴퓨터의 정답 출력
        for (int i = 0; i < numberOfAnswer.length; i++) {
            numberOfAnswer[i] = Randoms.pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) if (numberOfAnswer[i] == numberOfAnswer[j]) i--;
        }
        return numberOfAnswer;
    }

    public static int[] userInput() {
        int[] userInput = new int[3]; // 사용자의 정답 입력
        String tempUserInput = ""; // 사용자 입력을 String으로 나눈 후 int형으로 바꾸기 위해 임시 저장
        // System.out.println(Arrays.toString(answerArray));


        // 사용자 input
        tempUserInput = readLine();
        if (tempUserInput.length() != 3) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 3자리 숫자를 입력하세요.");
        }


        for (int l = 0; l < tempUserInput.length(); l++) {
            if (tempUserInput.charAt(l) < '1' || tempUserInput.charAt(l) > '9') {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.숫자를 입력하세요.");
            }
            userInput[l] = (tempUserInput.charAt(l) - '0');

        }


        for (int l = 0; l < tempUserInput.length(); l++) {
            userInput[l] = (tempUserInput.charAt(l) - '0');
        }
        return userInput;
    }
    


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구를 시작합니다."); // 게임 시작 문구


        int[] answerArray = {0, 0, 0}; // Strike, Ball, Out 개수 체크
        String gameEndUserChoice; // 정답 맞춘 후 게임 종료 체크

        while (true) {
            //if (countGame > 1) scanner.nextLine();
            // 숫자 생성
            int []numberOfAnswer = randomValue();
            // System.out.println(Arrays.toString(numberOfAnswer));

            while (true) {
                Arrays.fill(answerArray, 0);

                int userInput[] = userInput();

                for (int k = 0; k < numberOfAnswer.length; k++) {
                    if (userInput[k] == numberOfAnswer[k]) {
                        answerArray[0] += 1;
                    }
                    for (int m = 0; m < numberOfAnswer.length; m++) {
                        if (m == k) continue;
                        if (userInput[k] == numberOfAnswer[m]) {
                            answerArray[1] += 1;
                            break;
                        }
                    }
                }

                answerArray[2] = numberOfAnswer.length - (answerArray[0] + answerArray[1]);
                if (answerArray[0] >= 1) {
                    if (answerArray[1] >= 1) System.out.print(answerArray[1] + "볼 ");
                    System.out.println(answerArray[0] + "스트라이크");
                }
                else if((answerArray[0] < 1)) {
                    if (answerArray[1] >= 1) System.out.println(answerArray[1] + "볼");
                }

                if (answerArray[2] >= 3) System.out.println("낫싱");

                if (answerArray[0] == numberOfAnswer.length) {
                    System.out.println(numberOfAnswer.length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    gameEndUserChoice = readLine();
                    if (gameEndUserChoice.equals("1")) {
                        break; // 게임 재시작
                    } else if (gameEndUserChoice.equals("2")) {
                        System.out.println("게임을 종료합니다.");
                        return; // 게임 종료
                    } else {
                        System.out.println("1 또는 2를 입력하세요.");
                    }
                }
            }
        }
    }
}
