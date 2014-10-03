package org.chiku;

import org.chiku.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void testItemEqualsItself() {
        Item item = new Item(1);
        assertThat(item, is(equalTo(item)));
    }

    @Test
    public void testItemDoesNotEqualNull() {
        assertThat(new Item(1), is(not(equalTo(null))));
    }

    @Test
    public void testItemDoesNotEqualInteger() {
        assertThat(new Item(1).equals(new Integer(1)), is(false));
    }

    @Test
    public void testItemDoesNotEqualItemWithDifferentIdentity() {
        assertThat(new Item(1), is(not(equalTo(new Item(2)))));
    }

    @Test
    public void testItemDoesNotEqualItemWithSameIdentity() {
        assertThat(new Item(1), is(not(equalTo(new Item(1)))));
    }

    @Test
    public void testItemHasNumberWithMatchingIdentity() {
        assertThat(new Item(1).has(1), is(true));
    }

    @Test
    public void testItemDoesNotHaveNumberWithDifferentIdentity() {
        assertThat(new Item(1).has(2), is(false));
    }
}
