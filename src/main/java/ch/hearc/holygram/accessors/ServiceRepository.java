package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {

}
