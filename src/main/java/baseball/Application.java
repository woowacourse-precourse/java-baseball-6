package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static int inputNumber;
    public static void main(String[] args) {
        startNewGame();
    }
    private static void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameOver = false;
        while (true) {
            Game game = new Game();
            while (!isGameOver) {
                try{
                    System.out.print("숫자를 입력해주세요: ");
                    String inputString = readLine();
                    inputNumber = 0;
                    inputNumber = parseAndValidateInput(inputString);
                    //입력이 잘못됐다면 inputNumber==0이 된다.
                    if (inputNumber==0){
                        isGameOver=true;
                    }
                    String result = game.evaluation(inputNumber);
                    System.out.println(result);

                    if (result.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                        isGameOver = true;
                    }
                }catch(IllegalArgumentException e){
                    System.out.println("잘못 입력하셨습니다.");
                    isGameOver = true;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputString = readLine();
            inputNumber = Integer.parseInt(inputString);
            if (inputNumber==1){
                isGameOver=false;
            }
            if (inputNumber == 2) {
                break;
            }
        }
    }

    // 사용자 입력을 파싱하고 유효성을 검사하는 함수
    private static int parseAndValidateInput(String inputString) {
        try {
            int inputNumber = Integer.parseInt(inputString);
            if (inputString.length() != 3 || !RandomNumberGenerator.isDistinct(
                    inputNumber / 100, (inputNumber / 10) % 10, inputNumber % 10)) {
                throw new IllegalArgumentException("세 자리 숫자 중 중복 또는 잘못된 값이 있습니다.");
            }
            return inputNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
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