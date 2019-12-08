package it.unipd.tos.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTypeTest {
    @Test
    public void testItemTypeEnumValues() {
        assertEquals("PANINI", ItemType.valueOf(ItemType.PANINI.toString()).name());
        assertEquals("FRITTI", ItemType.valueOf(ItemType.FRITTI.toString()).name());
        assertEquals("BEVANDE", ItemType.valueOf(ItemType.BEVANDE.toString()).name());
    }
}