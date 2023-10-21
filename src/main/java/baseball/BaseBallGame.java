package baseball;

import java.util.List;

public class BaseBallGame {

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

    private final RandomNumberGenerator randomNumberGenerator;
    private final Prompt prompt;

    public BaseBallGame(RandomNumberGenerator randomNumberGenerator, Prompt prompt) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.prompt = prompt;
    }

    public void start() {
        boolean isRunnable = true;
        prompt.print(SystemMessage.INTRO);
        List<Integer> randomNumbers = randomNumberGenerator.createNumber(3);

        while (isRunnable) {
            prompt.print(SystemMessage.INPUT);
            String playerInput = prompt.input();
            // todo: 사용자 입력 검증하기
            // todo: 난수와 사용자 입력 판별하기
            // todo: 결과 출력하기
            // todo:
            //  - 난수와 사용자 입력을 맞을 경우 재시작 | 시스템 종료 문구 출력 및 입력받기
            //  - 재입력받기
            isRunnable = false;
        }
    }
}
