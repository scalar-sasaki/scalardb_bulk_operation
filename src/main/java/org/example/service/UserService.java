package org.example.service;

import com.github.f4b6a3.uuid.UuidCreator;
import lombok.RequiredArgsConstructor;
import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .toList();
    }

    public void createBulk(int count) {
        IntStream.range(0, count).forEach(i -> {
            var id = UuidCreator.getTimeOrderedEpoch().toString();
            var user = new User(
                    id,
                    "test",
                    id + "@test.com",
                    "東京都新宿区西新宿二丁目8番1号",
                    "JP",
                    "hogehoge"
            );
            userRepository.insert(user);
        });
    }
}
