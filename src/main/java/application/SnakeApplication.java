package application;

import application.interfaces.Screen;
import domain.Command;
import ports.Clock;
import ports.InputHandler;
import ports.Renderer;

import java.util.Deque;
import java.util.List;

public class SnakeApplication {

    private Screen currentScreen;

    private SnakeGame snakeGame;

    // aqui eu preciso saber em qual tela estou
    // saber quais inputs foram recebidas
    // preciso chamar o estado atual para repassar os commands e o tempo
    //
    public SnakeApplication(SnakeGame snakeGame){
        this.snakeGame = snakeGame;
        currentScreen = snakeGame;
    }

    public void update(Deque<Command> commands){

        currentScreen.update(commands);
    }

    public void render(){
        currentScreen.render();
    }
}


// TELAS:
// Start Menu
// Configurações
// Game
// Game over
