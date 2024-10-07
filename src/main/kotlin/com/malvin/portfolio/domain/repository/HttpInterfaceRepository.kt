package com.malvin.portfolio.domain.repository

import com.malvin.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    fun countAllByCreatedDateTimeBetween(start: LocalDate, end: LocalDateTime)
}