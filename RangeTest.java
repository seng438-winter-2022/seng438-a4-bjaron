package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getLengthShouldBeTwo() {
       // fail("Not yet implemented");
    	assertEquals("The length should be 2",
    	        2, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLowerBoundShouldBeNegOne() {
        //fail("Not yet implemented");
    	assertEquals("The lower bound should be -1",-1,exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundShouldBeOne() {
        //fail("Not yet implemented");
    	assertEquals("The upperbound should be 1",
    	        1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void intersectsShouldBeTrueALessThanLower() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(-2, 2);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    @Test
    public void intersectsShouldBeFalseAGreaterThanUpper() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(3, 4);
    	
    	assertFalse(exampleRange.intersects(exampleRange2));
    }
    
    @Test
    public void intersectsShouldBeTrueABetweenBounds() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(0, 4);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    //BVT
    @Test
    public void intersectsShouldBeTrueAEqualLower() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(-1, 2);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    @Test
    public void intersectsShouldBeTrueAEqualUpper() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(1, 2);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    //Robustness
    @Test
    public void intersectsShouldBeTrueABLB() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(-1.01, 2);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    @Test
    public void intersectsShouldBeFalseAAUB() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(1.01, 2);
    	
    	assertFalse(exampleRange.intersects(exampleRange2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void rangeCtorLowerGreaterThanUpper() throws Exception {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(4, 2);
    }
 
    
    
    @Test(expected = IllegalArgumentException.class)
    public void rangeCtorInvalidArgument() throws Exception{
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range('L',3);
    }
    
    @Test
    public void rangeCtorValidArgument() throws Exception{
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(1,3);
    }
    
    //BVT
    @Test
    public void rangeCtorAEqualB() {
    	Range exampleRange2 = new Range(1,1);
    }
    
    //Robustness
    @Test
    public void rangeCtorABLB(){
    	Range exampleRange2 = new Range(.9999,1);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void rangeCtorAAUB() throws Exception{
    	Range exampleRange2 = new Range(1.1111,1);
    }
    
//////////////////////////////////////////////////
    @Test
    public void lessThanLowerGreaterThanLarger() {
        //fail("Not yet implemented");
        Range exampleRange2 = new Range(-1, 4);

        assertTrue(exampleRange.intersects(exampleRange2));
    }
    @Test
    public void lessThanSmallerLargerGreater() {
        //fail("Not yet implemented");
        Range exampleRange2 = new Range(0, 4);

        assertTrue(exampleRange.intersects(exampleRange2));
    }

    @Test
    public void falseEqualBounds() {
        //fail("Not yet implemented");
        Range exampleRange2 = new Range(-1, -1);

        assertFalse(exampleRange.intersects(exampleRange2));
    }
    /////////////////////////////////////////////////////////

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    //-------------------------------TEST MUTATION------------------------------------//
    //test message mutation
    @Test
    public void rangeCtorLowerGreaterThanUpperTestMessage() throws Exception {
        //fail("Not yet implemented");
    	try {
    		Range exampleRange2 = new Range(4, 2);
    	}
    	catch(IllegalArgumentException e) {
    		assertEquals("Message of Range ctor", 
    				"Range(double, double): require lower (" + 4d
                    + ") <= upper (" + 2d + ").", 
                    e.getMessage());
    	}
    }
    
    //test ctor bounds mutation
    @Test
    public void RangeCtorCorrectLowerValue() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(1.01, 2);
    	
    	assertEquals("Lower bounds incorrect", 1.01, exampleRange2.getLowerBound(), .000000001d);
    }
    
    //test ctor bounds mutation
    @Test
    public void RangeCtorCorrectUpperValue() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(1.01, 2);
    	
    	assertEquals("Upper bounds incorrect", 2, exampleRange2.getUpperBound(), .000000001d);
    }
    
    //test centralValue change value mutation
    @Test
    public void centralValueShouldBeNonZero() {
    	Range exampleRange2 = new Range(1, 2);
        assertEquals("The central value of -1 and 1 should be 1.5",
        1.5, exampleRange2.getCentralValue(), .000000001d);
    }
    
    //test negated lower field mutation
    @Test
    public void intersectsFalseAllPositiveValues() {
    	Range exampleRange2 = new Range(1, 2);
    	Range exampleRange3 = new Range(3, 4);
        assertFalse("Should not intersect",
        exampleRange3.intersects(exampleRange2));
    }
    
    //test != mutation
    @Test
    public void intersectsFalse() {
    	Range exampleRange2 = new Range(1, 2);
    	Range exampleRange3 = new Range(3, 4);
        assertFalse("Should not intersect",
        exampleRange2.intersects(exampleRange3));
    }
    
    //test contains
    @Test
    public void containsTrue() {
    	Range exampleRange2 = new Range(1, 2);
        assertTrue("Should contain",
        exampleRange2.contains(1.5));
    }
    
  //test contains
    @Test
    public void containsTrueUB() {
    	Range exampleRange2 = new Range(1, 2);
        assertTrue("Should contain",
        exampleRange2.contains(2));
    }
    
  //test contains
    @Test
    public void containsTrueLB() {
    	Range exampleRange2 = new Range(1, 2);
        assertTrue("Should contain",
        exampleRange2.contains(1));
    }
    
  //test contains
    @Test
    public void containsFalse() {
    	Range exampleRange2 = new Range(1, 2);
        assertFalse("Should not contain",
        exampleRange2.contains(0.5));
    }
    
  //test contains
    @Test
    public void containsFalseBLB() {
    	Range exampleRange2 = new Range(1, 2);
        assertFalse("Should contain",
        exampleRange2.contains(0.99995));
    }
    
  //test contains
    @Test
    public void containsFalseAUB() {
    	Range exampleRange2 = new Range(1, 2);
        assertFalse("Should contain",
        exampleRange2.contains(2.0001));
    }
    
    //test constrain
    @Test
    public void constrainBLB() {
    	Range exampleRange2 = new Range(1, 2);
        assertEquals("Should not constrain to 1", 1.0,
        exampleRange2.constrain(0.99995), .000000001d);
    }
    
  //test constrain
    @Test
    public void constrainAUB() {
    	Range exampleRange2 = new Range(1, 2);
        assertEquals("Should constrain to 2", 2.0,
        exampleRange2.constrain(2.0005), .000000001d);
    }
    
  //test constrain
    @Test
    public void constrainInside() {
    	Range exampleRange2 = new Range(1, 2);
        assertEquals("Should constrain to 1.5", 1.5,
        exampleRange2.constrain(1.5), .000000001d);
    }
    
  //test combine
    @Test
    public void combineBothNull() {
    	assertNull("combine should return null",Range.combine(null, null));
    }
    
  //test combine
    @Test
    public void combineR1null() {
    	Range exampleRange2 = new Range(1, 2);
    	assertEquals("combine should return range 1-2", exampleRange2, Range.combine(null, exampleRange2));
    }
    
  //test combine
    @Test
    public void combineR2null() {
    	Range exampleRange2 = new Range(1, 2);
    	assertEquals("combine should return range 1-2", exampleRange2, Range.combine(exampleRange2, null));
    }
    
  //test combine
    @Test
    public void combineIntersects() {
    	Range exampleRange2 = new Range(.5, 2);
    	assertEquals("combine should return range -1-2", new Range(-1,2), Range.combine(exampleRange2, exampleRange));
    }
    
  //test combine
    @Test
    public void combineNotIntersects() {
    	Range exampleRange2 = new Range(2, 3);
    	assertEquals("combine should return range -1-3", new Range(-1,3), Range.combine(exampleRange2, exampleRange));
    }
    
  //test combine
    @Test
    public void combineInside() {
    	Range exampleRange2 = new Range(-.5, .5);
    	assertEquals("combine should return range -1-1", new Range(-1,1), Range.combine(exampleRange2, exampleRange));
    }
    
    //test shift
    @Test
    public void shiftByHalf() {
    	Range exampleRange2 = new Range(-.5, .5);
    	assertEquals("shift should return 1 to 0", new Range(0,1), Range.shift(exampleRange2, .5));
    }
    
  //test shift
    @Test (expected = IllegalArgumentException.class)
    public void shiftWithNull() {
    	//Range exampleRange2 = new Range(-.5, .5);
    	Range.shift(null, 20);
    }
    
  //test shift
    @Test
    public void shiftByNegative() {
    	Range exampleRange2 = new Range(-.5, .5);
    	assertEquals("shift should return -1 to 0", new Range(-1,0), Range.shift(exampleRange2, -.5));
        
    }
    
  //test shift
    @Test
    public void shiftBeyondZero() {
    	Range exampleRange2 = new Range(-.5, .5);
    	assertEquals("shift should return -2.5 to 0", new Range(-2.5,0), Range.shift(exampleRange2, -2));
        
    }
 
}