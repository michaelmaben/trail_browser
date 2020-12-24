package com.jeevanmaben.springboot.trails.repo;

import com.jeevanmaben.springboot.trails.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends CrudRepository<Tour, Integer> {
}
