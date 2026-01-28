package com.movie.ticket.booking.services;

import com.movie.ticket.booking.dtos.BookingDto;
import com.movie.ticket.booking.dtos.ResponseDto;



public interface BookingService {

   public ResponseDto createBooking(BookingDto bookingDto);
}
