package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Religion;

public interface ReligionRepository extends CrudRepository<Religion, Long> {

}
