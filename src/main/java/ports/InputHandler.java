package ports;

import domain.Command;

import java.util.Deque;
import java.util.List;

public interface InputHandler {

    Deque<Command> getCommands();
}
