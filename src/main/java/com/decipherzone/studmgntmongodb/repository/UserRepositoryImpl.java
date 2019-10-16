package com.decipherzone.studmgntmongodb.repository;

import com.decipherzone.studmgntmongodb.model.User;

public abstract class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

}
