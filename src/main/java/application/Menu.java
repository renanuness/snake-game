package application;

import application.interfaces.Screen;
import domain.Command;
import domain.Position;
import domain.UI.Button;
import ports.Renderer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Menu implements Screen {
    private final Renderer render;
    private List<Button> buttons;

    public Menu(Renderer render){
        this.render = render;
        buttons = new ArrayList<>();
        buttons.add(new Button("Start Game", 1, new Position(30, 15)));
    }

    @Override
    public void update(Deque<Command> commands) {
        render();
    }

    @Override
    public void render() {
        for(var button: buttons) {
            render.drawButton(button);
        }
    }

}


