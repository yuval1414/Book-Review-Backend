package com.example.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/data")
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {


    @Autowired
    private ReviewService reviewList;

    @PostMapping("/ConfirmReviewSaved")
    public  ResponseEntity<ResponseMessage> createNewReview(@RequestBody ReviewDTO newReview) {

        try {

            reviewList.saveReview(newReview);
            ResponseMessage response = new ResponseMessage(201,"Review saved successfully", null);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exception) {
            ResponseMessage response = new ResponseMessage(500,"Server Error in saving review", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ShowNotebook")
    public  ResponseEntity<ResponseMessage> getAllReviews() {
        try {

            if(reviewList != null){
                ResponseMessage response = new ResponseMessage(200, "Data successfully fetched from server", reviewList);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else throw new Exception();
        } catch (Exception exception) {
            ResponseMessage response = new ResponseMessage(500, "Server Error in fetching data", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
