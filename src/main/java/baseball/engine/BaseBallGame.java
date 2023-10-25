package baseball.engine;

import static baseball.constant.BaseballSystemPolicy.EXIT;
import static baseball.constant.BaseballSystemPolicy.LIMIT_LENGTH;
import static baseball.constant.BaseballSystemPolicy.MAXIMUM_NUMBER;
import static baseball.constant.BaseballSystemPolicy.MINIMUM_NUMBER;

import baseball.console.Prompt;
import baseball.constant.BaseballSystemPolicy;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.engine.dto.Hint;
import baseball.engine.manager.Referee;
import baseball.mapper.BaseBallGameMapper;
import baseball.message.Message;
import baseball.utils.RandomGeneratorUtils;
import baseball.validator.Validator;
import java.util.List;

public class BaseBallGame {
    private final Prompt prompt;
    private final Validator validator;
    private final BaseBallGameMapper baseBallGameMapper;
    private final Referee referee;

    public BaseBallGame(Prompt prompt, Validator validator,
                        BaseBallGameMapper baseBallGameMapper, Referee referee) {
        this.prompt = prompt;
        this.validator = validator;
        this.baseBallGameMapper = baseBallGameMapper;
        this.referee = referee;
    }

    public void start() {
        boolean isRunnable = true;
        prompt.print(SystemMessage.INTRO);
        List<Integer> newNumbers = RandomGeneratorUtils.createUniqueNumbers(LIMIT_LENGTH.getCondition(),
                MINIMUM_NUMBER.getCondition(), MAXIMUM_NUMBER.getCondition());
        Computer computer = new Computer(newNumbers);

        while (isRunnable) {
            prompt.print(SystemMessage.INPUT);
            String playerInput = prompt.input();
            this.verifyForBaseballNumber(playerInput);
            List<Integer> verifiedInput = baseBallGameMapper.toList(playerInput);
            Player player = new Player(verifiedInput);
            Hint judgedHint = referee.ballCount(player, computer);
            prompt.print(judgedHint::report);

            if (judgedHint.isAllStrike()) {
                prompt.print(SystemMessage.ALL_STRIKE);

                isRunnable = isReplay();
                if (isRunnable) {
                    newNumbers = RandomGeneratorUtils.createUniqueNumbers(LIMIT_LENGTH.getCondition(),
                            MINIMUM_NUMBER.getCondition(), MAXIMUM_NUMBER.getCondition());
                    computer = new Computer(newNumbers);
                }
            }
        }
    }

    private void verifyForRedo(String input) {
        validator.verifyNullAndEmpty(input);
        validator.verifyNumberPerUnit(input);

        int redo = baseBallGameMapper.toInt(input);
        validator.verifyInRangeClosed(BaseballSystemPolicy.REPLAY.getCondition(), EXIT.getCondition(), redo);
    }

    private void verifyForBaseballNumber(String input) {
        validator.verifyNullAndEmpty(input);
        validator.verifyLength(input, LIMIT_LENGTH.getCondition());
        validator.verifyNumberPerUnit(input);

        List<Integer> inputNumbers = baseBallGameMapper.toList(input);
        validator.verifyUniqueNumber(inputNumbers);
    }


    private boolean isReplay() {
        prompt.print(SystemMessage.ASK_AGAIN);
        String redo = prompt.input();
        verifyForRedo(redo);
        int verifiedRedo = baseBallGameMapper.toInt(redo);

        return verifiedRedo == BaseballSystemPolicy.REPLAY.getCondition();
    }

    private enum SystemMessage implements Message {
        INTRO("숫자 야구 게임을 시작합니다.\n"),
        INPUT("숫자를 입력해주세요 : "),
        ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
        ASK_AGAIN("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
        NOTHING("낫싱\n");

        private String message;

        SystemMessage(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

}
