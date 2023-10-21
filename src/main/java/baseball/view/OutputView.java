package baseball.view;

import baseball.domain.GameResultDTO;

public class OutputView {
    StringBuilder sb;
    private void StringBuilderSetting() {
        this.sb = new StringBuilder();
    }

    public void StartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void InputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void GameResult(GameResultDTO gameResultDTO) {
        StringBuilderSetting();
        if(gameResultDTO.getStrike() == 0 && gameResultDTO.getBall() == 0) {
            sb.append("낫싱");
        }

        if(gameResultDTO.getBall() != 0){
            sb.append(gameResultDTO.getBall() ).append("볼 ");
        }

        if(gameResultDTO.getStrike() != 0){
            sb.append(gameResultDTO.getStrike()).append("스트라이크");
        }
        System.out.println(sb);
    }

    public void EndGame() {
        StringBuilderSetting();
        sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append("\n");
        sb.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.println(sb);
    }
}
