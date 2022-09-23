import org.example.AddNullException;
import org.example.IntegerList;
import org.example.IntegerListImpl;

import org.example.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IntegerListTest {
    IntegerList integerList;

    @BeforeEach
    private void init(){
        integerList = new IntegerListImpl(3);
        for (int i = 0; i < 5; i++) {
            integerList.add(i*2);
        }



    }
    @Test
    public void checkAddingNull(){
        assertThrows(AddNullException.class, () -> integerList.add(null));
        assertThrows(AddNullException.class, () -> integerList.add(0, null));
    }
    @Test
    public void checkContains(){
        assertEquals(true, integerList.contains(6));
        assertNotEquals(true, integerList.contains(100));

    }

    @Test
    public void testSetter(){
        integerList.set(0, 50);
        assertEquals(50, integerList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.set(1231, 300));
        assertThrows(AddNullException.class, () -> integerList.set(0, null));
    }


    @Test
    public void testSizeCounter(){
        integerList.add(36);
        assertEquals(6, integerList.size());
        integerList.remove(2);
        assertEquals(5, integerList.size());
    }
    @Test
    public void checkIndexOf(){
        assertEquals(2, integerList.indexOf(4));
        integerList.add(4);
        assertEquals(5, integerList.lastIndexOf(4));
        assertThrows(ItemNotFoundException.class, () -> integerList.indexOf(66));

    }

    @Test
    public void removeOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(100));
    }

    @Test
    public void insertOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(1000, 80));
    }

    @Test
    public void checkEquals(){
        IntegerList otherList = new IntegerListImpl(10);

        for (int i = 0; i < 5; i++) {
            otherList.add(i*2);
        }

        assertEquals(true, integerList.equals(otherList));
        integerList.remove(1);
        assertEquals(false, integerList.equals(otherList));
    }


    @Test
    public void checkIsEmpty(){
        IntegerList otherList = new IntegerListImpl(12);
        assertEquals(true, otherList.isEmpty());
        otherList.add(13);
        assertNotEquals(true,otherList.isEmpty());

    }

    @Test
    public void testGetter(){
        assertEquals(2, integerList.get(1));
        assertEquals(4, integerList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(50));
    }





}
