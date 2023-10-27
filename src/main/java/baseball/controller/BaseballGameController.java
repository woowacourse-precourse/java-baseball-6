package baseball.controller;

import baseball.domain.BaseballGameNumbers;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Umpire;
import baseball.generator.RandomNumGenerator;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGameController {

    private InputView inputView;
    private OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.start();

        boolean isContinue = true;
        while (isContinue) {
            play();
            isContinue = playAgain();
        }
        end();

    }

    private void play() {

        //컴퓨터(상대방), 플레이어, 심판 생성
        Computer computer = startComputer();
        Player player = new Player();
        Umpire umpire = new Umpire();

        while(true){
            //사용자 입력
            String input = inputView.input();
            //사용자 입력 예외처리 및 String -> List<Integer> 변환
            BaseballGameNumbers playerNumbers = checkAndConvert(input);
            //사용자 입력 저장
            player.pickNumber(playerNumbers);

            //스트라이크, 볼 판별
            String result = judge(umpire, computer, player);
            //결과 출력
            outputView.printResult(result);

            //3스트라이크면 게임 한 세트 종료
            if (result.equals("3스트라이크")) {
                return;
            }
        }
    }

    private boolean playAgain() {
        outputView.printSetEnd();
        String restart = inputView.restart();
        InputValidator.isValidRestart(restart);
        return restart.equals("1");
    }

    private void end() {
        // 기능 요구 사항, 종료시 아무 행동을 할 필요 없음.
    }

    private Computer startComputer() {
        BaseballGameNumbers computerNumbers = BaseballGameNumbers.of(RandomNumGenerator.generate());
        return new Computer(computerNumbers);
    }

    private BaseballGameNumbers checkAndConvert( String input) {

        //사용자 입력 예외처리
        InputValidator.isValidInput(input);
        //사용자 입력 String -> List<Integer> 변환
        List<Integer> list = new ArrayList<>();
        Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .forEach(list::add);

        return BaseballGameNumbers.of(list);
    }

    private String judge(Umpire umpire, Computer computer, Player player) {
        return umpire.rule(computer, player);
    }

}
