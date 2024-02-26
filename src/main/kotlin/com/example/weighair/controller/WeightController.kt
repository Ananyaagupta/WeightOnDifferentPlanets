package com.example.weighair.controller

import com.example.weighair.Exceptions.IdNotFoundException
import com.example.weighair.entity.WeightList
import com.example.weighair.service.WeightService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/weightOnPlanet")
class WeightController(private val weightService: WeightService) {


    @GetMapping("/myWeights/{id}")
    fun sendAllWeights(@PathVariable id: Int): ResponseEntity<Any> {
        val weights = weightService.getAllWeights(id)

        try {
            val weights = weightService.getAllWeights(id)
            return ResponseEntity.ok(weights.orElseThrow { IdNotFoundException("for the given id: $id no records exist") })
        } catch (e: IdNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
        }
    }

    @PostMapping("/getweight")
    fun weightOnPlanet(@RequestParam id: Int,  @RequestParam planet: String, @RequestParam weightOnEarth: Int):ResponseEntity<Any> {
        try {
            return ResponseEntity.ok(" your weight on $planet is " + weightService.getWeightOnPlanet(id,planet,weightOnEarth))
        } catch (e: IdNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
        }
    }

}