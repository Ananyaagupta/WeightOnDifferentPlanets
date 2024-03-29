package com.example.weighair.Dao

import com.example.weighair.Repository.WeightRepository
import com.example.weighair.entity.WeightList
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class WeightsDAO(private val weightRepository: WeightRepository, private val weightList: WeightList ){ //autowired alt
    fun fetchAllWeights(id:Int) : Optional<WeightList>{
        return  weightRepository.findById(id)
    }
    fun setIdAndName(id: Int, name: String){
        weightList.id=id
        weightList.name = name
        weightRepository.save(weightList)
    }


    fun checkIfExists(id: Int, planet: String): Double{
        val current : Optional<WeightList> =  weightRepository.findById(id)
        val weightList = current.get()
        var weightOnPlanet: Double? = null
        when(planet){
            "mercury" -> {
            weightOnPlanet = weightList.weightOnMercury
            }
            "venus" -> {
                weightOnPlanet = weightList.weightOnVenus
            }
            "earth" -> {
                weightOnPlanet = weightList.weightOnEarth
            }
            "mars" -> {
                weightOnPlanet = weightList.weightOnMars
            }
            "jupiter" -> {
                weightOnPlanet = weightList.weightOnJupiter
            }
            "saturn" -> {
                weightOnPlanet = weightList.weightOnSaturn
            }
            "uranus" -> {
                weightOnPlanet = weightList.weightOnUranus
            }
            "neptune" -> {
                weightOnPlanet = weightList.weightOnNeptune
            }
        }

        if (weightOnPlanet == null) return 0.0
        else return weightOnPlanet
    }

    fun setWeight(id: Int, planet: String, weightOnPlanet: Double){
        val current : Optional<WeightList> =  weightRepository.findById(id)
        val weightList = current.get()
        when(planet){
            "mercury" -> {
                weightList.weightOnMercury = weightOnPlanet

            }
            "venus" -> {
                weightList.weightOnVenus = weightOnPlanet
            }
            "earth" -> {
                weightList.weightOnEarth = weightOnPlanet
            }
            "mars" -> {
                weightList.weightOnMars = weightOnPlanet
            }
            "jupiter" -> {
                weightList.weightOnJupiter = weightOnPlanet
            }
            "saturn" -> {
                weightList.weightOnSaturn = weightOnPlanet
            }
            "uranus" -> {
                weightList.weightOnUranus = weightOnPlanet
            }
            "neptune" -> {
                weightList.weightOnNeptune = weightOnPlanet
            }
        }
        weightRepository.save(weightList)

    }
}