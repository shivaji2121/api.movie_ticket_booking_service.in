package com.movie.ticket.booking.services.impl;

import com.movie.ticket.booking.Enums.BookingStatus;
import com.movie.ticket.booking.dtos.BookingDto;
import com.movie.ticket.booking.dtos.ResponseDto;
import com.movie.ticket.booking.entities.BookingEntity;
import com.movie.ticket.booking.respository.BookingReposiory;
import com.movie.ticket.booking.services.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingReposiory bookingReposiory;
    @Override
    public ResponseDto createBooking(BookingDto bookingDto) {
        log.info("Entered into booking service imp: "+bookingDto);
        BookingEntity bookingEntity=BookingEntity.builder()
                .movieId(bookingDto.getMovieId())
                .userId(bookingDto.getUserId())
                .showDate(bookingDto.getShowDate())
                .showTime(bookingDto.getShowTime())
                .bookingAmount(bookingDto.getBookingAmount())
                .seatsSelected(bookingDto.getSeatsSelected())
                .bookingStatus(BookingStatus.PENDING)
                .build();
        BookingEntity savedEntity = bookingReposiory.save(bookingEntity);

        return  ResponseDto.builder().bookingDto( BookingDto.builder()
                        .bookingId(savedEntity.getBookingId())
                .movieId(savedEntity.getMovieId())
                .userId(savedEntity.getUserId())
                .showDate(savedEntity.getShowDate())
                .showTime(savedEntity.getShowTime())
                .bookingAmount(savedEntity.getBookingAmount())
                .seatsSelected(savedEntity .getSeatsSelected())
                .bookingStatus(BookingStatus.PENDING)
                .build())
                .build();
    }
}
