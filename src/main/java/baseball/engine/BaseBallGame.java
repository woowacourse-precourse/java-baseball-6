package baseball.engine;

import baseball.message.Message;
import baseball.common.RandomNumberGenerator;
import baseball.engine.manager.Referee;
import baseball.console.Prompt;
import baseball.engine.dto.Status;
import baseball.mapper.BaseBallGameMapper;
import baseball.validator.Validator;
import java.util.List;

public class BaseBallGame {
    private static final int REPLAY = 1;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Prompt prompt;
    private final Validator validator;
    private final BaseBallGameMapper baseBallGameMapper;
    private final Referee referee;

    public BaseBallGame(RandomNumberGenerator randomNumberGenerator, Prompt prompt, Validator validator,
                        BaseBallGameMapper baseBallGameMapper, Referee referee) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.prompt = prompt;
        this.validator = validator;
        this.baseBallGameMapper = baseBallGameMapper;
        this.referee = referee;
    }

    public void start() {
        boolean isRunnable = true;
        prompt.print(SystemMessage.INTRO);
        List<Integer> randomNumbers = randomNumberGenerator.createNumber(3);

        while (isRunnable) {
            prompt.print(SystemMessage.INPUT);
            String playerInput = prompt.input();
            validator.verifyForBaseballNumber(playerInput);
            List<Integer> verifiedInput = baseBallGameMapper.toList(playerInput);
            Status judgedStatus = referee.judge(verifiedInput, randomNumbers);
            prompt.print(judgedStatus::getResult);

            if (judgedStatus.isAllStrike()) {
                prompt.print(SystemMessage.ALL_STRIKE);
                prompt.print(SystemMessage.ASK_AGAIN);

                isRunnable = isReplay();
                if (isRunnable) {
                    randomNumbers = randomNumberGenerator.createNumber(3);
                }
            }
        }
    }

    private boolean isReplay() {
        String redo = prompt.input();
        validator.verifyForRedo(redo);
        int verifiedRedo = baseBallGameMapper.toInt(redo);

        return verifiedRedo == REPLAY;
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
