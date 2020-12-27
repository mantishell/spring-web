package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.Spitter;
import spittr.data.SpitterRepository;

@Repository
public class SpitterRepositoryDAO implements SpitterRepository {

    public Spitter save(Spitter spitter) {
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
