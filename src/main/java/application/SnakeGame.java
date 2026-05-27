package domain;

import domain.interfaces.Screen;

import java.util.List;

public class SnakeGame implements Screen {
    private Snake snake;
    private Fruit fruit;

    // Aqui o jogo é controlado
    // tem uma snake
    // tem um board
    // é preciso lidar com inputs aqui??
    // e possível pausar o jogo aqui tbm
    // aqui tem um udpdate que vai fazer o update de todos os itens
    // instancia a frutta
    public SnakeGame(Snake snake){
        this.snake = snake;
    }

    public void update(double deltaTime, List<Command> commands){

        if(snake.walk()){
            if(snake.getPosition().equals(fruit.getPosition())){
                //TODO: AUMENTAR O SCORE
            }
        }else{
            //TODO:GAME OVER
        }
    }

    private void instantiateFruit(){
        this.fruit = new Fruit(new Position(10, 10), 10);
    }
}
