import org.junit.Assert;
import org.junit.Test;

import com.example.RegularJava;

public class RegularJavaUnitsTest {
    RegularJava rj = new RegularJava();

    @Test
    public void testIsIPAddress() {
        String trueIp = "255.255.255.255";
        String falseIP = "255.255.255.256";
        Assert.assertEquals(true, rj.isIPAddress(trueIp));
        Assert.assertEquals(false, rj.isIPAddress(falseIP));
    }

    @Test
    public void testIsGUID() {
        String trueGuid = "e02fd0e4-00fd-090A-ca30-0d00a0038ba0";
        String falseGuid = "sdgsdfgdsfdfvbdfgfsdssfgsgsdfwegsdf";

        Assert.assertEquals(true, rj.isGuid(trueGuid));
        Assert.assertEquals(false, rj.isGuid(falseGuid));
    }
}
