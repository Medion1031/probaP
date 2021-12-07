import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TDD {
    @Test
    public void test01(){
        LocalDateTime now = LocalDateTime.of(2021,12, 29, 16, 20);
        LocalDateTime res = LocalDateTime.of(2021,12, 30, 10, 20);
        assertEquals(timeDate.CalculateDueDate(now, 3), res);
    }

    @Test
    public void test02(){
        LocalDateTime now = LocalDateTime.of(2021,12, 10, 16, 20);
        LocalDateTime res = LocalDateTime.of(2021,12, 13, 10, 20);
        assertEquals(timeDate.CalculateDueDate(now, 3), res);
    }
}
