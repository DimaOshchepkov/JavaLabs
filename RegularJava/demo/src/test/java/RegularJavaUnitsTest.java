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

    @Test
    public void testIsValidUrl() {
        String trueUrl = "http://www.example.com";

        Assert.assertEquals(true, rj.isValidURL(trueUrl));
    }

    @Test 
    public void testIsStrongPasswordWithNotDigit() {
        String weakPassword = "Cool_pass";

        Assert.assertEquals(false, rj.isStrongPassord(weakPassword));
    }

    @Test 
    public void testIsStrongPasswordWithNotUpperCase() {
        String weakPassword = "ool_pass345";

        Assert.assertEquals(false, rj.isStrongPassord(weakPassword));
    }

    @Test 
    public void testIsStrongPasswordWithNotLowerCase() {
        String weakPassword = "JKLJDGLGJ3333";

        Assert.assertEquals(false, rj.isStrongPassord(weakPassword));
    }

    @Test
    public void testIsStrongPasswordTrue() {
        String strongPassword = "C00l_Pass";

        Assert.assertEquals(true, rj.isStrongPassord(strongPassword));
    }

    @Test 
    public void testIsStrongPasswordTrue2() {
        String strongPassword = "SupperPas1";

        Assert.assertEquals(true, rj.isStrongPassord(strongPassword));
    }

    @Test 
    public void testIsStrongPasswordTrue3() {
        String strongPassword = "lsdfg3aGGdljJJJJ";

        Assert.assertEquals(true, rj.isStrongPassord(strongPassword));
    }
}
