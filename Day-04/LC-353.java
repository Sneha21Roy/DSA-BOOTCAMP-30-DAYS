
import java.util.*;

class SnakeGame {

    int width;
    int height;

    int[][] food;
    int foodIndex;

    Deque<Integer> snake;
    Set<Integer> occupied;

    public SnakeGame(int width, int height, int[][] food) {

        this.width = width;
        this.height = height;
        this.food = food;

        snake = new LinkedList<>();
        occupied = new HashSet<>();

        // Starting position = (0,0)
        snake.add(0);
        occupied.add(0);
    }

    public int move(String direction) {

        int head = snake.peekFirst();

        int row = head / width;
        int col = head % width;

        if (direction.equals("U")) {
            row--;
        } else if (direction.equals("D")) {
            row++;
        } else if (direction.equals("L")) {
            col--;
        } else if (direction.equals("R")) {
            col++;
        }

        // Boundary check
        if (row < 0 || row >= height
                || col < 0 || col >= width) {

            return -1;
        }

        int newHead = row * width + col;

        // Remove tail first
        int tail = snake.peekLast();

        boolean eatingFood
                = foodIndex < food.length
                && food[foodIndex][0] == row
                && food[foodIndex][1] == col;

        if (!eatingFood) {
            snake.removeLast();
            occupied.remove(tail);
        }

        // Snake body collision
        if (occupied.contains(newHead)) {
            return -1;
        }

        // Add new head
        snake.addFirst(newHead);
        occupied.add(newHead);

        // Food eaten
        if (eatingFood) {
            foodIndex++;
        }

        return foodIndex;
    }
}
