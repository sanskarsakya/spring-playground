package com.puzan.springhandson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.puzan.springhandson.exception.PostResourceNotFoundException;
import com.puzan.springhandson.exception.ResourceNotFoundException;
import com.puzan.springhandson.model.Category;
import com.puzan.springhandson.model.Post;
import com.puzan.springhandson.model.Tournament;
import com.puzan.springhandson.repository.PostRepository;
import com.puzan.springhandson.services.tournament.TournamentService;

@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/tournaments")
    public Page<Tournament> getAllTournaments(Pageable pageable) {
        try {
            return tournamentService.findAll(pageable);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/tournaments")
    public Tournament createTournament(@Valid @RequestBody Tournament tournament) {
        try {
            return tournamentService.save(tournament);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("/tournaments/players")
    public Tournament createTournamentWithPlayers(@Valid @RequestBody Tournament tournament) {
        try {
            return tournamentService.saveWithPlayers(tournament);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    // @PutMapping("/posts/{postId}")
    // public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
    //     return postRepository.findById(postId).map(post -> {
    //         post.setTitle(postRequest.getTitle());
    //         post.setDescription(postRequest.getDescription());
    //         post.setContent(postRequest.getContent());
    //         post.setCategory(Category.MUSIC);
    //         return postRepository.save(post);
    //     }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + postId + " not found"));
    // }


    // @DeleteMapping("/posts/{postId}")
    // public ResponseEntity<?> deletePost(@PathVariable Long postId) {
    //     return postRepository.findById(postId).map(post -> {
    //         postRepository.delete(post);
    //         return ResponseEntity.ok().build();
    //     }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + postId + " not found"));
    // }

}