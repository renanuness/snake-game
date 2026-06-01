package application.interfaces;

import domain.Command;
import domain.MouseClick;
import domain.UI.Button;

import java.util.Deque;
import java.util.List;

public interface Screen {
    void update(Deque<Command> commands);
    void render();
    List<Button> getButtons();

}
