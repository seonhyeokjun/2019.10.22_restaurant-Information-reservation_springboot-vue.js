package kr.co.seonhyeokjun.eatgo.application;

import kr.co.seonhyeokjun.eatgo.domain.Reservation;
import kr.co.seonhyeokjun.eatgo.domain.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class ReservationServiceTests {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addReservation() {
        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        given(reservationRepository.save(any())).will(invocation -> {
            Reservation reservation = invocation.getArgument(0);
            return reservation;
        });

        Reservation reservation = reservationService.addReservation(
                restaurantId, userId, name, date, time, partySize);

        assertThat(reservation.getName()).isEqualTo(name);

        verify(reservationRepository).save(any(Reservation.class));
    }

}