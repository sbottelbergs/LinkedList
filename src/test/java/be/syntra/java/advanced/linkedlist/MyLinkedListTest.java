package be.syntra.java.advanced.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    private MyLinkedList<String> list;

    // MyCollection / MyList

    @Test
    void canAddToEmptyList() {
        // given
        givenAnEmptyList();

        // when
        boolean result = list.add(firstItem());

        // then
        assertTrue(result);
        assertEquals(1, list.size());
    }

    @Test
    void canAddMultipleElements() {
        // given
        givenAnEmptyList();

        // when
        boolean result1 = list.add("First");
        boolean result2 = list.add("Second");

        // then
        assertTrue(result1);
        assertTrue(result2);
        assertEquals(2, list.size());
    }

    @Test
    void canGetFirstItemFromList() {
        // given
        givenAnEmptyList();

        // when
        list.add("First");

        // then
        assertEquals("First", list.get(0));
    }

    @Test
    void canGetSecondItemFromList() {
        // given
        givenAListWithThreeItems();

        // when
        final String result = list.get(1);

        // then
        assertEquals("Second", result);
    }

    @Test
    void getThrowsIndexOutOfBoundsException() {
        // given
        givenAListWithOneItem();

        // when - then
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void canSetFirstItemInEmptyList() {
        // given
        givenAnEmptyList();

        // when
        list.add(newItem());

        // then
        assertEquals(1, list.size());
        assertEquals(newItem(), list.get(0));
    }

    @Test
    void canSetSecondItem() {
        // given
        givenAListWithThreeItems();

        // when
        list.set(1, newItem());

        // then
        assertEquals(3, list.size());
        assertEquals(firstItem(), list.get(0));
        assertEquals(newItem(), list.get(1));
        assertEquals(thirdItem(), list.get(2));
    }

    @Test
    void removeFromEmptyListReturnsFalse() {
        // given
        givenAnEmptyList();

        // when
        boolean result = list.remove(firstItem());

        // then
        assertFalse(result);
    }

    @Test
    void removeNonExistentItemReturnsFalse() {
        // given
        givenAListWithTwoItems();

        // when
        boolean result = list.remove(newItem());

        // then
        assertFalse(result);
    }

    @Test
    void canRemoveItemFromSingletonList() {
        // given
        givenAnEmptyList();
        list.add(firstItem());

        // when
        boolean result = list.remove(firstItem());

        // then
        assertTrue(result);
        assertEquals(0, list.size());
    }

    @Test
    void canRemoveItemFromLongList() {
        // given
        givenAListWithThreeItems();

        // when
        boolean result = list.remove(secondItem());

        // then
        assertTrue(result);
        assertEquals(2, list.size());
        assertEquals(firstItem(), list.get(0));
        assertEquals(thirdItem(), list.get(1));
    }

    @Test
    void canRemoveItemFromListThenAddNew() {
        // given
        givenAListWithThreeItems();

        // when
        list.remove(firstItem());
        list.add(newItem());

        // then
        assertEquals(3, list.size());
        assertEquals(secondItem(), list.get(0));
        assertEquals(thirdItem(), list.get(1));
        assertEquals(newItem(), list.get(2));
    }

    @Test
    void canAddItemAtFirstIndexInEmptyList() {
        // given
        givenAnEmptyList();

        // when
        list.add(0, newItem());

        // then
        assertEquals(1, list.size());
        assertEquals(newItem(), list.get(0));
    }

    @Test
    void canAddItemAtFirstIndex() {
        // given
        givenAListWithOneItem();

        // when
        list.add(0, newItem());

        // then
        assertEquals(2, list.size());
        assertEquals(newItem(), list.get(0));
        assertEquals(firstItem(), list.get(1));
    }

    @Test
    void canAddItemInTheMiddle() {
        // given
        givenAListWithTwoItems();

        // when
        list.add(1, newItem());

        // then
        assertEquals(3, list.size());
        assertEquals(firstItem(), list.get(0));
        assertEquals(newItem(), list.get(1));
        assertEquals(secondItem(), list.get(2));
    }

    @Test
    void addItemThrowsIndexOutOfBoundsException() {
        // given
        givenAListWithOneItem();

        // when - then
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, newItem()));
    }

    @Test
    void testContains() {
        // given
        givenAListWithThreeItems();

        // when
        boolean result = list.contains(thirdItem());

        // then
        assertTrue(result);
    }

    @Test
    void testDoesNotContain() {
        // given
        givenAListWithThreeItems();

        // when
        boolean result = list.contains(newItem());

        // then

        assertFalse(result);
    }

    @Test
    void setThrowsIndexOutOfBoundsError() {
        // given
        givenAnEmptyList();

        // when - then
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, newItem()));
    }

    @Test
    void testClear() {
        // given
        givenAListWithTwoItems();

        // when
        list.clear();

        // then
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    // MyQueue

    @Test
    void peekReturnsNullForEmptyList() {
        // given
        givenAnEmptyList();

        // when
        String result = list.peek();

        // then
        assertNull(result);
        assertEquals(0, list.size());
    }

    @Test
    void peekReturnsFirstElement() {
        // given
        givenAListWithOneItem();

        // when
        String result = list.peek();

        // then
        assertEquals(firstItem(), result);
        assertEquals(1, list.size());
    }

    @Test
    void removeReturnsNullForEmptyList() {
        // given
        givenAnEmptyList();

        // when
        String result = list.remove();

        // then
        assertNull(result);
        assertEquals(0, list.size());
    }

    @Test
    void removeReturnsFirstElement() {
        // given
        givenAListWithTwoItems();

        // when
        String result = list.remove();

        // then
        assertEquals(firstItem(), result);
        assertEquals(1, list.size());
        assertEquals(secondItem(), list.get(0));
    }

    // Helper methods
    private void givenAnEmptyList() {
        list = new MyLinkedList<>();
    }

    private void givenAListWithOneItem() {
        givenAnEmptyList();
        list.add(firstItem());
    }

    private void givenAListWithTwoItems() {
        givenAnEmptyList();
        list.add(firstItem());
        list.add(secondItem());
    }

    private void givenAListWithThreeItems() {
        givenAnEmptyList();
        list.add(firstItem());
        list.add(secondItem());
        list.add(thirdItem());
    }

    private String firstItem() {
        return "First";
    }

    private String secondItem() {
        return "Second";
    }

    private String thirdItem() {
        return "Third";
    }

    private String newItem() {
        return "New";
    }
}
