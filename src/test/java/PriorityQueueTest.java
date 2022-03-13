import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriorityQueueTest {
    public PriorityQueueTest() {
    }

    static Stream<Arguments> streamProvider() {
        return Stream.of(Arguments.of(new Object[]{new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}}), Arguments.of(new Object[]{new int[]{6, 5, 4, 3, 2}, new int[]{2, 3, 4, 5, 6}}), Arguments.of(new Object[]{new int[]{7, 6, 5, 4, 3}, new int[]{3, 4, 5, 6, 7}}), Arguments.of(new Object[]{new int[]{8, 7, 6, 5, 4}, new int[]{4, 5, 6, 7, 8}}), Arguments.of(new Object[]{new int[]{9, 10, 11, 12, 13}, new int[]{9, 10, 11, 12, 13}}));
    }

    @ParameterizedTest
    @MethodSource({"streamProvider"})
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> minheap = new PriorityQueue();
        int[] result_array = new int[5];
        int k = 0;

        for(int i = 0; i < 5; ++i) {
            minheap.add(random_array[i]);
        }

        while(!minheap.isEmpty()) {
            result_array[k] = (Integer)minheap.poll();
            //++k;
        }

        Assertions.assertEquals(Arrays.toString(correct_array), Arrays.toString(result_array));
    }

    @Test
    public void whenExceptionThrown_thenInitialCapacityIsLessThanOne() {
        Exception exception = (Exception)Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }

    @Test
    public void whenExceptionThrown_thenAddNull() {
        Exception exception = (Exception)Assertions.assertThrows(NullPointerException.class, () -> {
            PriorityQueue minheap = new PriorityQueue();
            minheap.add((Object)null);
        });
    }

    @Test
    public void whenExceptionThrown_thenNoElement() {
        Exception exception = (Exception)Assertions.assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<Integer> minheap = new PriorityQueue();
            minheap.remove();
        });
    }
}
