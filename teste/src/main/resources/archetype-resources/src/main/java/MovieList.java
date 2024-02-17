import java.util.List;

public class MovieList {
    List<Movie> moviesList;

    public MovieList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "moviesList=" + moviesList +
                '}';
    }
}
