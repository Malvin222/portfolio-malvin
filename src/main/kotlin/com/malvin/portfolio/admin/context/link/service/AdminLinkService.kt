package com.malvin.portfolio.admin.context.link.service

import com.malvin.portfolio.admin.data.TableDTO
import com.malvin.portfolio.domain.entity.Link
import com.malvin.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {

        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}