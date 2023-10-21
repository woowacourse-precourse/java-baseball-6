package baseball.game.service;

import baseball.game.entity.Computer;
import baseball.game.entity.NumberBaseBallGameWord;
import baseball.game.exception.NumberBaseBallException;
import baseball.game.repository.ComputerRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerService {

    private final ComputerRepository computerRepository;
    private static ComputerService instance;

    private ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public static ComputerService getInstance(ComputerRepository computerRepository) {
        if (instance == null) {
            return instance = new ComputerService(computerRepository);
        }
        return instance;
    }

    public Computer playGame(Long id) {

        // 숫자야구게임 조회
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

    public String gameResult(Long id, List<Integer> userNumbers) {
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

        findComputer.changeGameCount(strikeCount, ballCount);
        computerRepository.update(findComputer);

        // 0스트라이크 0볼 이면
        if (strikeCount == 0 && ballCount == 0) {
            return NumberBaseBallGameWord.NOTHING.getKrName();
        }

        StringBuilder sb = new StringBuilder();
        // 3스트라이크 이면
        if (strikeCount == 3) {
            sb.append(strikeCount).append(NumberBaseBallGameWord.STRIKE.getKrName()).append("\n");
            sb.append(NumberBaseBallGameWord.END.getKrName());

            return sb.toString();
        }

        if (ballCount != 0) {
            sb.append(ballCount).append(NumberBaseBallGameWord.BALL.getKrName()).append(" ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append(NumberBaseBallGameWord.STRIKE.getKrName());
        }

        return sb.toString().trim();
    }
}
