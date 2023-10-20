package baseball.component;

public class GameCore {
    private Initializer initializer;
    private Inputter inputter;
    private Validator validator;

    public GameCore(
            Initializer initializer,
            Inputter inputter,
            Validator validator
            ) {
        this.initializer = initializer;
        this.inputter = inputter;
        this.validator = validator;
    }

    public void game() {
        boolean flag = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (flag) {
            initGame();
            doGame();
            flag = inputter.restart();
        }
    }

    private void doGame() {
        boolean flag = true;
        while (flag) {
            validator.validate(inputter.input());
            if (validator.getStrike() == GeneralNumbers.NUMBER_SIZE.getCode()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                flag = false;
            } else if (validator.getNoting()) {
                System.out.println("낫싱");
            } else {
                System.out.println(getFormatedString(validator.getStrike(), validator.getBall()));
            }
        }
    }

    private String getFormatedString(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }

    private void initGame() {
        validator.setTarget(initializer.getNewNumbers());
    }
}
