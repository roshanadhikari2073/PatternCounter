package com.tomtom.patternchecker.IOConsoleStream.Console;

import java.util.ArrayList;
import java.util.Scanner;

import com.tomtom.patternchecker.IOConsoleStream.IOStream.IInputStream;
public class ConsolePrompt implements IInputStream {

	@Override
	public ArrayList<String> promptForInput() {
		System.out.println("Please type <path> <pattern_type>");
		ArrayList<String> args = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			args.set(i, scanner.nextLine());
		}
	return args;
	}
}
