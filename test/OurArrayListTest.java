import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {
    OurArrayList<Integer> integerList = new OurArrayList<>();

    @Test
    public void testSize_newList() {
        assertEquals(0, integerList.size());
    }

    @Test
    public void testAddAndGet_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertEquals(3, integerList.size());

        assertEquals(-7, integerList.get(0));
        assertEquals(-17, integerList.get(1));
        assertEquals(5, integerList.get(2));
    }

    @Test
    public void testAddAndGet_severalElements_throwsIOOBE() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-3);
        });

        // another way
        try {
            integerList.get(-3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-1);
        });
    }

    @Test
    public void testSort(){
        //OurArrayList<Integer> arr = new OurArrayList<>();
        integerList.add(10);
        integerList.add(4);
        integerList.add(8);
        integerList.add(10);

        IntegerNaturalComparator comparator = new IntegerNaturalComparator();

        integerList.sort(comparator);
        assertEquals(4,integerList.get(0));
    }

}