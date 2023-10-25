package baseball;

import java.util.HashSet;
import java.util.Set;

public class DuplicateChecker {

	// 배열 전체에서 중복을 체크하는 메서드
	public static boolean containsDuplicates(int[] arr) {
		
		Set<Integer> set = new HashSet<>();

		for (int val : arr) {
			if (set.contains(val)) {
				return true;
			}
			set.add(val);
		}

		return false;
	}

	// 배열에서 특정 값을 제외하고 중복을 체크하는 메서드
	public static boolean containsDuplicatesExcept(int[] arr, int val, int exval) {
		
		for (int i = 0; i < arr.length; i++) {
			if (i != exval && arr[i] == val) {
				return true;
			}
		}
		return false;
	}
}