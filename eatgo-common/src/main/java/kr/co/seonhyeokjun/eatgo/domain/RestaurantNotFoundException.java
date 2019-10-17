package kr.co.seonhyeokjun.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(Long id) {
        super("Could not find restaurant " + id);
    }
}
