package edu.alsjava.barcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by aluis on 9/30/19.
 */
class CheckTest {

    @Test
    void test() {
        Assertions.assertEquals(4, 2 + 2, "Chequeo si 2 + 2 = 4?");
    }

    @Test
    void testFail() {
        assertNotEquals(5, 2 + 2, "Chequeo si 2 + 2 = 5?");
    }
}
