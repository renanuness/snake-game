package infrastructure;

import application.interfaces.Screen;
import domain.Command;
import domain.MouseClick;
import domain.Position;
import ports.InputHandler;

import java.util.*;

import static com.raylib.Raylib.*;

public class RaylibInputHandler implements InputHandler {
    private Map<Integer, Command> keyToCommand = new HashMap<>();
    private MouseClick mouseClick;
    private Screen currentScreen;
    // Recebe os buttons aqui;

    public RaylibInputHandler(){
        setBinding(KEY_RIGHT, Command.MOVE_RIGHT);
        setBinding(KEY_LEFT, Command.MOVE_LEFT);
        setBinding(KEY_UP, Command.MOVE_UP);
        setBinding(KEY_DOWN, Command.MOVE_DOWN);
        setBinding(KEY_D, Command.MOVE_RIGHT);
        setBinding(KEY_A, Command.MOVE_LEFT);
        setBinding(KEY_W, Command.MOVE_UP);
        setBinding(KEY_S, Command.MOVE_DOWN);
        setBinding(KEY_P, Command.PAUSE);
    }
    public void setCurrentScreen(Screen screen){
        currentScreen = screen;
    }

    public void setBinding(int raylibKey, Command command){
        keyToCommand.put(raylibKey, command);
    }
    @Override
    public Deque<Command> getCommands(){
        var commands = new ArrayDeque<Command>();

        for(var entry: keyToCommand.entrySet()){
            if(IsKeyPressed(entry.getKey())){
                commands.push(entry.getValue());
            }
        }


        if(currentScreen != null) {
            var raytlibMousePosition = GetMousePosition();
            var mousePosition = new Position((int) raytlibMousePosition.x(), (int) raytlibMousePosition.y());
            var mouseClicks = new ArrayDeque<MouseClick>();
            if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                mouseClicks.push(new MouseClick(0, mousePosition));
            }

            for(var mouseClick : mouseClicks) {
                for(var button: currentScreen.getButtons()){
                    if()
                    button.click();
                }
                // checar se cada click foi dado em algum dos botões
            }
        }
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_MIDDLE)) ballColor = LIME;
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_RIGHT)) ballColor = DARKBLUE;
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_SIDE)) ballColor = PURPLE;
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_EXTRA)) ballColor = YELLOW;
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_FORWARD)) ballColor = ORANGE;
//        else if (IsMouseButtonPressed(MOUSE_BUTTON_BACK)) ballColor = BEIGE;


        return commands;
    }

}
