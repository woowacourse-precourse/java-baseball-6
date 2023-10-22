package baseball;

record Result(int ballCount, int strikeCount) {

    boolean isThreeStrike() {
        return strikeCount == Size.THREE.num;
    }

    String getResultInKorean() {
        String ball = ballCount > 0 ? ballCount + OutputMessage.BALL.message : "";
        String strike = strikeCount > 0 ? strikeCount + OutputMessage.STRIKE.message : "";

        String result = (ball.isEmpty() && strike.isEmpty()) ? OutputMessage.NOTHING.message : ball + " " + strike;
        return result.trim();
    }
}
