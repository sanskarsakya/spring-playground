package com.puzan.springhandson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.puzan.springhandson.exception.PostResourceNotFoundException;
import com.puzan.springhandson.model.Category;
import com.puzan.springhandson.model.Comment;
import com.puzan.springhandson.model.Post;
import com.puzan.springhandson.repository.CommentRepository;
import com.puzan.springhandson.repository.PostRepository;
import com.puzan.springhandson.services.PostService;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private PostService postService;

    @GetMapping("/test")
    public Page<Comment> testComment(Pageable pageable) {
        // create post
        // create comment
        // link post to comment
        // add posts to array
        // add comments to array
        // persist post to db
        // persist comments to db
        // verify

        // Post post1 = new Post();
        // post1.setTitle("title 1");
        // post1.setDescription("description 1");
        // post1.setContent("content 1");
        // post1.setCategory(Category.MUSIC);

        // Post post2 = new Post();
        // post2.setTitle("title 3");
        // post2.setDescription("description 2");
        // post2.setContent("content 2");
        // post2.setCategory(Category.MUSIC);

        // List<Post> posts = Arrays.asList(post1, post2);

        // Comment comment1 = new Comment();
        // comment1.setText("text 1");
        // comment1.setPost(post1);

        // Comment comment2 = new Comment();
        // comment2.setText("text 2");
        // comment2.setPost(post2);

        // List<Comment> comments = Arrays.asList(comment1, comment2);

        // postRepository.saveAll(posts);
        // commentRepository.saveAll(comments);

        // List<Post> postList = postRepository.findAll();

        // for (Post p : postList) {
        // System.out.println(p.getTitle());
        // }

        postService.orphanRemovalTest();

        return commentRepository.findAll(pageable);
    }

    @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PostMapping("/posts/{postId}/bulkcomments")
    public Post createBulkComment(@PathVariable(value = "postId") Long postId,
            @Valid @RequestBody Set<Comment> comments) {
        return postRepository.findById(postId).map(post -> {
            // comment.setPost(post);
            post.getComments().clear();
            post.setComments(comments);

            return postRepository.save(post);
        }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId, @Valid @RequestBody Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new PostResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new PostResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId) {
        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new PostResourceNotFoundException(
                "Comment not found with id " + commentId + " and postId " + postId));
    }
}