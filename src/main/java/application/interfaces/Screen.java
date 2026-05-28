package application.interfaces;

import domain.Command;

import java.util.Deque;
import java.util.List;

public interface Screen {
    void update(Deque<Command> commands);
    void render();
}
