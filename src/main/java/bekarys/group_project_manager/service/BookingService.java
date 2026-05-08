package bekarys.group_project_manager.service;


import bekarys.group_project_manager.entity.Booking;
import bekarys.group_project_manager.repository.BookingRepository;
import bekarys.group_project_manager.repository.GroupMembershipRepository;
import bekarys.group_project_manager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GroupMembershipRepository membershipRepository;

    @Autowired
    private RoomRepository roomRepository;

    public boolean isGroupComplete(Long groupId) {
        int confirmedCount = membershipRepository.countConfirmedMembers(groupId);
        return confirmedCount >= 7;
    }

    public Booking createBooking(Booking booking) {
        if (!isGroupComplete(booking.getGroup().getId())) {
            throw new RuntimeException("Группа неполная. Нужно минимум 7 подтверждённых участников.");
        }

        if (!roomRepository.existsById(booking.getRoom().getId())) {
            throw new RuntimeException("Комната не найдена.");
        }

        booking.setStatus("CONFIRMED");
        booking.setAccessCode(generateAccessCode());
        booking.setCheckInDeadline(booking.getStartTime().plusMinutes(3));

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private String generateAccessCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }
}