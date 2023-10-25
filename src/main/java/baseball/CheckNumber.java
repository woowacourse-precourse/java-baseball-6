package baseball;

import java.util.List;

public class CheckNumber {

	private static final Integer NUMBER_SIZE = 3;

	public int isNumberRight(List<Integer> numberList) {
		try {
			if (numberList.size() != NUMBER_SIZE) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < numberList.size() - 1; i++) {
				for (int j = i + 1; j < numberList.size(); j++) {
					if (numberList.get(i).equals(numberList.get(j))) {
						throw new IllegalArgumentException();
					}
				}
			}
		} catch (IllegalArgumentException e) {
			return -1;
		}

		return 1;
	}

	public int selectRestartOrExit(String select)  {
		try {
			if (!select.equals("1") && !select.equals("2")) {
				throw new IllegalArgumentException();
			}

			if (select.equals("1")) {
				return 1;
			}
			return 2;
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}
}
