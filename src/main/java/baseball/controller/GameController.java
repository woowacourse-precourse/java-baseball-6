package baseball.controller;

import baseball.domain.NumberBaseball;
import baseball.domain.RestartOption;
import baseball.service.GameService;
import baseball.service.hint.HintService;
import baseball.util.InputUtil;
import baseball.view.*;

/**
 * GameController 클래스는 게임의 전체 흐름을 제어하는 컨트롤러입니다.
 */
public class GameController {

    private StartView startView;
    private InputView inputView;
    private HintView hintView;
    private EndView endView;
    private RestartView restartView;
    private HintService hintService;
    private GameService gameService;

    /**
     * GameController 클래스의 생성자입니다.
     *
     * @param startView     게임 시작 화면을 출력하는 뷰
     * @param inputView     입력을 받는 뷰
     * @param hintView      힌트를 출력하는 뷰
     * @param endView       게임 종료 화면을 출력하는 뷰
     * @param restartView   재시작 옵션을 출력하는 뷰
     * @param hintService   힌트 생성 및 처리를 담당하는 서비스
     * @param gameService   게임 진행을 담당하는 서비스
     */
    public GameController(StartView startView, InputView inputView, HintView hintView,
                          EndView endView, RestartView restartView,
                          HintService hintService, GameService gameService) {
        this.startView = startView;
        this.inputView = inputView;
        this.hintView = hintView;
        this.endView = endView;
        this.restartView = restartView;
        this.hintService = hintService;
        this.gameService = gameService;
    }

    /**
     * 게임을 실행하는 메서드입니다.
     */
    public void play() {
        while (start()) {

        }
    }

    /**
     * 게임을 시작하고, 게임이 종료될 때까지 반복하는 메서드입니다.
     *
     * @return 게임을 재시작할지 여부를 나타내는 boolean 값
     */
    private boolean start() {
        startView.displayStartMessage();

        NumberBaseball computerBaseball = NumberBaseball.createRandomBaseball();
        //System.out.println(computerBaseball.getValues());
        gameService.playOneGame(inputView, hintView, endView, restartView, hintService, computerBaseball);

        return isRestart();
    }

    /**
     * 게임 재시작 여부를 판단하는 메서드입니다.
     *
     * @return 게임을 재시작할지 여부를 나타내는 boolean 값
     */
    private boolean isRestart() {
        restartView.displayRestartChoiceMessage();

        String regameNum = InputUtil.inputString();
        RestartOption restartOption = RestartOption.create(regameNum);

        return restartOption == RestartOption.RESTART_GAME;
    }
}