package application;

import domain.*;
import application.interfaces.Screen;
import ports.Clock;
import ports.Renderer;

import java.util.Deque;
import java.util.List;

public class SnakeGame implements Screen {
    private final Renderer render;
    private final Clock clock;
    private Snake snake;
    private Fruit fruit;
    private double walkInterval = 0.2;
    private double walkClock = 0.0;
    // Aqui o jogo é controlado
    // tem uma snake
    // tem um board
    // é preciso lidar com inputs aqui??
    // e possível pausar o jogo aqui tbm
    // aqui tem um udpdate que vai fazer o update de todos os itens
    // instancia a frutta
    public SnakeGame(Renderer render, Clock clock){
        this.render = render;
        this.clock = clock;
        var bodySize = 3;
        var initialPosition = new Position(5,5);
        var initialDirection = SnakeDirection.RIGHT;
        this.snake = new Snake(initialPosition,initialDirection, bodySize);
    }

    public void update(Deque<Command> commands){
        while(commands.size() > 0){
            var command = commands.pop();
            if(command == Command.MOVE_DOWN){
                snake.addDirectionChange(SnakeDirection.DOWN);
            }
            else if(command == Command.MOVE_UP){
                snake.addDirectionChange(SnakeDirection.UP);
            }
            else if(command == Command.MOVE_LEFT){
                snake.addDirectionChange(SnakeDirection.LEFT);
            }
            else if(command == Command.MOVE_RIGHT){
                snake.addDirectionChange(SnakeDirection.RIGHT);
            }
        }

        walkClock += clock.getDeltaTime();
        if(walkClock > walkInterval){
            walkClock = 0;

            if(snake.walk()){


            }else{
                //TODO:GAME OVER
            }
        }
    }

    @Override
    public void render() {
        render.drawSnake(snake);
    }

    private void checkFruitCollision(){
        if(fruit == null) return;

        if(snake.getPosition().equals(fruit.getPosition())){
            //TODO: AUMENTAR O SCORE
        }
    }
    private void instantiateFruit(){
        this.fruit = new Fruit(new Position(10, 10), 10);
    }
}
