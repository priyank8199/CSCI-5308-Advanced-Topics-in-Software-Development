import org.example.MinQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MinQueueTest {

    // Test for Enqueue whether elements are inserting in queue or not
    @Test
    public void testEnqueue() {
        // Arrange
        MinQueue queue = new MinQueue(5);

        //Act
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(9);

        //Assert
        Assertions.assertEquals(5, queue.size());
    }

    // Test for Enqueue whether if the queue size is full
    @Test
    public void testEnqueueFullQueue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        MinQueue queue = new MinQueue(3);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        Assertions.assertEquals("Queue full\r\n", outContent.toString());
    }

    // Test for whether single element are inserted in queue or not
    @Test
    public void testEnqueueOneElement() {
        // Arrange
        MinQueue queue = new MinQueue(5);

        //Act
        queue.enqueue(5);

        //Assert
        Assertions.assertEquals(1, queue.size());
    }

    // Test for whether negative element are inserted in queue or not
    @Test
    public void testEnqueueNegativeElement() {
        // Arrange
        MinQueue queue = new MinQueue(5);

        //Act
        queue.enqueue(-3);

        //Assert
        Assertions.assertEquals(1, queue.size());
    }

    // Test for whether elements are removed from the queue
    @Test
    public void testDequeue() {

        //Arrange
        MinQueue queue = new MinQueue(5);

        //Act
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);

        //Assert
        Assertions.assertEquals(3, queue.dequeue());
        Assertions.assertEquals(5, queue.dequeue());
        Assertions.assertEquals(7, queue.dequeue());
    }

    // Test for queue if it is empty
    @Test
    public void testDequeueEmptyQueue() {

        //Arrange
        MinQueue queue = new MinQueue(3);

        //Assert
        Assertions.assertEquals(-1, queue.dequeue());

    }

    @Test
    public void testTop() {
        //Act
        MinQueue queue = new MinQueue(5);

        //Arrange
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);

        //Assert
        Assertions.assertEquals(3, queue.top());
    }

    // Test top when queue is empty
    @Test
    public void testTopWhenQueueIsEmpty() {
        //Act
        MinQueue queue = new MinQueue(1);

        //Arrange
        queue.enqueue(5);
        queue.dequeue();

        //Assert
        Assertions.assertEquals(-1, queue.top());
    }

}
