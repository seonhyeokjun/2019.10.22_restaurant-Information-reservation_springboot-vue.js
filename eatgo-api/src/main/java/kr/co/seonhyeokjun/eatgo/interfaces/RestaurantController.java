package kr.co.seonhyeokjun.eatgo.interfaces;

import kr.co.seonhyeokjun.eatgo.application.RestaurantService;
import kr.co.seonhyeokjun.eatgo.domain.MenuItem;
import kr.co.seonhyeokjun.eatgo.domain.MenuItemRepository;
import kr.co.seonhyeokjun.eatgo.domain.Restaurant;
import kr.co.seonhyeokjun.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }
}
