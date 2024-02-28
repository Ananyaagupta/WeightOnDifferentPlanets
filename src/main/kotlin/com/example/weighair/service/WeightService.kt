package com.example.weighair.service

import com.example.weighair.Dao.WeightsDAO
import com.example.weighair.entity.WeightList
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class WeightService(private val weightsDAO: WeightsDAO) {

    public fun getAllWeights(id: Int): Optional<WeightList> {
        return weightsDAO.fetchAllWeights(id)
    }


    public fun checkIfNull(id: Int, planet: String): Double {
        return weightsDAO.checkIfExists(id, planet)
    }

    public fun calculateAndSetWeight(id: Int, planet: String, weightOnEarth: Int): Double {
        var weight: Double? = null
        when (planet) {
            "mercury" -> {
                weight = weightOnEarth * 0.38
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "venus" -> {
                weight = weightOnEarth * 0.91
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "earth" -> {
                weight = weightOnEarth * 1.0
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "mars" -> {
                weight = weightOnEarth * 0.38
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "jupiter" -> {
                weight = weightOnEarth * 2.34
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "saturn" -> {
                weight = weightOnEarth * 0.93
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "uranus" -> {
                weight = weightOnEarth * 0.89
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }

            "neptune" -> {
                weight = weightOnEarth * 0.65
                weightsDAO.setWeight(id, planet, weight)
                return weight
            }


        }
        return 0.0
    }

    fun getWeightOnPlanet(id: Int,name:String, planet: String, weightOnEarth: Int): Double {
        if (getAllWeights(id).isEmpty) {
            weightsDAO.setIdAndName(id, name)

        } else if (checkIfNull(id, planet) != 0.0) {
            return checkIfNull(id, planet)
        }
        return calculateAndSetWeight(id, planet, weightOnEarth)

    }
}
