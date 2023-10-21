package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
					List<Integer> user = setUserNumber(readLine());     // 사용자 숫자 중복 체크 필요

					if (checkResult(computer, user)) {
						break;
					}
				}

				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

				if (Integer.parseInt(readLine()) != 1) {
					flag = false;
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("숫자만 입력가능합니다.");
			System.out.println("프로그램을 종료합니다.");
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException(e);
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

	public static boolean checkResult(List<Integer> computer, List<Integer> user) {
		int ball = 0;
		int strike = 0;

		for (int i = 0; i < 3; i++) {
			if (computer.get(i).equals(user.get(i))) {
				strike++;
			} else {
				if (computer.contains(user.get(i))) {
					ball++;
				}
			}
		}

		if (strike == 3) {
			System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

			return true;
		} else {
			if (ball == 0 && strike == 0) {
				System.out.println("낫싱");
			} else {
				if (ball > 0) {
					System.out.print(ball + "볼 ");
				}

				if (strike > 0) {
					System.out.print(strike + "스트라이크");
				}
				System.out.println();
			}

		}
		return false;
	}
}