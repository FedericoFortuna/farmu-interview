package com.farmu.farmuChallenge;

import com.farmu.farmuChallenge.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UtilsTest {

    @Test
    void testGenerateUUID() {
        assertNotNull(Utils.generateUUID());
    }

    @Test
    void testIsValidURLValid() {
        assertTrue(Utils.isValidURL("https://example.com"));
    }

    @Test
    void testIsValidURLInvalid() {
        assertFalse(Utils.isValidURL("not_a_valid_url"));
    }
}
