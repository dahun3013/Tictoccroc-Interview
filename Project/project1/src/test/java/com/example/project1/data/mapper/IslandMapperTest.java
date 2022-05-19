package com.example.project1.data.mapper;

import com.example.project1.data.domain.AddressEntity;
import com.example.project1.data.domain.IslandEntity;
import com.example.project1.data.dto.AddressDTO;
import com.example.project1.data.dto.IslandDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class IslandMapperTest {
    @Test
    public void toDTO() {
        //given
        AddressEntity address = AddressEntity.builder()
                .addressId(1L)
                .address1("잠실")
                .address2("시")
                .address3("구")
                .build();
        IslandEntity island = IslandEntity.builder()
                .address(address)
                .islandName("지점명")
                .islandId(1L)
                .build();
        //when
        IslandDTO islandDTO = IslandMapper.INSTANCE.toDTO(island);

        //then
        assertThat(islandDTO).isNotNull();
        assertThat(islandDTO.getIslandId()).isEqualTo(1L);
        assertThat(islandDTO.getIslandName()).isEqualTo("지점명");
        assertThat(islandDTO.getAddress()).isEqualTo("주소코드");
    }

    @Test
    public void toEntity() {
        //given
        AddressDTO address = AddressDTO.builder()
                .addressId(1L)
                .address1("잠실")
                .address2("시")
                .address3("구")
                .build();
        IslandDTO islandDTO = IslandDTO.builder()
                .address(address)
                .islandName("지점명")
                .islandId(1L)
                .build();
        //when
        IslandEntity island = IslandMapper.INSTANCE.toEntity(islandDTO);

        //then
        assertThat(island).isNotNull();
        assertThat(island.getIslandId()).isEqualTo(1L);
        assertThat(island.getIslandName()).isEqualTo("지점명");
        assertThat(island.getAddress()).isEqualTo("주소코드");
    }
}
