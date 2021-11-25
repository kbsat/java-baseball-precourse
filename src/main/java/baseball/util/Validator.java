package baseball.util;

public class Validator {
	static final int NUM_LEN_LIMIT = 3;

	public static void valid(int[] input) {
		// 1.3자리 수인지 확인
		if (!checkRange(input, NUM_LEN_LIMIT)) {
			throw new IllegalArgumentException("지정된 수의 크기에서 벗어났습니다.");
		}
		// 2.각 자리의 숫자가 범위가 넘어갔는지 확인 ( 0이 포함되어있는지 )
		if (!checkContainZero(input)) {
			throw new IllegalArgumentException("입력한 수에 0이 포함되어있습니다.");
		}
		// 3.각 자리 수가 중복되는지 확인
		if (!checkDup(input)) {
			throw new IllegalArgumentException("중복된 수가 존재합니다.");
		}
	}

	public static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}

	private static boolean checkRange(int[] numArr, int len) {
		return numArr.length == len;
	}

	private static boolean checkContainZero(int[] numArr) {
		for (int num : numArr) {
			if (num == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkDup(int[] numArr) {
		DupChecker dupChecker = new DupChecker();
		for (int num : numArr) {
			if (!dupChecker.check(num)) {
				return false;
			}
		}
		return true;
	}
}
