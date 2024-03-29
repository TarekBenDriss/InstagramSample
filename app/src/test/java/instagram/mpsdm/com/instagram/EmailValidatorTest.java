package instagram.mpsdm.com.instagram;

import org.junit.Test;

import instagram.mpsdm.com.instagram.utils.EmailValidator;

import static org.junit.Assert.*;

/**
 * Created by Tarek Ben Driss on 24/11/2019.
 */
public class EmailValidatorTest {

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }
/*
    String result="";

    // Simple subscription to a fix value
    @Test
    public void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides data
        observer.subscribe(s -> result=s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }

*/
}
