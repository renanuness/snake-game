package infrastructure;

import domain.Command;
import ports.InputHandler;

import java.util.*;

import static com.raylib.Raylib.*;

public class RaylibInputHandler implements InputHandler {
    private Map<Integer, Command> keyToCommand = new HashMap<>();

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
        for(var c: commands){
            System.out.println(c);
        }
        return commands;
    }
}
