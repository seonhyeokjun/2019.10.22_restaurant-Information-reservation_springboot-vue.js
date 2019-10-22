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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Setter
    private Long restaurantId;

    private String name;

    @NotNull
    private Integer score;

    @NotEmpty
    private String description;
}
