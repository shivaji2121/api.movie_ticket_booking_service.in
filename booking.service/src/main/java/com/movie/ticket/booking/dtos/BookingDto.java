package com.movie.ticket.booking.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.movie.ticket.booking.Enums.BookingStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class BookingDto {

    private UUID bookingId;

    @NotBlank(message = "UserId is required")
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

//    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @NotNull(message = "Booking amount is required")
    @Positive(message = "amount should be positive")
    private  Double bookingAmount;

}
