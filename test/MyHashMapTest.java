import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyHashMapTest {

    @Test
    public void MyHashMap_creates_a_hashMap_of_size_10_for_default() throws Exception{
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        assertEquals(10,hashMap.getCapacity());
    }

    @Test
    public void test_AddElement_returns_the_index_at_which_the_value_is_stored() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        assertEquals(3,hashMap.add(1, "Sooraj"));
    }

    @Test
    public void test_AddElement_increments_the_size_of_the_hashMap() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        assertEquals(0,hashMap.getSize());
        hashMap.add(1, "Sooraj");
        assertEquals(1,hashMap.getSize());
    }

    @Test
    public void test_AddElement_may_overwrite_the_value_of_same_hashIndex() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(15);
        int hashIndex = hashMap.add(5,"Nimesh");
        hashMap.add(5, "Arun");

        assertEquals("Arun",hashMap.getElementOf(5));
    }

    @Test
    public void test_getElementOf_gives_the_element_at_the_given_index() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(9);
        hashMap.add(12, "Sooraj");
        assertEquals("Sooraj",hashMap.getElementOf(12));
    }

    @Test
    public void test_getElementOf_gives_null_if_the_asked_key_is_unavailable() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(9);
        hashMap.add(12, "Sooraj");
        assertNull(hashMap.getElementOf(13));
    }

    @Test
    public void test_getElementOf_throws_exception_for_wrong_index() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(9);
        hashMap.add(18,"Sooraj");
        try{
            hashMap.getElementOf(11);
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertEquals("java.lang.ArrayIndexOutOfBoundsException: 11 does not exist",e.toString());
        }
    }

    @Test
    public void test_remove_removes_the_key_value_pair_from_MyHashMap() throws Exception {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>(9);
        hashMap.add(18,"Sooraj");
        assertEquals("Sooraj",hashMap.getElementOf(18));
        hashMap.remove(18);
        assertNull(hashMap.getElementOf(18));
    }

//    @Test
//    public void test_hasElement_returns_true_for_the_element_present_in_the_map() throws Exception {
//        MyHashMap<Integer, String> hashMap = new MyHashMap<>(15);
//        hashMap.addElement("Sooraj");
//        hashMap.addElement("Navya");
//        hashMap.addElement("Shibi");
//        hashMap.addElement("Nimesh");
//        hashMap.addElement("Arun");
//        assertEquals(true,hashMap.hasElement("Sooraj"));
//    }
//
//    @Test
//    public void test_hasElement_returns_false_for_the_element_not_present_in_the_map() throws Exception {
//        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
//        hashMap.addElement("Sooraj");
//        hashMap.addElement("Navya");
//        hashMap.addElement("Shibi");
//        hashMap.addElement("Nimesh");
//        hashMap.addElement("Arun");
//        assertEquals(false,hashMap.hasElement("Madu"));
//    }
}