package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final int MAX_COUNT = 3;

    public static void main(String[] args) {

        baseball.Application game = new baseball.Application();

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.playGame();

    }

    public void playGame() {

        List<Integer> computerNumber = makeComputerNumber();

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String writeNumber = readLine();
            checkInputValue(writeNumber);

            String text = resultCount(writeNumber, computerNumber);
            System.out.println(text);

            if (text.equals(MAX_COUNT + "스트라이크")) {
                startNewGame();
                break;
            }
        }
    }
}
