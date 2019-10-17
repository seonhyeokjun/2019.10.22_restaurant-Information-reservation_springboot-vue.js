package kr.co.seonhyeokjun.eatgo.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegionTests {

    @Test
    public void creation() {
        Region region = Region.builder().name("서울").build();

        assertThat(region.getName()).isEqualTo("서울");
    }

}
