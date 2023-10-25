package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int button = 1;
        AnswerBox answerBox = new AnswerBox();
        List<Integer> numGenerated;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (button == 1) { // 게임: 종료 버튼(2) 안눌리면 계속 진행됨 
            numGenerated = NumGen.generate();
            answerBox.setScore(0, 0)
                    .setMessage("낫싱");

            Processor.doGame(answerBox, numGenerated);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            try {
                button = Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: Cannot enter anything other than 1 or 2");
            }

            if (button != 1 && button != 2) {
                throw new IllegalArgumentException("Invalid input: Cannot enter anything other than 1 or 2");
            }

        }
        
        Console.close();
    }
}
