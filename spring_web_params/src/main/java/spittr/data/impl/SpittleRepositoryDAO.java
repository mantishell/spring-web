package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryDAO implements SpittleRepository {

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    public Spittle findOne(long spittleId) {
        return new Spittle("Path", new Date());
    }
}
