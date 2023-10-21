package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static int inputNumber;
    public static void main(String[] args) {
        startNewGame();
    }

    private static void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다."); //이거 외부라이브러리면.. 스트링으로 저장한 후 리턴해야겠다

        while (true) {
            Game game = new Game();
            boolean isGameOver = false;

            while (!isGameOver) {
                System.out.print("숫자를 입력해주세요: ");
                String inputString = readLine();
                inputNumber = Integer.parseInt(inputString);

                String result = game.evaluation(inputNumber);
                System.out.println(result);

                if (result.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                    isGameOver = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputString = readLine();
            inputNumber = Integer.parseInt(inputString);
            if (inputNumber == 2) {
                break;
            }
        }

    }
}


class RandomNumberGenerator{
    static int hundred;
    static int ten;
    static int one;

    public static int generate() {
        int randomNumber;
        do {
            hundred=Randoms.pickNumberInRange(1,9);
            ten=Randoms.pickNumberInRange(1,9);
            one=Randoms.pickNumberInRange(1,9);
        } while (!isDistinct(hundred, ten, one));
        randomNumber=hundred*100+ten*10+one;
        return randomNumber;
    }

    //세 자리가 모두 다른 숫자인지 확인하는 함수
    public static boolean isDistinct(int hundred, int ten, int one){
        return (hundred != ten) && (hundred != one) && (one != ten);
    }
}

class Game{
    int answer;
    int[] answerDigits;

    Game(){
        answer = RandomNumberGenerator.generate();
        answerDigits = new int[3];
        answerDigits[0] = answer / 100;
        answerDigits[1] = (answer / 10) % 10;
        answerDigits[2] = answer % 10;
    }

    // 사용자가 제시한 숫자를 평가하는 함수
    public String evaluation(int inputNumber) {
        int[] inputDigits = new int[3];
        inputDigits[0] = inputNumber / 100;
        inputDigits[1] = (inputNumber / 10) % 10;
        inputDigits[2] = inputNumber % 10;

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (inputDigits[i] == answerDigits[i]) {
                strikes++;
            } else if (containsDigit(inputDigits[i])) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료"; //정답
        } else if (strikes > 0 || balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else {
            return "낫싱";
        }
    }

    // 정답에 특정 숫자가 있는지 확인하는 함수 (스트라이크가 아닌 경우에)
    private boolean containsDigit(int digit) {
        for (int i = 0 ; i < 3 ; i++) {
            if (answerDigits[i] == digit) {
                return true;
            }
        }
        return false;
    }
}