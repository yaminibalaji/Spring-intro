package com.YaminiBalaji.SocialMedia.SocialMedia.User;

import com.YaminiBalaji.SocialMedia.SocialMedia.User.Post;
import com.YaminiBalaji.SocialMedia.SocialMedia.User.PostList;

import java.util.ArrayList;

public class SimplePostList implements PostList {
    private ArrayList<Post> postList;

    public SimplePostList() {
        this.postList=new ArrayList<Post>();
    }

    @Override
    public ArrayList<Post> getAllPost() {
        return this.postList;
    }

    @Override
    public Post getPost(int i) {
        return this.postList.get(i);
    }

    @Override
    public void setPost(Post post) {
        this.postList.add(post);

    }

    @Override
    public int size() {
        return this.postList.size();
    }
}
