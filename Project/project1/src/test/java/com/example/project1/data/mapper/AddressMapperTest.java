package com.example.project1.data.mapper;

import com.example.project1.data.domain.AddressEntity;
import com.example.project1.data.dto.AddressDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AddressMapperTest {
    @Test
    public void addressEntityToAddressDTO(){
        //given
        AddressEntity address = AddressEntity.builder()
                .address1("도시")
                .address2("시")
                .address3("구")
                .build();
        //when
        AddressDTO addressDTO = AddressMapper.INSTANCE.toDTO(address);

        //then
        assertThat(addressDTO).isNotNull();
        assertThat(addressDTO.getAddress1()).isEqualTo("도시");
        assertThat(addressDTO.getAddress2()).isEqualTo("시");
        assertThat(addressDTO.getAddress3()).isEqualTo("구");
    }
    @Test
    public void addressDTOToAddressEntity(){
        //given
        AddressDTO addressDTO = AddressDTO.builder()
                .address1("도시")
                .address2("시")
                .address3("구")
                .build();
        //when
        AddressEntity address = AddressMapper.INSTANCE.toEntity(addressDTO);

        //then
        assertThat(address).isNotNull();
        assertThat(address.getAddress1()).isEqualTo("도시");
        assertThat(address.getAddress2()).isEqualTo("시");
        assertThat(address.getAddress3()).isEqualTo("구");
    }
}
