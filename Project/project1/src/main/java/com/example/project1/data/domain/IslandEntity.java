package com.example.project1.data.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "island")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IslandEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long islandId;
    private String islandName;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
