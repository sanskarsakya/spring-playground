package com.puzan.springhandson;

import java.util.Arrays;
import java.util.List;

import com.puzan.springhandson.model.Category;
import com.puzan.springhandson.model.Comment;
import com.puzan.springhandson.model.Post;
import com.puzan.springhandson.repository.CommentRepository;
import com.puzan.springhandson.repository.PostRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHandsonApplication {

	public static void main(String[] args) {
		// ConfigurableApplicationContext configurableApplicationContext = SpringApplication
		// 		.run(SpringHandsonApplication.class, args);
		SpringApplication.run(SpringHandsonApplication.class, args);

		// PostRepository postRepository = configurableApplicationContext.getBean(PostRepository.class);
		// CommentRepository commentRepository = configurableApplicationContext.getBean(CommentRepository.class);

		// List<Post> posts = postRepository.findAll();

		// // posts.stream().map(post -> System.out.println(post.toString()));
		// for (Post p : posts) {
        //     System.out.println(p.toString());
        // }

		// Post post1 = new Post();
		// post1.setTitle("title 1");
		// post1.setDescription("description 1");
		// post1.setContent("content 1");
		// post1.setCategory(Category.MUSIC);

		// Post post2 = new Post();
		// post1.setTitle("title 2");
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

	}

}
