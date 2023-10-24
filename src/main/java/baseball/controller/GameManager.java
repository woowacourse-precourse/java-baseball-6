package baseball.controller;

import baseball.domain.GameSetting;
import baseball.utils.Converter;

import static baseball.constant.GameConstant.GAME_OVER;
import static baseball.constant.GameConstant.INPUT_PROMPT;

public class GameManager {
    private final int[] answer;
    private final GameSetting gameSetting;

    public GameManager(int[] answer, GameSetting gameSetting) {
        this.answer = answer;
        this.gameSetting = gameSetting;
    }

    public void startGame() {
        String resultMessage;
        do {
            System.out.print(INPUT_PROMPT);
            String input = gameSetting.getInputService().getNumber(gameSetting.getSize(),
                    gameSetting.getStartNum(),
                    gameSetting.getEndNum());
            resultMessage = gameSetting.getPrintService().printResult(answer, Converter.convertToArray(input));
            System.out.println(resultMessage);
        } while (!resultMessage.contains(GAME_OVER));
    }
}
