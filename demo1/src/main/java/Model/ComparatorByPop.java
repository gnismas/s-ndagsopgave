package Model;

import Repository.MovieRepository;

import java.util.Comparator;

public class ComparatorByPop implements Comparator <Movies> {

    @Override
    public int compare(Movies o1, Movies o2) {
        return o2.getPopularity() - o1.getPopularity();
    }
}
