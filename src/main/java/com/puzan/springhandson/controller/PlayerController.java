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
import com.puzan.springhandson.model.Player;
import com.puzan.springhandson.model.Post;
import com.puzan.springhandson.model.Tournament;
import com.puzan.springhandson.repository.PostRepository;
import com.puzan.springhandson.services.player.PlayerService;
import com.puzan.springhandson.services.tournament.TournamentService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public Page<Player> getAllPlayers(Pageable pageable) {
        try {
            return playerService.findAll(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/players")
    public Player createTournament(@Valid @RequestBody Player player) {
        try {
            return playerService.save(player);
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