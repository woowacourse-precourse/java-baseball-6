package baseball.game.service;

import baseball.game.entity.Computer;
import baseball.game.entity.GameScore;
import baseball.game.exception.NumberBaseBallException;
import baseball.game.repository.ComputerRepository;
import baseball.game.repository.GameResultRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerService {

    private final ComputerRepository computerRepository;
    private final GameResultRepository gameResultRepository;
    private static ComputerService instance;

    private ComputerService(ComputerRepository computerRepository, GameResultRepository gameResultRepository) {
        this.computerRepository = computerRepository;
        this.gameResultRepository = gameResultRepository;
    }

    public static ComputerService getInstance(ComputerRepository computerRepository,
                                              GameResultRepository gameResultRepository) {
        if (instance == null) {
            return instance = new ComputerService(computerRepository, gameResultRepository);
        }
        return instance;
    }

    public Computer createGame(Long id) {

        // 숫자 야구게임 조회
        Optional<Computer> optionalComputer = computerRepository.findBy(id);
        if (optionalComputer.isPresent()) {
            return optionalComputer.get();
        }

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        Computer computer = Computer.create(id, numbers);
        return computerRepository.save(computer);
    }

    public String startGame(Long id, List<Integer> userNumbers) {
        // 숫자야구게임 조회
        Computer findComputer = computerRepository.findBy(id)
                .orElseThrow(() -> new NumberBaseBallException(NumberBaseBallException.NOT_FOUND));

        // 컴퓨터 숫자 조회
        List<Integer> gameNumbers = findComputer.getNumbers();

        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < gameNumbers.size(); i++) {
            int gameNum = gameNumbers.get(i);

            for (int j = 0; j < userNumbers.size(); j++) {
                int userNum = userNumbers.get(j);

                if (i == j && gameNum == userNum) {
                    // 스트라이크
                    strikeCount++;
                    break;
                } else if (gameNum == userNum) {
                    // 볼
                    ballCount++;
                    break;
                }
            }
        }

        // 컴퓨터 스트라이크, 볼 카운트 갱신
        findComputer.changeStrikeAndBallCount(strikeCount, ballCount);
        computerRepository.update(findComputer);

        GameScore gameScore = new GameScore(findComputer.getStrikeCount(), findComputer.getBallCount());

        return getGameResult(gameScore);
    }

    private String getGameResult(GameScore gameScore) {
        return gameResultRepository.getGameResultMessage(gameScore);
    }
}
