package com.example.project1.data.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String address1;
    private String address2;
    private String address3;
}
