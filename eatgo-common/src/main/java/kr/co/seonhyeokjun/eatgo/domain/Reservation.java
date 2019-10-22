package kr.co.seonhyeokjun.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long restaurantId;

    private Long userId;

    private String name;

    @NotEmpty
    private String date;

    @NotEmpty
    private String time;

    @NotNull
    private Integer partySize;
}
