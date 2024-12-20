import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private Map<String, Appointment> appointments = new HashMap<>();

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointments.remove(appointmentId);
    }

    // Get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}