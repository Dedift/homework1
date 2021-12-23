package com.company.homeworks.homework15;

import com.company.homeworks.homework15.entities.Dish;
import com.company.homeworks.homework15.entities.Restaurant;
import com.company.homeworks.homework15.entities.Review;
import com.company.homeworks.homework15.dao.RestaurantDao;
import com.company.homeworks.homework15.dao.ReviewDao;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Restaurant ginger = RestaurantDao.saveRestaurant(new Restaurant("Ginger"));
        Restaurant unoMas = RestaurantDao.saveRestaurant(new Restaurant("Uno Mas"));
        System.out.println(ginger.getId());
        System.out.println(unoMas.getId());

        ReviewDao.saveReview(new Review("Отличное заведение!", ginger));
        ReviewDao.saveReview(new Review("Еда пальчики оближешь!", ginger));
        ReviewDao.saveReview(new Review("Отличное заведение!", ginger));
        ReviewDao.saveReview(new Review("Приятная музыка", unoMas));
        ReviewDao.saveReview(new Review("Недожареная телятина, отвратительно!!!", unoMas));
        Review review = ReviewDao.saveReview(new Review("Все понравилось, особенно блюдо дня!", unoMas));
        System.out.println(review);

        RestaurantDao.saveDishOnRestaurant(ginger, new Dish("Рататуй"));
        RestaurantDao.saveDishOnRestaurant(ginger, new Dish("Пицца"));
        RestaurantDao.saveDishOnRestaurant(ginger, new Dish("Запеканка"));
        RestaurantDao.saveDishOnRestaurant(ginger, new Dish("Пирог с вишней"));
        RestaurantDao.saveDishOnRestaurant(unoMas, new Dish("Мраморная говядина"));
        RestaurantDao.saveDishOnRestaurant(unoMas, new Dish("Картофель по-деревенски"));
        RestaurantDao.saveDishOnRestaurant(unoMas, new Dish("Стейк с опятами на ажурном картофеле"));
        RestaurantDao.saveDishOnRestaurant(unoMas, new Dish("Медальоны из телятины"));
        System.out.println(ginger.getMenu());
        System.out.println(unoMas.getMenu());

        Optional<Restaurant> restaurantWithMenuAndReviews = RestaurantDao.getRestaurantWithMenuAndReviews(2);
        if (restaurantWithMenuAndReviews.isPresent()) {
            Restaurant restaurant = restaurantWithMenuAndReviews.get();
            System.out.println(restaurant);
        }
    }
}