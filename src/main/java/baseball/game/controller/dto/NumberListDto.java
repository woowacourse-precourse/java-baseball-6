package baseball.game.controller.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 정답 숫자와 유저 입력 숫자를 담는 DTO 클래스
 */
public class NumberListDto {
    private final List<Integer> numberList;

    public NumberListDto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return new ArrayList<>(numberList);
    }
}
