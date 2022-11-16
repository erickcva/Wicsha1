package com.wicsha.repository;

import org.springframework.data.repository.CrudRepository;
import com.wicsha.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
