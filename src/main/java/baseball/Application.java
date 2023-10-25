package baseball;

public class Application {

    public static void main(String[] args) {

        final int NUMBER_OF_DIGITS = 3;

        final Store store = new Store();
        final Message message = new Message();
        final Game game = new Game(store, NUMBER_OF_DIGITS);

        // 게임 시작
        message.printStart();

        do {
            // 게임 초기화
            store.initGame();
            // 정답 생성
            game.generateAnswer();

            do {
                // 결과 초기화
                store.initInputAndResult();
                // 숫자 입력
                store.saveInput(message.inputNumber());
                // 정답 비교
                game.compareAnswer();
                // 결과 출력
                message.printResult(store);
            } while (store.result.getOrDefault("스트라이크", 0) != NUMBER_OF_DIGITS);

            // 정답 메시지 출력
            message.ifWin(store, NUMBER_OF_DIGITS);

            // 게임 진행 여부
        } while (!message.printProcess().equals("2"));

        // 게임 종료
        message.printEnd();
    }

}
