package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class BaseBalls {
    private List<BaseBall> numbers;
    public static final int SIZE = 3;

    public BaseBalls(List<BaseBall> numbers){
        validateSize();
        validateDuplication();
        this.numbers = numbers;
    }

    public static BaseBalls getAnswerBaseBallNumbers(){
        return new BaseBalls(NumberGenerator.generateAnswerNumbers());
    }

    public static BaseBalls getUserBaseBallNumbers(String input){
        return new BaseBalls(NumberGenerator.generateUserNumbers(input));
    }

    private void validateSize(){
        if(numbers.size() != SIZE){
            throw new IllegalArgumentException("숫자의 길이는 3이여야합니다.");
        }
    }

    private void validateDuplication(){
        if(numbers.stream().distinct().count() != SIZE){
            throw new IllegalArgumentException("중복되는 숫자없이, 서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    // 스트라이크 : 인덱스 값, 실제 값 모두 똑같아야함
    public int getStrikeCounts(BaseBalls otherBaseBalls){
        return (int) IntStream.range(0, SIZE)
                .filter(index -> numbers.get(index).equals(otherBaseBalls.numbers.get(index)))
                .count();
    }

    // 볼 : 실제 값은 같으나, 인덱스 값이 다르다.
    // 1) answer 가 포함하는 것을 필터링
    // 2) 스트라이크인 것을 필터링 (인덱스 값, 실제 값 모두 똑같은 것)
    public int getBallCounts(BaseBalls otherBaseBalls){
        return (int) IntStream.range(0, SIZE)
                .filter(index -> numbers.contains(otherBaseBalls.numbers.get(index)))
                .filter(index -> !numbers.get(index).equals(otherBaseBalls.numbers.get(index)))
                .count();
    }
}
