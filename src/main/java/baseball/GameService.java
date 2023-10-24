package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임 과정(컴퓨터, 사용자 수 세팅 및 비교)에 대한 클래스
 */
public class GameService {
    private final GameRepository gameRepository = new GameRepository();

    /**
     * 컴퓨터, 사용자 수 세팅 메소드 호출, 비교 및 비교 결과 출력
     */
    public void playGame() {
        gameRepository.setComputer();
        boolean gameSet = false;
        // 컴퓨터 수 == 사용자 수일 시 loop break
        while (!gameSet) {
            gameRepository.setUser();
            gameRepository.setScore();
            gameSet = gameRepository.printScore();
        }
    }

    /**
     * 게임 종료 후 문구 출력, 게임 재시작 / 종료 여부를 입력받아 리턴
     * @return 사용자의 게임 재시작 여부, true = 재시작, false = 종료
     * @throws IllegalArgumentException 사용자 유효하지 않은 값 입력 시 예외 발생
     */
    public boolean exit() throws IllegalArgumentException {
        // 게임 종료 문구 출력, 개임 재시작 / 종료 여부를 사용자로부터 입력받음
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        // 1 : 재시작, 2 : 종료, 그 외 : 예외 발생
        if (!(input.equals("1") || (input.equals("2")))) {
            throw new IllegalArgumentException();
        }
        if (input.equals("2")) {
            Console.close();
            return false;
        }
        return true;
    }
}
