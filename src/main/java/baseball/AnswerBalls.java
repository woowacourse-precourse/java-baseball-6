package baseball;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class AnswerBalls {
    public static final int ANSWER_LENGTH = 3;
    private static final int INPUT_MINIMUM = 1;
    private static final int INPUT_MAXIMUM = 9;

    private final List<Ball> answerBalls;

    public AnswerBalls(List<Ball> answerBalls){
        this.answerBalls = answerBalls;
    }
    // 중복 없는 세자리 랜덤값 만들기
    public static AnswerBalls makeAnswerBalls() {
        List<Ball> answerBalls = new ArrayList<>();
        Set<Integer> availableNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // 중복이 발생하지 않도록 availableNumbers 리스트에서 삭제
        while (answerBalls.size() < ANSWER_LENGTH) {
            int randomIndex = pickNumberInRange(INPUT_MINIMUM, INPUT_MAXIMUM);
            if(availableNumbers.contains(randomIndex)){
                Ball ball = new Ball(randomIndex);
                answerBalls.add(ball);
                availableNumbers.remove(randomIndex);
            }
        }
        return new AnswerBalls(answerBalls);
    }

    public static AnswerBalls makeResponseBalls(String inputString){
        List<Ball> answerBalls = new ArrayList<>();

        for(int i = 0; i < AnswerBalls.ANSWER_LENGTH; i++){
            Ball ball = new Ball(Character.getNumericValue(inputString.charAt(i)));
            answerBalls.add(ball);
            checkDuplicates(answerBalls);
        }
        return new AnswerBalls(answerBalls);
    }

    public Ball getBallOfIndex(int index){
        return answerBalls.get(index);
    }

    public boolean contains(Ball ball){
        return this.answerBalls.contains(ball);
    }

    public static void checkDuplicates(List<Ball> answerBalls){
        Map<Integer, Long> numberCountMap = answerBalls.stream().collect(Collectors.groupingBy(Ball::getNumber, Collectors.counting()));
        if (numberCountMap.values().stream().anyMatch(count -> count > 1)){
            throw new IllegalArgumentException("임의의 수 3개는 중복될 수 없습니다.");
        }
    }


}
