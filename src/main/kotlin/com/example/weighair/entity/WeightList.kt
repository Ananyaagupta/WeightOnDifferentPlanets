package com.example.weighair.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.stereotype.Component

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weights")
@Component
data class WeightList(
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
var id: Int,

@Column(name="name")
var name: String? = null,

@Column(name="mercury")
var weightOnMercury: Double? =null,

@Column(name="venus")
var weightOnVenus: Double? = null,

@Column(name="earth")
var weightOnEarth: Double? = null,

@Column(name="mars")
var weightOnMars: Double? = null,

@Column(name="jupiter")
var weightOnJupiter: Double? = null,

@Column(name="saturn")
var weightOnSaturn: Double? = null,

@Column(name="uranus")
var weightOnUranus: Double? = null,

@Column(name="neptune")
var weightOnNeptune: Double? = null
)
