import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestsForAddressBook {

    @Test
    public void addHuman() {
        AddressBook adres = new AddressBook();
        adres.addHuman("Волков", "Чапаева : 25 : 5");
        adres.addHuman("Батурин", "Советская", "21", "7");
        assertEquals("Волков - Чапаева : 25 : 5\n" +
                "Батурин - Советская : 21 : 7\n", adres.toString());
    }

}