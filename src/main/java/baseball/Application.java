package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int replay = 1;
        while (replay != 2) {
            Game game = new Game();
            ReGame reGame = new ReGame();

            game.startGame();
            replay = reGame.restart();
        }
    }
}

class Computer {  // 컴퓨터 숫자 지정 클래스
    public List<Integer> comNumbers = new ArrayList<>();

    public void choiceComNumbers() {
        while (comNumbers.size() < 3) {
            randomNumbers();
        }
    }

    public void randomNumbers() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!comNumbers.contains(randomNumber)) {
            comNumbers.add(randomNumber);
        }
    }
}

class Game extends Computer {  // 게임 시작 클래스

    public void startGame() {
        choiceComNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");

        String endMessage = "";
        while (!endMessage.equals("3스트라이크")) {
            List<Integer> inputNumbers = inputNumber();
            endMessage = ballOrStrike(inputNumbers.get(0), inputNumbers.get(1));
            System.out.println(endMessage);
        }
    }

    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String myNumbers = Console.readLine();
        if (!myNumbers.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("게임 진행 중 잘못된 숫자를 입력하셨습니다.");
        }
        return (compareResult(myNumbers));
    }

    public List<Integer> compareResult(String myNumbers) {
        List<Integer> compares = new ArrayList<>();
        int ball = 0;
        int strike = 0;
        for (int i = 0; i <= 2; i++) {
            int compareNumber = comNumbers.indexOf(myNumbers.charAt(i) - '0');
            compares = compare(i, ball, strike, compareNumber);
            ball = compares.get(0);
            strike = compares.get(1);
        }
        return (compares);
    }

    public List<Integer> compare(int i, int ball, int strike, int compareNumber) {
        if (compareNumber == -1) {  // 일치하는 숫자 없음
        } else if (compareNumber == i) {
            ++strike;
        } else {
            ++ball;
        }
        List<Integer> compares = new ArrayList<>();
        compares.add(ball);
        compares.add(strike);
        return (compares);
    }

    public String ballOrStrike(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        }
        if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}

class ReGame {  // 재시작 여부 클래스
    public int restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = Integer.parseInt(Console.readLine());
        if (replay != 1 && replay != 2) {
            throw new IllegalArgumentException("재시작 여부를 묻는 질문에서 잘못된 숫자를 입력하셨습니다.");
        }
        return replay;
    }
}