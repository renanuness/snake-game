package ports;

import application.interfaces.Screen;
import domain.Command;

import java.util.Deque;
import java.util.List;

public interface InputHandler {

    Deque<Command> getCommands();
    void setCurrentScreen(Screen screen);
}
