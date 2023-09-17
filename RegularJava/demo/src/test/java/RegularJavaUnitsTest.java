import org.junit.Assert;
import org.junit.Test;

import com.example.RegularJava;

public class RegularJavaUnitsTest {
    RegularJava rj = new RegularJava();

    @Test
    public void testIsIPAddressTrue() {
        String ip = "255.255.255.255";
        Assert.assertEquals(true, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressTrue2() {
        String ip = "255.128.64.192";
        Assert.assertEquals(true, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressTrue3() {
        String ip = "0.0.0.0";
        Assert.assertEquals(true, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressWithMore256() {
        String ip= "255.255.255.256";
        Assert.assertEquals(false, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressWithLessOctets() {
        String ip= "255.255.255";
        Assert.assertEquals(false, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressWithEmptyOctet() {
        String ip= "255.255..253";
        Assert.assertEquals(false, rj.isIPAddress(ip));
    }

    @Test
    public void testIsIPAddressWithDotOnTheEnd() {
        String ip= "255.255.255.255.";
        Assert.assertEquals(false, rj.isIPAddress(ip));
    }

    @Test
    public void testIsGUIDTrue() {
        String trueGuid = "e02fd0e4-00fd-090A-ca30-0d00a0038ba0";
        Assert.assertEquals(true, rj.isGuid(trueGuid));
    }

    @Test
    public void testIsGUIDTrue2() {
        String trueGuid = "53DE358F-45F1-E311-93EA-00269E58F20D";
        Assert.assertEquals(true, rj.isGuid(trueGuid));
    }

    @Test
    public void testIsGUIDTrue3() {
        String trueGuid = "d3630000-5d0f-0015-ed68-08da3058ad5c";
        Assert.assertEquals(true, rj.isGuid(trueGuid));
    }


    @Test
    public void testIsGUIDWithMoreSumbols() {
        String guid = "e02fd0e4-00fd-090A-ca30-0d00a0038ba40";
        Assert.assertEquals(false, rj.isGuid(guid));
    }

    @Test
    public void testIsGUIDWithIncorrectSumbols() {
        String guid = "e02fd0e4-00fd-090A-ca30-0d00a0u38ba40";
        Assert.assertEquals(false, rj.isGuid(guid));
    }

    @Test
    public void testIsGUIDWithNotHyphen() {
        String guid = "e02fd0e4-00fd-090A+ca30-0d00a0u38ba40";
        Assert.assertEquals(false, rj.isGuid(guid));
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
