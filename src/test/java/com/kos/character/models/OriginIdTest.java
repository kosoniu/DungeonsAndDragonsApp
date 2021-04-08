package com.kos.character.models;

import com.kos.character.origin.model.OriginId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OriginIdTest {

    @Test
    public void testConstructor() {
        // given
        OriginId originId = OriginId.of(5);

        //then
        assertEquals(5, originId.asInt());
    }

}
