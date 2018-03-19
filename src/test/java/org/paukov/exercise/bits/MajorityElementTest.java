package org.paukov.exercise.bits;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 3/19/18.
 */
public class MajorityElementTest {
    @Test
    public void majorityElement() throws Exception {
        assertThat(MajorityElement.majorityElement(new int[]{1, 3, 3})).isEqualTo(3);
        assertThat(MajorityElement.majorityElement(new int[]{1, 5, 5, 5, 2, 1, 4, 5, 5, 2, 3, 4, 5})).isEqualTo(5);
    }

}