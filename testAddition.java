

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testAddition.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testAddition
{
    /**
     * Default constructor for test class testAddition
     */
    public testAddition()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void addTwoNumbers()
    {
        Addition add = new Addition();
        
        assertEquals(10, add.addTwoNumbers(7,3));
        assertEquals(-1, add.addTwoNumbers(2,-3));
        //assertEquals(20.5, add.addTwoNumbers(1.5,19));
        
    }
}

