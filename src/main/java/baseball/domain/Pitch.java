package baseball.domain;

import java.util.List;

public class Pitch extends DefaultData{
    /**
     * 사용자 입력 값을 기반으로 사용자의 투구 정보를 담는 객체
     * @see DefaultData
     * @throws IllegalArgumentException : MAX_LENGTH 가 아닌 리스트가 들어올 경우
     */
    public Pitch(List<Integer> inputNumberList) {
        super();
        if (!(inputNumberList.size() == MAX_LENGTH)) {
            throw new IllegalArgumentException();
        }
        validateNumbers(inputNumberList);
        setNumberList(inputNumberList);
    }

    private void validateNumbers(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();
        if (uniqueCount != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getPitches() {
        return numberList;
    }
}
