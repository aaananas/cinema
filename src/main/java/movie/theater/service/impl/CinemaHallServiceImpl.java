package movie.theater.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.CinemaHallRequest;
import movie.theater.exception.DataProcessingException;
import movie.theater.model.CinemaHall;
import movie.theater.model.dto.CinemaHallDto;
import movie.theater.repository.CinemaHallRepository;
import movie.theater.service.CinemaHallService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;
    private final ModelMapper modelMapper;

    @Override
    public CinemaHallDto create(CinemaHallRequest request) {
        CinemaHall hall = modelMapper.map(request, CinemaHall.class);
        return modelMapper.map(cinemaHallRepository.save(hall), CinemaHallDto.class);
    }

    @Override
    public CinemaHallDto get(Long id) {
        return modelMapper.map(getHall(id), CinemaHallDto.class);
    }

    @Override
    public List<CinemaHallDto> getAll() {
        return cinemaHallRepository.findAll().stream()
                .map(e -> modelMapper.map(e, CinemaHallDto.class))
                .collect(Collectors.toList());
    }

    private CinemaHall getHall(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't get cinema hall by id " + id));
    }
}
