package com.movie.ticket.booking.entities;

import com.movie.ticket.booking.Enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "booking_id")
    private UUID bookingId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "movie_id")
    private Integer movieId;
    @ElementCollection
    List<String> seatsSelected;
    @Column(name = "show_date")
    private LocalDate showDate;
    @Column(name = "show_time")
    private LocalTime showTime;
    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @Column(name = "amount")
    private  Double bookingAmount;

}
