package kr.co.seonhyeokjun.eatgo.application;

import kr.co.seonhyeokjun.eatgo.domain.User;
import kr.co.seonhyeokjun.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepostory;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepostory, passwordEncoder);
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

    @Test
    public void authenticateWithValidAttributes(){
        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder()
                .email(email)
                .build();

        given(userRepostory.findByEmail(email)).willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(true);

        User user = userService.authenticate(email, password);

        assertThat(user.getEmail(), is(email));
    }

    @Test(expected = EmailNotExistedException.class)
    public void authenticateWithNotExistedEmail(){
        String email = "x@example.com";
        String password = "test";

        given(userRepostory.findByEmail(email)).willReturn(Optional.empty());

        userService.authenticate(email, password);

    }

    @Test(expected = PasswordWrongException.class)
    public void authenticateWithWrongPassword(){
        String email = "tester@example.com";
        String password = "x";

        User mockUser = User.builder()
                .email(email)
                .build();

        given(userRepostory.findByEmail(email)).willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(false);

        userService.authenticate(email, password);

    }

}