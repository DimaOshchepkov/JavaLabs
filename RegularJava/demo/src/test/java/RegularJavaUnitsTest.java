import org.junit.Assert;
import org.junit.Test;

import com.example.RegularJava;

public class RegularJavaUnitsTest {
    RegularJava rj = new RegularJava();

    @Test
    public void testIsIPAddress() {
        String trueIp = "255.255.255.255";
        Assert.assertEquals(true, rj.isIPAddress(trueIp));
        
    }
}
