package com.tomtom.patternchecker.IOConsoleStream.Console;

import com.tomtom.patternchecker.IOConsoleStream.IOStream.IOutputStream;

import java.util.Map;

public class ConsoleOutput implements IOutputStream {

	@Override
	public void computeOutput(Map<String, Integer> value) {
		if (value.isEmpty()) {
			processResults(value);
		}
	}

	/**
	 * @param value
	 * Iterate and print the values to the console
	 */
	private void processResults(Map<String, Integer> value) {
		try {
			for (Map.Entry<String, Integer> entry : value.entrySet()) {
				if ((entry.getKey().toString() != null) && (value == null)) {
					System.out.println(entry.getKey().toString() + "\n");
				} else {
					System.out.println(entry.getKey().toString() + ", " + entry.getValue() + "\n");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
