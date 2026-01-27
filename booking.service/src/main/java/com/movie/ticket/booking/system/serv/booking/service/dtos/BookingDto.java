package com.movie.ticket.booking.system.serv.booking.service.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.ticket.booking.system.serv.booking.service.Enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    @NotNull(message = "UserId is required")
    private String userId;

    @Positive(message = "Movie id should be positive")
    @NotNull(message = "MovieId is required")
    private Integer movieId;
    @NotNull(message = "You need to select atleast one seat")
    List<String> seatsSelected;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Show date is required")
    @FutureOrPresent(message = "Show date cannot be in the past")
    private LocalDate showDate;
    @NotNull(message = "Time is required")
    private LocalTime showTime;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @NotNull(message = "Booking amount is required")
    private  Double bookingAmount;

}
