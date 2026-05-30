package domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    private Position initialPosition = new Position(5,5);
    //region Moving right
    @Test
    public void going_right_receive_up_should_go_up(){
        Snake snake = new Snake(initialPosition, SnakeDirection.RIGHT, 3);
        snake.addDirectionChange(SnakeDirection.UP);
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_right_receive_left_should_continue_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.addDirectionChange(SnakeDirection.LEFT);
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_right_receive_down_should_go_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.addDirectionChange(SnakeDirection.DOWN);
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_right_receive_right_should_continue_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        snake.addDirectionChange(SnakeDirection.RIGHT);
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }
    //endregion

    //region Moving left
    @Test
    public void going_left_receive_up_should_go_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.addDirectionChange(SnakeDirection.UP);
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_left_receive_left_should_continue_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.addDirectionChange(SnakeDirection.LEFT);
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_left_receive_down_should_go_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.addDirectionChange(SnakeDirection.DOWN);
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_left_receive_right_should_continue_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.LEFT, 3);
        snake.addDirectionChange(SnakeDirection.RIGHT);
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    //endregion

    //region Moving down
    @Test
    public void going_down_receive_left_should_go_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.addDirectionChange(SnakeDirection.LEFT);
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_down_receive_up_should_continue_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.addDirectionChange(SnakeDirection.UP);
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }

    @Test
    public void going_down_receive_right_should_go_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.addDirectionChange(SnakeDirection.RIGHT);
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_down_receive_down_should_continue_down(){
        Snake snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        snake.addDirectionChange(SnakeDirection.DOWN);
        snake.walk();
        assertEquals(SnakeDirection.DOWN, snake.getDirection());
    }
    //endregion

    //region Moving up
    @Test
    public void going_up_receive_left_should_go_left(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.addDirectionChange(SnakeDirection.LEFT);
        snake.walk();
        assertEquals(SnakeDirection.LEFT, snake.getDirection());
    }

    @Test
    public void going_up_receive_down_should_continue_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.addDirectionChange(SnakeDirection.DOWN);
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }

    @Test
    public void going_up_receive_right_should_go_right(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.addDirectionChange(SnakeDirection.RIGHT);
        snake.walk();
        assertEquals(SnakeDirection.RIGHT, snake.getDirection());
    }

    @Test
    public void going_up_receive_up_should_continue_up(){
        Snake snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.addDirectionChange(SnakeDirection.UP);
        snake.walk();
        assertEquals(SnakeDirection.UP, snake.getDirection());
    }
    //endregion


    @Test
    public void going_up_next_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.UP, 3);
        snake.walk();
        assertEquals(4, snake.getPosition().y);
        assertEquals(5, snake.getPosition().x);
    }

    @Test
    public void going_right_walk_three_turn_down_walk_three_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.RIGHT, 3);
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        snake.addDirectionChange(SnakeDirection.DOWN);
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        assertTrue(snake.walk());

        //region Move initialPosition
        initialPosition.move(SnakeDirection.RIGHT);
        initialPosition.move(SnakeDirection.RIGHT);
        initialPosition.move(SnakeDirection.RIGHT);
        initialPosition.move(SnakeDirection.DOWN);
        initialPosition.move(SnakeDirection.DOWN);
        initialPosition.move(SnakeDirection.DOWN);
        //endregion

        assertTrue(snake.getPosition().equals(initialPosition));
        assertTrue(snake.getPosition().equals(initialPosition));

        var body = snake.getBody().getBody();
        for(var sp: body) {
            assertTrue(sp.getPosition().equals(initialPosition));
            initialPosition.move(SnakeDirection.UP);
        }
    }

    @Test
    public void going_down_walk_three_turn_left_walk_three_position_is_correct(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.DOWN, 3);
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        snake.addDirectionChange(SnakeDirection.LEFT);
        assertTrue(snake.walk());
        assertTrue(snake.walk());
        assertTrue(snake.walk());

        //region Move initialPosition
        initialPosition.move(SnakeDirection.DOWN);
        initialPosition.move(SnakeDirection.DOWN);
        initialPosition.move(SnakeDirection.DOWN);
        initialPosition.move(SnakeDirection.LEFT);
        initialPosition.move(SnakeDirection.LEFT);
        initialPosition.move(SnakeDirection.LEFT);

        //endregion

        assertTrue(snake.getPosition().equals(initialPosition));
    }

    @Test
    public void colliding_it_self_cant_move(){
        var initialPosition = new Position(5,5);
        var snake = new Snake(initialPosition,SnakeDirection.DOWN, 4);

        snake.addDirectionChange(SnakeDirection.LEFT);
        snake.addDirectionChange(SnakeDirection.UP);
        snake.addDirectionChange(SnakeDirection.RIGHT);
        snake.addDirectionChange(SnakeDirection.DOWN);

        snake.walk();
        snake.walk();
        snake.walk();
        snake.walk();
        assertFalse(snake.walk());
    }
}
