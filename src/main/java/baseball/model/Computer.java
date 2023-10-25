package baseball.model;

import java.util.List;

/**
 * 컴퓨터가 야구 게임에서 사용하는 숫자들을 관리하는 클래스입니다.
 *
 * <p>컴퓨터는 게임을 진행하는 동안 선정된 숫자들을 보관하며,
 * 필요한 경우 이를 재설정하는 기능을 제공합니다.</p>
 */
public class Computer {

    private List<Integer> selectedNumbers;

    /**
     * 주어진 숫자 목록을 사용하여 컴퓨터 객체를 초기화합니다.
     *
     * @param selectedNumbers 컴퓨터가 선택한 숫자 목록
     */
    public Computer(List<Integer> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    /**
     * 현재 컴퓨터가 선택한 숫자 목록을 반환합니다.
     *
     * @return 선택된 숫자 목록
     */
    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    /**
     * 컴퓨터의 숫자 목록을 주어진 새로운 숫자 목록으로 재설정합니다.
     *
     * @param newNumbers 새로운 숫자 목록
     */
    public void resetNumbers(List<Integer> newNumbers) {
        this.selectedNumbers = newNumbers;
    }
}
