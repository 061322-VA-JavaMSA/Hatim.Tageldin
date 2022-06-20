package demop;

import exceptions.DivideBy0Exception;

public class Calculator {
	/*
	 * - add(int a, int b) - if the result is 13 - throw an exception -
	 * 
	 * Number13Exception - subtract - multiply - sum of an array - divide - throw a
	 * custom exception if divided by 0
	 */
	

	

	public int add(int a, int b) {
		return a + b;
	}

	

	public int subtract(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {
		if (b == 0) {
			throw new DivideBy0Exception();
		}
		return (int) a / (int) b;
	}

	public int sumOfAnArray(int[] intArr) {
		int sum = 0;

		int[] numbers = { 1, 2, 3, 4 };
		for (int i : numbers) {
			sum += i;
		}

		return sum;
	}
	
	public int multiplyBy0Exception(int[] mulArr) {
		int msum = 0;
		int[] msum1 = {1, 2, 3};
		for(int i : msum1) {
			msum += i;
		}
		return 0;
		
	}
	
	

	
}