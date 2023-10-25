package baseball;

public abstract class Game { // 추상 클래스로 선언하여 여러 게임에 사용할 수 있도록 기본 설정 명시
    abstract boolean initGame();

    abstract void playGame();
}
