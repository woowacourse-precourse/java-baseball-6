package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Game {
    private final List<Integer> computer;
    private final List<Integer> userInput;
    Game() {
        computer = new ArrayList<>();
        userInput = new ArrayList<>();
    }

    public void run() {
        try {
            do { play(); } while (restart());
        } catch (IllegalArgumentException e) { throw e; }
    }

    public void play() {
        createNum();
        do {
            if (!input()) {
                throw new IllegalArgumentException("잘못된 입력으로 인해 게임을 종료합니다.");
            }
        } while (!isCorrect());
    }
    
    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reNum = Console.readLine();
        if (reNum.equals("1")) 
            return true;
        else if (reNum.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else throw new IllegalArgumentException("1또는 2중 하나를 입력하세요.");
    }

    public boolean isCorrect() {
        int strikeNum = 0;
        int ballNum = 0;
        int index = 0;
        for (int comInt : computer) {
            if (userInput.contains(comInt)) {
                if (userInput.get(index).equals(computer.get(index))) {
                    strikeNum++;
                } else { ballNum++; }
            }
            index++;
        }
        if (strikeNum == 0 && ballNum == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strikeNum != 3) {
            System.out.println(ballNum + "볼 " + strikeNum + "스트라이크");
            return false;
        } else {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
    }

    public void createNum() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { computer.add(randomNumber); }
        }
    }

    public boolean input() {
        System.out.print("숫자를 입력하세요.");
        String inputStr = Console.readLine();
        int num;
        if (inputStr.length() == 3) {
            try {
                userInput.clear();
                for (int i = 0; i < inputStr.length(); i++) {
                    num = Character.getNumericValue(inputStr.charAt(i));
                    if (num == 0) throw new IllegalArgumentException("0은 입력불가능합니다.");
                    userInput.add(num);
                }
                for (int i = 0; i < userInput.size(); i++) {
                    for (int j = 0; j < i; j++) {
                        if (userInput.get(i).equals(userInput.get(j))) throw new IllegalArgumentException("중복된 요소가 있습니다.");
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            return true;
        } else {
            throw new IllegalArgumentException("3글자를 입력해주세요.");
        }
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game bsGame = new Game();
        bsGame.run();
    }
}