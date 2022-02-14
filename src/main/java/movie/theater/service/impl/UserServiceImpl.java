package movie.theater.service.impl;

import lombok.RequiredArgsConstructor;
import movie.theater.exception.UserNotFoundException;
import movie.theater.model.User;
import movie.theater.model.dto.UserDto;
import movie.theater.repository.UserRepository;
import movie.theater.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto save(User user) {
        User entity = userRepository.save(user);
        return modelMapper.map(entity, UserDto.class);
    }

    @Override
    public UserDto get(Long id) {
        User user = getUser(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = getUser(email);
        return modelMapper.map(user, UserDto.class);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Couldn't find user by id - %s", id)));
    }

    private User getUser(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("Couldn't find user by email - %s", email)));
    }
}
