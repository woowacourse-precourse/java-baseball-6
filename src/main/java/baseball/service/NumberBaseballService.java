package baseball.service;

import baseball.constant.Constant;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.ResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.ReGameInputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {

    /**
     * 객체 생성 시 outputView, inputView 객체 할당
     */
    private final OutputView outputView;
    private final InputView inputView;

    public NumberBaseballService() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    /**
     * 랜덤 답안 생성 및 사용자 입력을 통한 숫자야구 게임 진행
     *
     * @func calculateResult() : 컴퓨터와 사용자 입력값 비교 후 결과 반환
     * @func isReGame() : 컴퓨터의 숫자와 입력값이 순서까지 일치하는 경우, 게임진행여부 확인
     */
    public void gameStart() {
        outputView.printStartMessage();
        ComputerNumber computerNumber = new ComputerNumber(generateGameNumbers());
        boolean end = false;
        while (!end) {
            PlayerNumber playerNumber = new PlayerNumber(inputView.generateInputList());
            ResultDTO resultDTO = calculateResult(computerNumber.getComputerNumbers(),
                    playerNumber.getPlayerNumbers());
            outputView.printResult(resultDTO);
            if (resultDTO.getStrikeCount() == Constant.GAME_NUMBERS_SIZE) {
                end = true;
            }
            if (end && isReGame()) {
                computerNumber = new ComputerNumber(generateGameNumbers());
                end = false;
            }
        }
    }

    /**
     * 한 사이클의 숫자야구게임에서 정답으로 사용될 랜덤 숫자 List 생성
     *
     * @return : 숫자야구게임 정답으로 사용될 랜덤 숫자 List Collection 반환
     */
    public List<Integer> generateGameNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.START_RANGE, Constant.END_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자가 입력한 수와 정답을 비교하여 그 결과를 반환하는 함수
     *
     * @param computerNumbers : 컴퓨터가 정답으로 가지고 있는 랜덤 수
     * @param inputNumbers    : 사용자가 입력한 수
     * @return :Strike, Ball 결과를 담은 객체를 DTO로 반환
     */
    public ResultDTO calculateResult(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0, ballCount = 0;
        for (int i = 0; i < Constant.GAME_NUMBERS_SIZE; ++i) {
            if (computerNumbers.contains(inputNumbers.get(i)) && (computerNumbers.get(i) == inputNumbers.get(i))) {
                ++strikeCount;
            }
            if (computerNumbers.contains(inputNumbers.get(i)) && (computerNumbers.get(i) != inputNumbers.get(i))) {
                ++ballCount;
            }
        }
        return new ResultDTO(strikeCount, ballCount);
    }

    /**
     * 한 사이클의 게임 종료 후, 게임 재시작 여부를 묻는 메서드
     *
     * @return : 게임을 재시작할거면 true(1), 종료할거면 false(0) 반환
     */
    public boolean isReGame() {
        outputView.printEndMessage();
        ReGameInputView reGameInputView = new ReGameInputView();
        return reGameInputView.inputReGameCommand().equals("1");
    }
}
