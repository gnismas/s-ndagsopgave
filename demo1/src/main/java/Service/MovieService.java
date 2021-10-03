package Service;

import Model.ComparatorByPop;
import Model.Movies;
import Repository.MovieRepository;

import java.util.Collections;
import java.util.List;

public class MovieService {
    private MovieRepository movieRepository = new MovieRepository();
    public Movies findFirstMovie() {
        return movieRepository.findFirstMovie(1);
    }
    public String findRandomMovie(){ return movieRepository.findRandomTitle();}
    public List<Movies> getTenSortByPop (){
        List<Movies> sortedMovies = movieRepository.findTenSortByPop();
        Collections.sort(sortedMovies, new ComparatorByPop());
        return sortedMovies;
    }
    public int findAward (){
        return movieRepository.findAward();
    }
    public List<Movies> findComedyAward(){
        return movieRepository.findComedyAward();
    }
}
