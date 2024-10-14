package com.malvin.portfolio.admin.context.achievement.service

import com.malvin.portfolio.admin.data.TableDTO
import com.malvin.portfolio.domain.entity.Achievement
import com.malvin.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {

        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}