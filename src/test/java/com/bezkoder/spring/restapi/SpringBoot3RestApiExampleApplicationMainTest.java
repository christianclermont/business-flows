package com.bezkoder.spring.restapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpringBoot3RestApiExampleApplicationMainTest {
    @Test
    void testMain() {
        assertDoesNotThrow(() -> SpringBoot3RestApiExampleApplication.main(new String[]{}));
    }
}
