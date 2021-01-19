package com.puzan.springhandson.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.puzan.springhandson.model.Comment;
import com.puzan.springhandson.model.Post;
import com.puzan.springhandson.repository.PostRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Transactional
    public void orphanRemovalTest() {
        System.out.println("orphanRemovalTest");

        // fetch post by id
        // create new comments
        // add to comment set
        // clear post comment List
        // assign new comment list to post
        // persist post to database

        Long postId = (long) 4;
        Optional<Post> postFound = postRepository.findById(postId);
        Post postGet = postFound.get();

        Comment comment1 = new Comment();
        comment1.setText("assigning comment 8 to post with id 4");
        comment1.setPost(postGet);

        Comment comment2 = new Comment();
        comment2.setText("assigning comment 8 to post with id 4");
        comment2.setPost(postGet);

        Set<Comment> comments = new HashSet<Comment>();
        comments.add(comment1);
        comments.add(comment2);

        postGet.getComments().clear();
        
        postGet.setComments(comments);
        
        postRepository.save(postGet);
       

        // Set<Comment> comments = postGet.getComments();
        // FinalHrUser finalHrUser = fhu;
        // postGet.setComments(new HashSet<Comment>());
        // comments.forEach(comment -> {
        //     postGet.addComment(comment);
        // });

        // postGet.setComments(postGet.getComments());
        // postRepository.save(postGet);
    }
}