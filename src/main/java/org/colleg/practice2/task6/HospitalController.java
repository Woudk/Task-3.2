package org.colleg.practice2.task6;

import java.util.ArrayList;
import java.util.List;

public class HospitalController {
    private List<AbstractCommand> commandsToExecute = new ArrayList<>();
    private List<AbstractCommand> commandHistory = new ArrayList<>();

    public void addCommand(AbstractCommand command) {
        commandsToExecute.add(command);
    }

    public void removeCommand(AbstractCommand command) {
        commandsToExecute.remove(command);
    }

    public void executeAllPendingCommands() {
        for (AbstractCommand command : commandsToExecute) {
            command.execute();
            commandHistory.add(command);
        }
        commandsToExecute.clear();
    }

    public void undoChanges(int changesToUndo) {
        for (int i = 0; i < changesToUndo && !commandHistory.isEmpty(); i++) {
            AbstractCommand command = commandHistory.remove(commandHistory.size() - 1);
            command.undo();
        }
    }
}
