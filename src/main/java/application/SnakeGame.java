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
    private Board board;
    private double walkInterval = 0.2;
    private double walkClock = 0.0;
    private int score;
    private boolean paused;
    private boolean gameOver;
    // aqui eu preciso receber o tamanho do board

    public SnakeGame(Renderer render, Clock clock){
        this.render = render;
        this.clock = clock;
        var bodySize = 3;
        var initialPosition = new Position(5,5);
        var initialDirection = SnakeDirection.RIGHT;
        this.snake = new Snake(initialPosition,initialDirection, bodySize);
        score = 0;
        this.board = new Board(render.getScreenSize(), 20);
        paused = false;
        gameOver = false;
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
            }else if(command == Command.PAUSE){
                paused = !paused;
            }


        }

        if(fruit == null){
            instantiateFruit();
        }else{
            checkFruitCollision();
        }

        walkClock += clock.getDeltaTime();

        if(walkClock > walkInterval && !paused && !gameOver){
            walkClock = 0;

            if(!board.checkSnakeCollisions(snake.getBody()) || !snake.walk()){
                gameOver = true;
                //TODO:GAME OVER
            }
        }
    }

    @Override
    public void render() {
        render.drawDebugInfo();
        render.drawSnake(snake);
        render.drawBoard(board.getObstacles());
        render.drawUI(score);
        render.drawFruit(fruit);
    }

    private void checkFruitCollision(){
        if(fruit == null) return;

        if(snake.getPosition().equals(fruit.getPosition())){
            snake.addBody();
            score += 10;
            walkInterval -= 0.005;
            instantiateFruit();
        }
    }
    private void instantiateFruit(){
        Random random = new Random();
        var x = random.nextInt(59);
        var y = random.nextInt(32);
        this.fruit = new Fruit(new Position(x, y), 10);
    }


}
