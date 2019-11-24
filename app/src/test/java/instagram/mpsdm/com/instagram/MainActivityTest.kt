package instagram.mpsdm.com.instagram

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Tarek Ben Driss on 24/11/2019.
 */
class MainActivityTest {

    var x:Int =2

    @Before
    fun setUp() {
        x=3
    }

    @After
    fun tearDown() {
        //x=5
        assertEquals(4,x+1)

    }

    @Test
    fun onBackPressed() {
    }

    @Test
    fun homeFragmentDidClickMessagesButton() {
        assertEquals(4,x+2)
    }

    @Test
    fun homeFragmentDidClickStoryButton() {
    }

    @Test
    fun messagesFragmentDidClickCancelButton() {
    }

    @Test
    fun storyFragmentDidClickCancelButton() {
    }
}