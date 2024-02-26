package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Reply;
import com.example.top_trumps_start_code.services.TopTrumpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/topTrumps")
public class TopTrumpsController {

    @Autowired
    TopTrumpsService topTrumpsService;

    @PostMapping
    public ResponseEntity<Reply> handleGame(@RequestBody ArrayList<Card> cards){
        Reply reply = topTrumpsService.checkWinner(cards);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @PostMapping(value = "/startGame")
    public ResponseEntity<Reply> newGame() {
        Reply reply = topTrumpsService.startGame();
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

}
