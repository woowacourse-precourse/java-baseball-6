package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.GameResult;
import baseball.exception.BusinessException;
import baseball.exception.ExceptionCode;
import baseball.model.Model;
import baseball.model.ModelConst;

public class NumberBaseballView implements GameView {

    private final String STRIKE_PHRASE = "스트라이크";
    private final String BALL_PHRASE = "볼 ";
    private final String THREE_STRIKE_PHRASE = "3스트라이크";
    private final String NOTHING_PHRASE = "낫싱";
    private final String RESTART_PHRASE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String START_PHRASE = "숫자 야구 게임을 시작합니다.";
    private final String ANSWER_INPUT_PHRASE = "숫자를 입력해주세요 : ";
    private final String GAME_END_PHRASE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final Model model;

    public NumberBaseballView(final Model model) {
        this.model = model;
    }

    @Override
    public void conveyUserInput() {
        String input = readLine();
        model.setAttribute(ModelConst.INPUT_DATA, input.trim());
    }

    @Override
    public void printGameStartAnnouncement() {
        System.out.println(START_PHRASE);
    }

    @Override
    public void printAnnouncementForInputAnswer() {
        System.out.print(ANSWER_INPUT_PHRASE);
    }

    @Override
    public void printAnnouncementForRestart() {
        System.out.println(GAME_END_PHRASE);
        System.out.println(RESTART_PHRASE);
    }

    @Override
    public void printGameResult() {
        GameResult result = (GameResult) model.getAttribute(ModelConst.RESULT)
                .orElseThrow(() ->
                        new BusinessException(ExceptionCode.NO_RESULT, this.getClass())
                );

        System.out.println(parseResult(result));
    }

    private String parseResult(final GameResult result) {
        if (result.isCompleted()) {
            return THREE_STRIKE_PHRASE;
        }
        if (result.isNothing()) {
            return NOTHING_PHRASE;
        }
        return result.ball() + BALL_PHRASE + result.strike() + STRIKE_PHRASE;
    }
}
