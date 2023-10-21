package baseball;

record Result(int ballCount, int strikeCount) {

    boolean isThreeStrike() {
        return strikeCount == Size.THREE.num;
    }

}
