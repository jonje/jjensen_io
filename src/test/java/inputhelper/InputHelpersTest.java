package inputhelper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/31/13
 * Time: 9:21 AM
 */
public class InputHelpersTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @org.junit.Test
    public void testExtractInt() throws Exception {
        int result = InputHelpers.extractInt("2");
        Assert.assertEquals(2, result);

    }

    @org.junit.Test
    public void testPromptUser() throws Exception {
        InputHelpers.promptUser("Please enter a value:");

        Assert.assertEquals("Please enter a value:\n", outContent.toString());

    }

    @org.junit.Test
    public void testGetUserInput() throws Exception {

    }
}
