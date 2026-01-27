package com.movie.ticket.booking.system.serv.booking.service.respository;

import com.movie.ticket.booking.system.serv.booking.service.entities.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingReposiory  extends CrudRepository<BookingEntity, UUID> {
}
