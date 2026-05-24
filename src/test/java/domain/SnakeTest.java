package domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    private Position initialPosition = new Position(5,5);
    //region Moving right
    @Test
    public void going_right_receive_up_should_go_up(){
        Snake snake = new Snake(initialPosition, SnakeDirection.RIGHT, 3);
        snake.moveUp();
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_right_receive_left_should_continue_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.moveLeft();
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_right_receive_down_should_go_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.moveDown();
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_right_receive_right_should_continue_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.moveRight();
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }
    //endregion

    //region Moving left
    @Test
    public void going_left_receive_up_should_go_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.moveUp();
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_left_receive_left_should_continue_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.moveLeft();
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_left_receive_down_should_go_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.moveDown();
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_left_receive_right_should_continue_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.moveRight();
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    //endregion

    //region Moving down
    @Test
    public void going_down_receive_left_should_go_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.moveLeft();
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_down_receive_up_should_continue_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.moveUp();
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_down_receive_right_should_go_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.moveRight();
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_down_receive_down_should_continue_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.moveDown();
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }
    //endregion

    //region Moving up
    @Test
    public void going_up_receive_left_should_go_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.moveLeft();
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_up_receive_down_should_continue_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.moveDown();
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_up_receive_right_should_go_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.moveRight();
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_up_receive_up_should_continue_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.moveUp();
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }
    //endregion

    // Se a posição é x e y e a cobra está indo pra direit, então a posição no proximo frame deve ser x+1 e y
    @Test
    public void going_up_next_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.walk();
        assertEquals(6, snake.getPosition().y);
        assertEquals(5, snake.getPosition().x);
    }
    // Se a posição é x e y e a cobra está indo pra esquerda, então a posição no proximo frame deve ser x-1 e y
    @Test
    public void going_right_walk_three_turn_down_walk_three_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.walk();
        snake.walk();
        snake.walk();
        snake.moveDown();
        snake.walk();
        snake.walk();
        snake.walk();
        assertEquals(2, snake.getPosition().y);
        assertEquals(8, snake.getPosition().x);
    }

    @Test
    public void going_down_walk_three_turn_left_walk_three_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.walk();
        snake.walk();
        snake.walk();
        snake.moveLeft();
        snake.walk();
        snake.walk();
        snake.walk();
        assertEquals(2, snake.getPosition().y);
        assertEquals(2, snake.getPosition().x);
    }
    // Se a posição é x e y e a cobra está indo pra cima, então a posição no proximo frame deve ser x e y+1
    // Se a posição é x e y e a cobra está indo pra baixo, então a posição no proximo frame deve ser x e y-1
}
