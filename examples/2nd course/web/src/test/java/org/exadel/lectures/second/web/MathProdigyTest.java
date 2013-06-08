package org.exadel.lectures.second.web;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author skrauchenia
 */
public class MathProdigyTest {

    @Test
    public void testSum() throws Exception {
        int testSum = MathProdigy.sum(3, 4);
        Assert.assertEquals(testSum, 7);
    }
}
