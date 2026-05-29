package application;

import domain.*;
import application.interfaces.Screen;
import ports.Clock;
import ports.Renderer;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public class SnakeGame implements Screen {
    private final Renderer render;
    private final Clock clock;
    private Snake snake;
    private Fruit fruit;
    private double walkInterval = 0.2;
    private double walkClock = 0.0;
    private int score;

    // aqui eu preciso receber o tamanho do board

    public SnakeGame(Renderer render, Clock clock){
        this.render = render;
        this.clock = clock;
        var bodySize = 3;
        var initialPosition = new Position(5,5);
        var initialDirection = SnakeDirection.RIGHT;
        this.snake = new Snake(initialPosition,initialDirection, bodySize);
        score = 0;
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

        if(fruit == null){
            instantiateFruit();
        }else{
            checkFruitCollision();
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
        render.drawDebugInfo();
        render.drawSnake(snake);
        render.drawFruit(fruit);
    }

    private void checkFruitCollision(){
        if(fruit == null) return;

        if(snake.getPosition().equals(fruit.getPosition())){
            snake.addBody();
            score += 10;
            instantiateFruit();
        }
    }
    private void instantiateFruit(){
        Random random = new Random();
        var x = random.nextInt(60);
        var y = random.nextInt(60);
        x = 59;
        y = 32;
        this.fruit = new Fruit(new Position(x, y), 10);
    }


}
