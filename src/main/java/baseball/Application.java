package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {
		boolean flag = true;

		try {
			while (flag) {
				List<Integer> computer = new ArrayList<>();
				setComputerNumber(computer);
				System.out.println("숫자 야구 게임을 시작합니다.");

				while (true) {
					System.out.print("숫자를 입력해주세요 : ");
					List<Integer> user = setUserNumber(readLine());
				}

				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

				if (Integer.parseInt(readLine()) != 1) {
					flag = false;
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("숫자만 입력가능합니다.");
			System.out.println("프로그램을 종료합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setComputerNumber(List<Integer> computer) {
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}

	public static List<Integer> setUserNumber(String str) throws IllegalArgumentException {
		List<Integer> user = new ArrayList<>();
		String[] input = str.split("");
		for (String s : input) {
			user.add(Integer.parseInt(s));
		}
		return user;
	}
}
