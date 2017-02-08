package com.checkoutsystem.print;

public class PrintUtil {

	private final static String TOTAL_PREFIX_TEXT = "Total: \u00a3";

	public static void printTotal(int total) {
		System.out.printf(TOTAL_PREFIX_TEXT +"%.2f\n", total / 100.0);
	}

	public static String getTotalPrefixText() {
		return TOTAL_PREFIX_TEXT;
	}
}
