package com.example.weighair.Repository

import com.example.weighair.entity.WeightList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeightRepository: JpaRepository<WeightList, Int> {

}