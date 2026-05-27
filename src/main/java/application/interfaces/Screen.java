package domain.interfaces;

import domain.Command;

import java.util.List;

public interface Screen {
    void update(double deltaTime, List<Command> commands);
}
