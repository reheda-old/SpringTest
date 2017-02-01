package ua.pp.hak;

import java.util.ArrayList;
import java.util.List;

public class DAO {
	static List<Post> posts;

	static {
		posts = new ArrayList<>();
		posts.add(new Post(1, "hello"));
		posts.add(new Post(2, "world"));
		posts.add(new Post(3, "people"));

	}

	public static List<Post> getPosts() {
		return posts;
	}

	public static void deletePost(int id) {

		Post tempPost = null;
		for (Post p : posts) {
			if (p.id == id) {
				tempPost = p;

			}
		}

		if (tempPost != null) {
			posts.remove(tempPost);
		}
	}

	public static void addPost(String txt) {
		int newId = posts.get(posts.size()-1).getId();
		posts.add(new Post(newId + 1, txt));

	}

}
