import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        assertEquals(contact, service.getContact("C123"));
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact); // Adding duplicate
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("C123");

        assertNull(service.getContact("C123"));
    }

    @Test
    void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NonExistentID"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C123", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateContact("C123", "Jane", "Smith", "0987654321", "456 Elm Street");

        Contact updatedContact = service.getContact("C123");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm Street", updatedContact.getAddress());
    }

    @Test
    void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("NonExistentID", "Jane", "Doe", "1234567890", "123 Elm Street");
        });
    }
}

