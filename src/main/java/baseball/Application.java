package baseball;

public class Application {

    public static void main(String[] args) {

        final Store store = new Store();
        final Printer printer = new Printer();
        final Game game = new Game(store);

        // 게임 시작
        printer.printStart();

        do {
            // 게임 초기화
            store.initGame();
            // 정답 생성
            game.generateAnswer();

            do {
                // 결과 초기화
                store.initInputAndResult();
                // 숫자 입력
                store.saveInput(printer.inputNumber());
                // 정답 비교
                game.compareAnswer();
                // 결과 출력
                printer.printResult(store);
            } while (!game.checkCorrect());

            // 정답 메시지 출력
            printer.ifWin(store);

            // 게임 진행 여부
        } while (!game.checkGameEnd(printer.printProcess()));

        // 게임 종료
        printer.printEnd();
    }

}
