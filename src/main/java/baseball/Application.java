package baseball;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int ballCount = 3; // 해당 자릿수의 숫자야구 가능
    public static int strikeCount = ballCount+1;
    
    public static HashMap<String, String> makeAnswer() {

        HashMap<String, String> answerIndexMap = new HashMap<>();

        for (int i = 0; i < ballCount;) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!answerIndexMap.containsKey(randomNumber)) {
                answerIndexMap.put(randomNumber, Integer.toString(i)); // { answer : index }
                i++;
            }
        }

        return answerIndexMap;
    }

    public static void main(String[] args) {

        HashMap<String, String> answerIndexMap = makeAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        Integer playingGame = 1;

        while (playingGame == 1) {

            System.out.printf("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            if (inputString.length() != ballCount) {
                throw new IllegalArgumentException();
            }

            Integer score = 0;

            HashMap<String, String> duplicatedCheckMap = new HashMap<>();

            for (int i = 0; i < ballCount; i++) {
                String index = Integer.toString(i);
                String inputAnswer = Character.toString(inputString.charAt(i));

                if (inputAnswer.matches("\\d+") && !duplicatedCheckMap.containsKey(inputAnswer)) {
                    duplicatedCheckMap.put(inputAnswer, null);
                } else {
                    throw new IllegalArgumentException();
                }

                if (answerIndexMap.containsKey(inputAnswer)) { // answer가 key 값으로 존재할 경우,
                    if (answerIndexMap.get(inputAnswer).equals(index)) { // index까지 일치하는 경우
                        score += strikeCount;
                    } else {
                        score += 1;
                    }
                }
            }

            String printString;

            if (score == 0) {
                printString = "낫싱";
            } else if (score == strikeCount * ballCount) {
                printString = String.format("%d스트라이크", ballCount);
            } else {
                int strike = score/strikeCount;
                int ball = score%strikeCount;
                if (ball == 0) {
                    printString = String.format("%d스트라이크", strike);
                } else if (strike == 0) {
                    printString = String.format("%d볼", ball);
                } else {
                    printString = String.format("%d볼 %d스트라이크", ball, strike);
                }
            }

            System.out.println(printString);

            if (score == strikeCount * ballCount) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", ballCount);
                playingGame = Integer.parseInt(Console.readLine());

                if (playingGame != 1 && playingGame != 2) {
                    throw new IllegalArgumentException();
                } else if (playingGame == 1) {
                    answerIndexMap = makeAnswer();
                }
            }
        }
    }
}