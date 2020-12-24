package com.jeevanmaben.springboot.trails.service;

import com.jeevanmaben.springboot.trails.domain.Difficulty;
import com.jeevanmaben.springboot.trails.domain.Region;
import com.jeevanmaben.springboot.trails.domain.Tour;
import com.jeevanmaben.springboot.trails.domain.TourPackage;
import com.jeevanmaben.springboot.trails.repo.TourPackageRepository;
import com.jeevanmaben.springboot.trails.repo.TourRepository;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                                             .orElseThrow(() ->
                                                     new RuntimeException("Invalid Tour Package" + tourPackageName));
        return tourRepository.save(new Tour(title, description,blurb, price, duration,
                bullets, keywords, difficulty, region, tourPackage));
    }
}
