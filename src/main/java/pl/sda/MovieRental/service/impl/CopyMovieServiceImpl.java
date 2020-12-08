package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.CopyMovieRepository;
import pl.sda.MovieRental.service.CopyMovieService;

import java.util.List;
import java.util.Optional;

@Service
public class CopyMovieServiceImpl implements CopyMovieService {

    private final CopyMovieRepository copyMovieRepository;

    public CopyMovieServiceImpl(final CopyMovieRepository copyMovieRepository) {
        this.copyMovieRepository = copyMovieRepository;
    }

    @Override
    public CopyMovie addCopyMovie(CopyMovie copyMovie) {
        return copyMovieRepository.save(copyMovie);
    }


    @Override
    public Optional<CopyMovie> findById(Long copyId) {
        return copyMovieRepository
                .findById(copyId);
    }


    @Override
    public List<CopyMovie> findAll() {
        return copyMovieRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        copyMovieRepository.deleteById(id);
    }

    @Override
    public void save(CopyMovie copyMovie) {
        copyMovieRepository.save(copyMovie);
    }


}
