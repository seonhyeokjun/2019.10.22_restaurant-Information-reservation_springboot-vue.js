package kr.co.seonhyeokjun.eatgo.application;

import kr.co.seonhyeokjun.eatgo.domain.User;
import kr.co.seonhyeokjun.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepostory;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepostory);
    }

    @Test
    public void registerUser(){
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userService.registerUser(email, name, password);

        verify(userRepostory).save(any());
    }

    @Test(expected = EmailExistedException.class)
    public void registerUserWithExistedEmail(){
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        User user = User.builder().build();
        given(userRepostory.findByEmail(email)).willReturn(Optional.of(user));

        userService.registerUser(email, name, password);

        verify(userRepostory, never()).save(any());
    }

}