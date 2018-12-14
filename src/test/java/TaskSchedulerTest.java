import org.junit.Test;

import static org.junit.Assert.*;

public class TaskSchedulerTest {
    TaskScheduler taskScheduler = new TaskScheduler();

    @Test
    public void leastInterval() {
        char[] tasks = {'A','A','A','B','B','B'};
        assertEquals(8, taskScheduler.leastInterval(tasks,2));
    }
}