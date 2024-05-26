import org.example.SILab2.*;
import org.example.SILab2;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void test1() {
        Throwable exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0));
        assertEquals("allItems list can't be null!", exception.getMessage());
    }

    @Test
    void test2() {
        List<SILab2.Item> items = new ArrayList<>();
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    void test3() {
        SILab2.Item tI1 = new SILab2.Item(null, "123", 100, 0);
        SILab2.Item tI2 = new SILab2.Item("ItemName", "321", 50, 0);
        List<Item> items = new ArrayList<>();
        items.add(tI1);
        items.add(tI2);
        assertFalse(SILab2.checkCart(items, 10));
    }

    @Test
    void test4() {
        Item tI1 = new Item(null, null, 100, 0);
        Item tI2 = new Item("ItemName", "321", 50, 0);
        List<Item> items = new ArrayList<>();
        items.add(tI1);
        items.add(tI2);

        Throwable exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 10));
        assertEquals("No barcode!", exception.getMessage());
    }

    @Test
    void test5() {
        Item tI1 = new Item(null, "123", 100, 0);
        Item tI2 = new Item("ItemName", "1asd", 50, 0);
        List<Item> items = new ArrayList<>();
        items.add(tI1);
        items.add(tI2);

        Throwable exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 10));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }

    @Test
    void test6() {
        Item tI1 = new Item(null, "123", 100, 0);
        Item tI2 = new Item("ItemName", "321", 50, 10);
        Item tI3 = new Item("ItemName", "0321", 350, 10);
        List<Item> items = new ArrayList<>();
        items.add(tI1);
        items.add(tI2);
        items.add(tI3);
        assertFalse(SILab2.checkCart(items, 10));
    }

    @Test
    void test7() {
        Item tI1 = new Item(null, "123", 100, 0);
        Item tI2 = new Item("ItemName2", "321", 350, 0);
        Item tI3 = new Item("ItemName3", "321", 350, 10);
        Item tI4 = new Item("ItemName4", "0123", 350, 10);
        List<Item> items = new ArrayList<>();
        items.add(tI1);
        items.add(tI2);
        items.add(tI3);
        items.add(tI4);
        assertTrue(SILab2.checkCart(items, 10000));
    }
}