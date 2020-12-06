package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.CopyMovieRepository;
import pl.sda.MovieRental.service.CopyMovieService;

@Service
public class CopyMovieServiceImpl implements CopyMovieService {

    private final CopyMovieRepository copyMovieRepository;

    public CopyMovieServiceImpl(final CopyMovieRepository copyMovieRepository) {
        this.copyMovieRepository = copyMovieRepository;
    }

    @Override
    public void save(CopyMovie copyMovie) {
        copyMovieRepository.save(copyMovie);
    }

    @Override
    public CopyMovie getById(Long copyId) {
        return copyMovieRepository
                .findById(copyId)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        CopyMovie copyMovie = getById(id);

        if(copyMovie != null) {
            copyMovieRepository.delete(copyMovie);
        }

    }

    @Override
    public void update(CopyMovie copyMovie) {
        copyMovieRepository.save(copyMovie);


    }
}
