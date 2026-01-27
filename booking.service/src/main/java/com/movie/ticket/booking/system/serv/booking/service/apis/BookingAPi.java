package com.movie.ticket.booking.system.serv.booking.service.apis;

import com.movie.ticket.booking.system.serv.booking.service.dtos.BookingDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
public class BookingAPi {
    public void createBooking(@RequestBody BookingDto bookingDto){

    }
}
