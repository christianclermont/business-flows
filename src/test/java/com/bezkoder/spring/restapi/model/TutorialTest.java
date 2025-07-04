package com.bezkoder.spring.restapi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TutorialTest {
    @Test
    void testToString() {
        Tutorial t = new Tutorial("TestTitle", "TestDesc", true);
        t.setId(42L);
        String str = t.toString();
        assertTrue(str.contains("TestTitle"));
        assertTrue(str.contains("TestDesc"));
        assertTrue(str.contains("42"));
        assertTrue(str.contains("true"));
    }

    @Test
    void testGettersAndSetters() {
        Tutorial t = new Tutorial();
        t.setId(1L);
        t.setTitle("Title");
        t.setDescription("Desc");
        t.setPublished(true);
        assertEquals(1L, t.getId());
        assertEquals("Title", t.getTitle());
        assertEquals("Desc", t.getDescription());
        assertTrue(t.isPublished());
    }
}
