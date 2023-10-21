package baseball;

record Result(int ballCount, int strikeCount) {

    boolean isThreeStrike() {
        return strikeCount == Size.THREE.num;
    }

    String getResultInKorean() {
        if(ballCount > 0 && strikeCount > 0)
            return ballCount + OutputMessage.BALL.message + " " + strikeCount + OutputMessage.STRIKE.message;
        else if (ballCount > 0)
            return ballCount + OutputMessage.BALL.message;
        else if (strikeCount > 0)
            return strikeCount + OutputMessage.STRIKE.message;
        else return OutputMessage.NOTHING.message;
    }
}
