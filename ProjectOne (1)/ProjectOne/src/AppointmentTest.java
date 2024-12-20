import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AppointmentTest {

    // Testing Appointment ID
    @Test
    public void testAppointmentIdNotNullAndNotLongerThanTenCharacters() {
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 3600000), "Doctor's Appointment");
        assertNotNull(appointment.getAppointmentId());
        assertEquals(10, appointment.getAppointmentId().length());
    }

    @Test
    public void testAppointmentIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(System.currentTimeMillis() + 3600000), "Test"));
    }

    @Test
    public void testAppointmentIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(System.currentTimeMillis() + 3600000), "Test"));
    }

    // Testing Appointment Date
    @Test
    public void testAppointmentDateCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", null, "Test"));
    }

    @Test
    public void testAppointmentDateCannotBeInThePast() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(System.currentTimeMillis() - 3600000), "Test"));
    }

    @Test
    public void testAppointmentDateCanBeInTheFuture() {
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 3600000), "Test");
        assertNotNull(appointment.getAppointmentDate());
        assertTrue(appointment.getAppointmentDate().after(new Date()));
    }

    // Testing Appointment Description
    @Test
    public void testAppointmentDescriptionNotNullAndMaxFiftyCharacters() {
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 3600000), "Doctor's Appointment");
        assertNotNull(appointment.getDescription());
        assertTrue(appointment.getDescription().length() <= 50);
    }

    @Test
    public void testAppointmentDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(System.currentTimeMillis() + 3600000), null));
    }

    @Test
    public void testAppointmentDescriptionCannotBeLongerThanFiftyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(System.currentTimeMillis() + 3600000), "This description is way too long and should fail!!."));
    }
}

