package bekarys.group_project_manager.controller;



import bekarys.group_project_manager.entity.Booking;
import bekarys.group_project_manager.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getOne(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/group/{groupId}/canBook")
    public boolean canBook(@PathVariable Long groupId) {
        return bookingService.isGroupComplete(groupId);
    }
}