package baseball.controller;

import baseball.service.NumberService;
import baseball.utils.message.ErrorMessage;

/**
 * Controller는 사용자 입력을 전달받아, 올바른 형태로 가공 후 service에 전달하여 비즈니스 로직을 처리한다.
 *
 * OutputView를 Controller에 넣고 DTO 처럼 사용자에게 전달할 정보를 set하고 Application에 전달하는게 나을까?
 * View가 사용자와 맞닿아 있는 interface라는 점에서 굳이 output, input 나누지 않고
 * 경우에 따라서 사용자 입력만 담거나 , 내보낼 정보만 출력하는것도 괜찮을수도 있을것 같다.
 */

public class BaseballGameController {

    private final NumberService numberService;

    public BaseballGameController(NumberService numberService) {
        this.numberService = numberService;
    }

    public boolean match(String input) {
        try {
            int number = Integer.parseInt(input);
            return numberService.isCorrect(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBERS);
        }
    }


    public String hint(String input) {
        try {
            int number = Integer.parseInt(input);
            return numberService.getHint(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBERS);
        }
    }

    public void nextGame() {
        numberService.init();
    }
}
