package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Game {
    private int ballCount = 0;
    private int strikeCount = 0;
    private int[] rightAnswer = new int[3];

    Game() {
        generateRightAnswer();
    }

    private void generateRightAnswer() {
        for (int i = 0; i < rightAnswer.length; i++) {
            rightAnswer[i] = pickNumberInRange(1, 9);
            if (checkDuplication(rightAnswer, i)) {
                i--;
                continue;
            }
        }
    }

    private boolean checkDuplication(int[] arr, int i) {
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                return true;
            }
        }
        return false;
    }

    private void compareAnswer(int num) {
        int[] question = callArray(num);
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < question.length; i++) {
            for (int j = 0; j < rightAnswer.length; j++) {
                if (question[i] == rightAnswer[j]) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
    }

    private static int[] callArray(int num) {
        int[] question = new int[3];
        question[0] = num / 100;
        question[1] = (num % 100) / 10;
        question[2] = num % 10;
        return question;
    }

    private void showHint() {
        if (ballCount == 0) {
            if (strikeCount == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(strikeCount + "스트라이크");
            }
        } else {
            if (strikeCount == 0) {
                System.out.println(ballCount + "볼");
            } else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
        }
    }

    private boolean gameSet() {
        return strikeCount == 3;
    }

    private boolean reStart() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int newGame = Integer.parseInt(readLine());
        if (newGame == 1) {
            return true;
        } else if (newGame == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isThreeDigitNumber(int num) {
        return num >= 100 && num <= 999;
    }

    public static void play() {
        int question;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Game basegame = new Game();
            while (!basegame.gameSet()) {
                System.out.print("숫자를 입력해주세요 : ");
                question = Integer.parseInt(readLine());
                if (!basegame.isThreeDigitNumber(question)) {
                    throw new IllegalArgumentException();
                }
                basegame.compareAnswer(question);
                basegame.showHint();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if (basegame.reStart()) {
                continue;
            } else {
                break;
            }
        } while (true);
    }
}

public class Application {
    public static void main(String[] args) {
        Game.play();
    }
}
