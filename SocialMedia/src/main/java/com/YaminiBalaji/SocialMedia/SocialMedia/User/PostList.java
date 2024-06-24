package com.YaminiBalaji.SocialMedia.SocialMedia.User;

import com.YaminiBalaji.SocialMedia.SocialMedia.User.Post;

import java.util.ArrayList;

public interface PostList {


    public ArrayList<Post> getAllPost();

    public Post getPost(int i);

    public void setPost(Post post);

    public int size();
}
