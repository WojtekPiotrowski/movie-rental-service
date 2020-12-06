package pl.sda.MovieRental.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.repository.CopyMovieRepository;
import pl.sda.MovieRental.service.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private final CopyMovieRepository copyMovieRepository;

    private List<CopyMovie> movies = new ArrayList<>();

    @Autowired
    public CartServiceImpl(CopyMovieRepository copyMovieRepository) {
        this.copyMovieRepository = copyMovieRepository;
    }

    /**
     * If CopyMovie is already in the list, throw MovieAlreadyInCartException.
     * If CopyMovie is not in the list, add it
     *
     * @param copyMovie
     * @throws MovieAlreadyInCartException
     */
    @Override
    public void addMovie(CopyMovie copyMovie) throws MovieAlreadyInCartException {
        if (movies.contains(copyMovie)){
            throw new MovieAlreadyInCartException(copyMovie.getMovie());
        } else {
            movies.add(copyMovie);
        }
    }

    /**
     * If CopyMovie is in the list, remove it.
     *
     * @param copyMovie
     */
    @Override
    public void removeMovie(CopyMovie copyMovie)  {
        if (movies.contains(copyMovie)){
            movies.remove(copyMovie);
        }
    }

    /**
     * @return unmodifiable list of movie copies
     */
    @Override
    public List<CopyMovie> getMoviesInCart() {
        return Collections.unmodifiableList(movies);
    }

    /**
     * Checkout will rollback if some movies are not in stock.
     *
     * @throws NoMovieInStockException
     */
    @Override
    public void checkout() throws NoMovieInStockException {
        CopyMovie copyMovie;
        for (CopyMovie entry : movies) {
            if (!entry.isAvailable()){
                try {
                    movies.set(movies.indexOf(entry), entry.getMovie().getCopy());
                } catch (NoMovieInStockException e) {
                    throw e;
                }}
            entry.setAvailable(false);
        }
        copyMovieRepository.saveAll(movies);
        copyMovieRepository.flush();
        movies.clear();
    }

    @Override
    public BigDecimal getTotal() {
        return movies.stream()
                .map(entry -> entry.getMovie().getPrice())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
