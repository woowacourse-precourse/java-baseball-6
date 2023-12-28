package baseball.view;

import baseball.dto.ButtonRequestDto;
import baseball.dto.PlayerBallRequestDto;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static PlayerBallRequestDto inputPlayerBall() {
        System.out.print("숫자를 입력해주세요 : ");
        PlayerBallRequestDto playerBallRequestDto = new PlayerBallRequestDto();
        playerBallRequestDto.setNumber(Console.readLine());
        return playerBallRequestDto;
    }

    public static ButtonRequestDto inputButton() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        ButtonRequestDto buttonRequestDto = new ButtonRequestDto();
        buttonRequestDto.setName(Console.readLine());
        return buttonRequestDto;
    }

}
