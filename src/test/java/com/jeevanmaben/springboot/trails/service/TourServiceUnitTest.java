package com.jeevanmaben.springboot.trails.service;

import com.jeevanmaben.springboot.trails.repo.TourRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TourServiceUnitTest {
    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourPackageService tourPackageService;

    @Test
    public void testCreateTour(){

    }
}
