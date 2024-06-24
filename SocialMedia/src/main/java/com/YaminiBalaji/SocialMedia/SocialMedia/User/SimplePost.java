package com.YaminiBalaji.SocialMedia.SocialMedia.User;

import com.YaminiBalaji.SocialMedia.SocialMedia.User.Post;

public class SimplePost implements Post {
    String message ;

    @Override
    public void setMessage(String message) {
        this.message=message;

    }

    @Override
    public String getMessage() {
        return  this.message;
    }
}
