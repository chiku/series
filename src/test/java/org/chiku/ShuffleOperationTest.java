package org.chiku;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShuffleOperationTest {

    @Test
    public void testSeriesOfLengthOneNeedsZeroOperationsToComeBack() {
        assertThat(new ShuffleOperation(1).shuffleTimes(), is(1));
    }

    @Test
    public void testSeriesOfLengthTwoNeedsTwoOperationsToComeBack() {
        assertThat(new ShuffleOperation(2).shuffleTimes(), is(2));
    }

    @Test
    public void testSeriesOfLengthFiveNeedsThreeOperationsToComeBack() {
        assertThat(new ShuffleOperation(5).shuffleTimes(), is(3));
    }

}
