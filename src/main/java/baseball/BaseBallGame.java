package baseball;

import java.util.List;

public class BaseBallGame {

    private final RandomNumberGenerator randomNumberGenerator;

    private final Prompt prompt;
    private final Validator validator;
    private final BaseBallGameMapper baseBallGameMapper;

    public BaseBallGame(RandomNumberGenerator randomNumberGenerator, Prompt prompt, Validator validator,
                        BaseBallGameMapper baseBallGameMapper) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.prompt = prompt;
        this.validator = validator;
        this.baseBallGameMapper = baseBallGameMapper;
    }

    public void start() {
        boolean isRunnable = true;
        prompt.print(SystemMessage.INTRO);
        List<Integer> randomNumbers = randomNumberGenerator.createNumber(3);

        while (isRunnable) {
            prompt.print(SystemMessage.INPUT);
            String playerInput = prompt.input();
            validator.verify(playerInput);
            List<Integer> verifiedInput = baseBallGameMapper.toList(playerInput);
            // todo: 난수와 사용자 입력 판별하기
            // todo: 결과 출력하기
            // todo:
            //  - 난수와 사용자 입력을 맞을 경우 재시작 | 시스템 종료 문구 출력 및 입력받기
            //  - 재입력받기
            isRunnable = false;
        }
    }

    private enum SystemMessage implements Message {
        INTRO("숫자 야구 게임을 시작합니다.\n"),
        INPUT("숫자를 입력해주세요 : ");

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
