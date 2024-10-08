package com.malvin.portfolio.presentation.dto

import com.malvin.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}