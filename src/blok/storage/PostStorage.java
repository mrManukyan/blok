package blok.storage;

import blok.exception.PostNotFoundException;
import blok.model.Post;

public interface PostStorage {

    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostsByKeyword(String keyword);

    void printAllPost();

    void printPostByCategory(String categoty);
}

