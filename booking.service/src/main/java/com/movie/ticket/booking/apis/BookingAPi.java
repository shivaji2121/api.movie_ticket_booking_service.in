package com.movie.ticket.booking.apis;

import com.movie.ticket.booking.dtos.BookingDto;
import com.movie.ticket.booking.dtos.ResponseDto;
import com.movie.ticket.booking.services.BookingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingAPi {
    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDto> createBooking(@Valid @RequestBody BookingDto bookingDto) {
//        log.info("Entered into booking api: " + bookingDto);
        ResponseDto responseDto = this.bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String ping() {
        return "Server is alive";
    }
}
