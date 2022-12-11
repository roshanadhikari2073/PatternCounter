package com.tomtom.patternchecker.main;

import com.tomtom.patternchecker.IOConsoleStream.Console.ConsoleOutput;
import com.tomtom.patternchecker.IOConsoleStream.Console.ConsolePrompt;
import com.tomtom.patternchecker.IOConsoleStream.IOStream.IOStream;

import java.util.ArrayList;

public class Application {
	
public static void main(String[] args) {
	IOStream ioStream = new IOStream(new ConsolePrompt(), new ConsoleOutput());
	ArrayList<String> userInput = ioStream.promptForInput();
}
}
