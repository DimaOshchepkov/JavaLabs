import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.RegularJava;

public class RegularJavaUnitsTest {
    RegularJava rj = new RegularJava();

    @ParameterizedTest
    @ValueSource(strings = {"255.255.255.255", "255.128.64.192", "0.0.0.0"})
    public void testIsIPAddressTrue(String arg) {
        assertEquals(true, rj.isIPAddress(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"255.255.255", "255.255..253", "255.255.255.255."})
    public void testIsIPAddressFalse(String arg) {
        assertEquals(false, rj.isIPAddress(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
                            "53DE358F-45F1-E311-93EA-00269E58F20D",
                            "d3630000-5d0f-0015-ed68-08da3058ad5c"})
    public void testIsGUIDTrue(String arg) {
        assertEquals(true, rj.isGuid(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02md0e4-00fd-090A-ca30-0d00a0038ba4",
                            "e02=d0e4-00fd-090A-ca30-0d00a0u38ba4",
                            "d3630000-5d0f-0015-ed68-08da3058ad5c9"})
    public void testIsGUIDFalse(String arg) {
        assertEquals(false, rj.isGuid(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com",
                            "http://example.com",
                            "https://www.google.com/search?q=Error+loading+webview%3A+Error%3A+Could+not+register+" + 
                            "service+worker%3A+InvalidStateError%3A+Failed+to+register+a+ServiceWorker%3A+The+document+is+in+an+invalid+state"})
    public void testIsValidUrlTrue(String arg) {
        assertEquals(true, rj.isValidURL(arg));
    }


    @ParameterizedTest
    @ValueSource(strings = {"Привет мир",
                            "http://a.com",
                            "https://vyatsu-my.sharepoint.com/:w:/g/personal/usr11801_vyatsu_ru/EXSYtF-" + 
                            "6KNRDlEt2XQHy7l4Bn_9G93sIl9hHFDpsubQLIg?wdOrigin=TEAMS-ELECTRON.p2p.bim&wdExp=" + 
                            "TEAMS-CONTROL&wdhostclicktime=1694969850949&web=1"})
    public void testIsValidUrlFalse(String arg) {
        assertEquals(false, rj.isValidURL(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Cool_pass",
                            "ool_pass345",
                            "JKLJDGLGJ3333"})
    public void testIsStrongPasswordFalse(String arg) {
        assertEquals(false, rj.isStrongPassord(arg));
    } 

    @ParameterizedTest
    @ValueSource(strings = {"C00l_Pass",
                            "SupperPas1",
                            "lsdfg3aGGdljJJJJ"})
    public void testIsStrongPasswordTrue(String arg) {
        assertEquals(true, rj.isStrongPassord(arg));
    }
}
