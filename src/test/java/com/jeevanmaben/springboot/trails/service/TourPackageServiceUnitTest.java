package com.jeevanmaben.springboot.trails.service;

import com.jeevanmaben.springboot.trails.domain.TourPackage;
import com.jeevanmaben.springboot.trails.repo.TourPackageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TourPackageServiceUnitTest {
    @Mock
    private TourPackageRepository tourPackageRepository;

    @InjectMocks
    private TourPackageService tourPackageService;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePackageTour(){
        TourPackage tourPackage = new TourPackage("BC", "Backpack Cal");
        when(tourPackageRepository.save((any(TourPackage.class)))).thenReturn(tourPackage);
        TourPackage result = tourPackageService.createTourPackage("BC", "Backpack Cal");
        Assert.assertNotNull(result);
        Assert.assertEquals("BC", result.getCode());
    }

}
