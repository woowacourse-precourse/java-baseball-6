package baseball.service;

import baseball.repository.ComputerBaseballGameNumberRepository;
import baseball.vo.enums.GameNumberInclusive;
import baseball.vo.enums.GameRule;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBaseballService {
	private ComputerBaseballGameNumberRepository computerBaseballGameNumberRepository;

	private ComputerBaseballService() {
	}

	private static class ComputerBaseballServiceHolder {
		private static final ComputerBaseballService COMPUTER_BASEBALL_SERVICE = new ComputerBaseballService();
	}

	public static ComputerBaseballService getInstance() {
		return ComputerBaseballServiceHolder.COMPUTER_BASEBALL_SERVICE;
	}

	public void createNewBaseballGameNumberList() {
		this.computerBaseballGameNumberRepository =
				ComputerBaseballGameNumberRepository.builder()
						.getComputerBaseballGameNumberList(initBaseballGameNumberList())
						.build();
	}

	private List<Integer> initBaseballGameNumberList() {
		final Set<Integer> baseballGameNumberSet = new HashSet<>();

		do {
			baseballGameNumberSet.add(Randoms.pickNumberInRange(GameNumberInclusive.START.getValue(),
					GameNumberInclusive.END.getValue()));
		} while (baseballGameNumberSet.size() < GameRule.GAME_NUMBER_LEN.getValue());

		return new ArrayList<>(baseballGameNumberSet);
	}

	public List<Integer> getComputerBaseballGameNumberList() {
		if (this.computerBaseballGameNumberRepository == null) {
			this.createNewBaseballGameNumberList();
		}
		return computerBaseballGameNumberRepository.getComputerBaseballGameNumberList();
	}
	
	public Integer[] getGameResult(List<Integer> computerBaseballGameNumberList) {
		Integer[] gameResult = {0, 0};
		List<Integer> playerInputNumberList = OperatorService.getInstance().getPlayerGameNumberList();

		for (int i = 0; i < playerInputNumberList.size(); i++) {
			Integer findIndex = computerBaseballGameNumberList.indexOf(playerInputNumberList.get(i));
			if (findIndex == -1) continue;
			if (findIndex != i) ++gameResult[0]; // 볼
			if (findIndex == i) ++gameResult[1]; // 스트라이크
		}
		return gameResult;
	}
}
