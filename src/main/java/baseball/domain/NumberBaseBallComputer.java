package baseball.domain;

public class NumberBaseBallComputer extends Computer {

    @Override
    public Result calculateResult(User user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (user.contains(number) && user.isSamePosition(number, index)) {
                strikeCount++;
            }
            if (user.contains(number) && !user.isSamePosition(number, index)) {
                ballCount++;
            }
        }

        return new Result(strikeCount, ballCount);
    }

}
