package exercitiul1;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exemp2.Calculator;
import org.junit.jupiter.api.Test;

class PerecheNumereTest {
    @Test
    void testCMMDC()
    {
        PerecheNumere per = new PerecheNumere(1,2);
        assertEquals(1, per.Cmmdc(1,2));
    }

}