package game;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {
	private final int index;
	private final int number;

	private final static int MIN_NUMBER = 1;
	private final static int MAX_NUMBER = 9;

	public BallNumber(int index, int number) {
		if(number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalStateException("공의 숫자는 1~9까지만 가능합니다");
		}

		this.index = index;
		this.number = number;
	}

	public static List<Integer> combine(String[] values) {
		List<Integer> list = new ArrayList<>();

		for(int i=1; i<=3; i++) {
			list.add(Integer.parseInt(values[i-1]));
		}

		return list;
	}

	public int getIndex() {
		return index;
	}

	public int getNumber() {
		return number;
	}
}
