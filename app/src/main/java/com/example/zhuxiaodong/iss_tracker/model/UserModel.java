package com.example.zhuxiaodong.iss_tracker.model;

import java.util.LinkedList;
import java.util.List;

/**
 * User Model for users
 * contains basic info and notifications saved
 */

public class UserModel {
    String userName;
    String dateCreated;
    List<NotificationModel> notifications;

    public UserModel(String userName, String dateCreated){
        this.userName = userName;
        this.dateCreated = dateCreated;
        this.notifications = new LinkedList<>();
    }

    public UserModel(String userName, String dateCreated, List<NotificationModel> notifications){
        this.userName = userName;
        this.dateCreated = dateCreated;
        this.notifications = notifications;
    }
}
