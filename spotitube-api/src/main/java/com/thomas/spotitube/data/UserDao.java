package com.thomas.spotitube.data;

import com.mongodb.client.MongoCollection;
import com.thomas.spotitube.data.interfaces.IUserDao;
import com.thomas.spotitube.domain.User;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class UserDao extends Database implements IUserDao {

    /**
     * Get Use by username
     *
     * @param username: String
     * @return User
     */
    @Override
    public User getUserByUsername(String username) {
        MongoCollection<User> collection = database.getCollection("users", User.class);
        User user = collection.find(eq("user", username)).first();

        if (user != null) {
            addToken(user);
        }

        return user;
    }

    /**
     * Get user by token
     *
     * @param token: String
     * @return User
     */
    @Override
    public User getUserByToken(String token) {
        MongoCollection<User> collection = database.getCollection("users", User.class);

        return collection.find(eq("token", token)).first();
    }

    /**
     * See if token exists
     *
     * @param token: String
     * @return boolean
     */
    @Override
    public boolean doesTokenExist(String token) {
        MongoCollection<User> collection = database.getCollection("users", User.class);
        User user = collection.find(eq("token", token)).first();

        return user != null;
    }

    /**
     * Add a token for the user and return it
     *
     * @param user: User
     * @return void
     */
    public void addToken(User user) {
        MongoCollection<User> collection = database.getCollection("users", User.class);
        final String token = UUID.randomUUID().toString();
        user.setToken(token);

        collection.updateOne(eq("id", user.getId()), set("token", token));
    }
}

