package com.sut.ist.rotaback.controllers.rating;

import com.sut.ist.rotaback.controllers.rating.dto.RatingProfile;
import com.sut.ist.rotaback.controllers.rating.request.RatingTableRequest;
import com.sut.ist.rotaback.services.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rating")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(final RatingService ratingService) {this.ratingService = ratingService;}

    @PostMapping("/get/table")
    public @ResponseBody
    ResponseEntity<RatingProfile[]> getRatingTable(@RequestBody RatingTableRequest request) {
        return ResponseEntity.ok(ratingService.getRatingTable(request.login));
    }
}
