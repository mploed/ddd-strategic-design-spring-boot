package com.innoq.mploed.ddd.creditAgency.controller;

import com.innoq.mploed.ddd.creditAgency.domain.Rating;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRatingControlloer {
    @RequestMapping(method = RequestMethod.GET, path = "/personRating")
    public Rating ratePerson(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "street", defaultValue = "") String street,
            @RequestParam(value = "postCode", defaultValue = "") String postCode
    ) {
        int points = 0;

        Rating rating = new Rating();

        if(postCode.startsWith("8")) {
            points += 100;
        } else if(postCode.startsWith("9")) {
            points += 100;
        }

        if(street.contains("Kreuz")) {
            points += 20;
        }

        rating.setPoints(points);
        if(points == 20) {
            rating.setColor("RED");
        } else if(points == 100) {
            rating.setColor("YELLOW");
        } else if(points > 100){
            rating.setColor("GREEN");
        } else {
            rating.setColor("BLACK");
        }


        return rating;

    }
}
