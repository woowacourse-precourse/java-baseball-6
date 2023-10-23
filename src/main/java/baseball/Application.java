package baseball;

import baseball.domain.GameOperator;
import baseball.domain.Input;
import baseball.domain.Judgement;
import baseball.domain.Output;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        GameOperator gameOperator = new GameOperator();
        Input input = new Input();
        Output output = new Output();
        Judgement judge = new Judgement();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean play = true;

        while (play) {
            List<Integer> opponent = gameOperator.createOpponent();
            System.out.println(opponent);
            boolean threeStrike = true;
            while (threeStrike) {
                System.out.print("숫자를 입력해주세요 : ");
                int[] resultData = judge.judgement(opponent, input.playerInput(3));
                threeStrike = output.printResult(resultData);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            play = gameOperator.restart(input.playerInput(1));
        }
        System.out.print("게임 종료");
    }
}

