package org.chiku;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeriesTest {

    @Test
    public void testSeriesWithSizeTwoMatchesOriginal() {
        Series series = new Series(2);
        assertThat(series.isMatchOriginal(), is(true));
    }

    @Test
    public void testSeriesWithSizeOneMatchesOriginalAfterOneShuffle() {
        Series series = new Series(1);
        series.shuffle();
        assertThat(series.isMatchOriginal(), is(true));
    }

    @Test
    public void testSeriesAfterShuffleMovesEvenElementsForward() {
        Series series = new Series(5);
        series.shuffle();
        assertThat(series.at(2).has(0), is(true));
        assertThat(series.at(3).has(2), is(true));
        assertThat(series.at(4).has(4), is(true));
    }

    @Test
    public void testSeriesAfterShuffleMovesOddElementsBackward() {
        Series series = new Series(5);
        series.shuffle();
        assertThat(series.at(0).has(3), is(true));
        assertThat(series.at(1).has(1), is(true));
    }

    @Test
    public void testSeriesWithSizeTwoDoesNotMatchOriginalAfterOneShuffle() {
        Series series = new Series(2);
        series.shuffle();
        assertThat(series.isMatchOriginal(), is(false));
    }

    @Test
    public void testSeriesWithSizeTwoMatchesOriginalAfterTwoShuffle() {
        Series series = new Series(2);
        series.shuffle().shuffle();
        assertThat(series.isMatchOriginal(), is(true));
    }

    @Test
    public void testSeriesWithSizeFiveMatchesOriginalAfterThreeShufflesNotBefore() {
        Series series = new Series(5);
        assertThat(series.shuffle().isMatchOriginal(), is(false));
        assertThat(series.shuffle().isMatchOriginal(), is(false));
        assertThat(series.shuffle().isMatchOriginal(), is(true));
    }

}