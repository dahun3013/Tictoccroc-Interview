package com.example.project1.data.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {
    private Long addressId;
    private String address1;
    private String address2;
    private String address3;
}
