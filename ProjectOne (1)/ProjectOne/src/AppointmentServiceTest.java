import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("A123", futureDate, "Test Appointment");

        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("A123"));
    }

    @Test
    void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment1 = new Appointment("A123", futureDate, "Test Appointment");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment1); // Adding duplicate
        });
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("A123", futureDate, "Test Appointment");

        service.addAppointment(appointment);
        service.deleteAppointment("A123");

        assertNull(service.getAppointment("A123"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("NonExistentID");
        });
    }

    @Test
    void testGetNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertNull(service.getAppointment("NonExistentID"));
    }
}