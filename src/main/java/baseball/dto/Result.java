package baseball.dto;

public record Result(int ballCount, int strikeCount) {  //보일러 플레이트 코드 비대해지는 것 방지 record 사용
    private static final int BASEBALL_SIZE = 3;
    private static final int ZERO_COUNT = 0;
    private static final String NO_CONUT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";

    @Override
    public String toString(){
        if ()
    }

    public boolean allStrike(){
        return BASEBALL_SIZE == strikeCount;    //3개 전부 스트라이크
    }



}
