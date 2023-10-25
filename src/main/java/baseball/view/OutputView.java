package baseball.view;

import baseball.domain.GameResultDTO;

public class OutputView {
    private StringBuilder messageBuilder;

    private void initializeMessageBuilder() {
        this.messageBuilder = new StringBuilder();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void displayGameResult(GameResultDTO gameResultDTO) {
        initializeMessageBuilder();
        System.out.println(gameResultDTO.getResult(messageBuilder));
    }

    public void displayEndGameMessage() {
        initializeMessageBuilder();
        messageBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append("\n");
        messageBuilder.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.println(messageBuilder);
    }
}
