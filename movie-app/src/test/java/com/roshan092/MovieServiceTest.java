package com.roshan092;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MovieService.class})
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void returnsHighestGrossingMovie() throws Exception {
        String actual = movieService.getTopGrossingMovie(2016);
        Assert.assertEquals("Finding Dory", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void returnsFallback() throws Exception {
        String actual = movieService.getTopGrossingMovie(1984);
        Assert.assertEquals("Beauty and the Beast", actual);
    }

//    @Configuration
//    @EnableAspectJAutoProxy
//    static class SpringConfig {
//        @Bean
//        public HystrixCommandAspect hystrixCommandAspect() {
//            return new HystrixCommandAspect();
//        }
//    }
}
