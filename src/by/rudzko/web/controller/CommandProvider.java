package by.rudzko.web.controller;

import java.util.HashMap;
import java.util.Map;

import by.rudzko.web.controller.command.Command;
import by.rudzko.web.controller.command.implementation.FindUserCommand;

public class CommandProvider {
	
	private static Map <CommandName, Command> commands;
	private static  CommandProvider provider = new CommandProvider();
	
	private CommandProvider() {
		commands = new HashMap<CommandName, Command>();
		commands.put(CommandName.FINDUSER, new FindUserCommand());
	}
	
	public static Command getCommand (String key) {
		return commands.get(CommandName.valueOf(key.toUpperCase()));
	}
}
