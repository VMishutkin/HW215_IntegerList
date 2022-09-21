import org.example.AddNullException;
import org.example.ItemNotFoundException;
import org.example.StringList;
import org.example.StringListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringListTest {
    StringList stringList;

    @BeforeEach
    private void init(){
        stringList = new StringListImpl(5);
        stringList.add("Hi!");
        stringList.add("Hello!");
        stringList.add("WHATSUUUUP!");
        stringList.add("How are youuu doooing!");



    }
    @Test
    public void checkAddingNull(){
        assertThrows(AddNullException.class, () -> stringList.add(null));
        assertThrows(AddNullException.class, () -> stringList.add(0, null));
    }
    @Test
    public void checkContains(){
        assertEquals(true, stringList.contains("Hi!"));
        assertNotEquals(true, stringList.contains("Hey!"));

    }

    @Test
    public void testSetter(){
        stringList.set(0, "Hey");
        assertEquals("Hey", stringList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(1231, "He1"));
        assertThrows(AddNullException.class, () -> stringList.set(0, null));
    }


    @Test
    public void testSizeCounter(){
        stringList.add("Something");
        assertEquals(5, stringList.size());
        stringList.remove(2);
        assertEquals(4,stringList.size());
    }
    @Test
    public void checkIndexOf(){
        assertEquals(2,stringList.indexOf("WHATSUUUUP!"));
        stringList.add("WHATSUUUUP!");
        assertEquals(4, stringList.lastIndexOf("WHATSUUUUP!"));
        assertThrows(ItemNotFoundException.class, () -> stringList.indexOf("NSASD"));

    }

    @Test
    public void removeOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(100));
    }

    @Test
    public void insertOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(1000, "String"));
    }

    @Test
    public void checkEquals(){
        StringList otherList = new StringListImpl(10);

        otherList.add("Hi!");
        otherList.add("Hello!");
        otherList.add("WHATSUUUUP!");
        stringList.remove(3);
        assertEquals(true, stringList.equals(otherList));
        stringList.remove(1);
        assertEquals(false, stringList.equals(otherList));
    }


    @Test
    public void checkIsEmpty(){
        StringList otherList = new StringListImpl(12);
        assertEquals(true, otherList.isEmpty());
        otherList.add("Something");
        assertNotEquals(true,otherList.isEmpty());

    }

    @Test
    public void testGetter(){
        assertEquals("Hello!", stringList.get(1));
        assertEquals("WHATSUUUUP!", stringList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(50));
    }





}
