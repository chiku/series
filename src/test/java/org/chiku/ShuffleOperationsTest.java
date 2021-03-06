package org.chiku;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShuffleOperationsTest {
    @Test
    public void shufflesCreateCommaSeparatedResults(){
        ShuffleOperations operations = new ShuffleOperations(5);
        operations.shuffle();
        HashMap<String, String> result = operations.result();
        assertThat(result.get("prime"), is(equalTo("[[2, 2], [3, 2], [5, 3]]")));
        assertThat(result.get("nonPrime"), is(equalTo("[[1, 1], [4, 3]]")));
    }
}
