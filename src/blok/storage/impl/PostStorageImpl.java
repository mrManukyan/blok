package blok.storage.impl;

import blok.exception.PostNotFoundException;
import blok.model.Post;
import blok.storage.PostStorage;

public class PostStorageImpl implements PostStorage {
    private Post[] posts = new Post[10];
    private int size = 0;
    @Override

    public void add(Post post) {
        if (size == posts.length) {
            extend();
        }
        posts[size++] = post;
    }

    private void extend() {
        Post[] tmp = new Post[posts.length + 15];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
        posts = tmp;
    }
    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
       throw  new PostNotFoundException("Post not found");
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                System.out.println(posts[i]);
            }
        }
    }

    @Override
    public void printAllPost() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);

        }
    }


    @Override
    public void printPostByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getCategory().equals(category)) {
                System.out.println(posts[i]);
            }
        }
    }


}
