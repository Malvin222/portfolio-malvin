package com.malvin.portfolio.domain

import com.malvin.portfolio.domain.constant.SkillType
import com.malvin.portfolio.domain.entity.*
import com.malvin.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {
    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화 합니다.")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2024, 9, 10),
                isActive = true
            ),
            Achievement(
                title = "SQLD",
                description = "SQL 기본문법, 데이터베이스 설계, 데이터베이스 성능 최적화등",
                host = "한국데이터산업진흥원",
                achievedDate = LocalDate.of(2024, 4, 5),
                isActive = true
            ),
            Achievement(
                title = "리눅스마스터2급",
                description = "리눅스 시스템 기초, 시스템관리, 보안 및 네트워크",
                host = "한국정보통신진흥원",
                achievedDate = LocalDate.of(2024, 10, 4),
                isActive = true
            ),
            Achievement(
                title = " 국비학원 프로젝트 발표회 최우수상",
                description = "여행정보 사이트 설계, 구축",
                host = "국비학원",
                achievedDate = LocalDate.of(2023, 9, 1),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "꾸준한 학습으로 지속적으로 성장하는 개발자 입니다.", isActive = true),
            Introduction(content = "팀원들과 정보를 공유하여 같이 성장하는 것을 추구합니다.", isActive = true),
            Introduction(content = "단순 개발보단 비즈니스적 로직을 생각해보고 효율적으로 개발하는 것을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/malvin222", isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "000대학교",
            description = "의생명과학과 전공",
            startYear = 2011,
            startMonth = 3,
            endYear = 2017,
            endMonth = 2,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 00/4.5", isActive = true),
                ExperienceDetail(content = "총학생회 임원", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "주식회사 캣카오(Catkao Corp.)",
            description = "웹개발팀 개발자",
            startYear = 2024,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "라이선스 관리 백오피스 페이지 개발", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val eGovFrame = Skill(name = "eGovFrame", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val git = Skill(name = "Git", type = SkillType.TOOL.name, isActive = true)
        val svn = Skill(name = "Svn", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, spring, mysql, oracle, eGovFrame, git, svn))

        val project1 = Project(
            name = "여행 정보 사이트",
            description = "공공 api를 활용한 국내 여행지 및 식당 정보, 카카오맵를 활용한 여행지 지도, 패키지 여행게시판 ",
            startYear = 2023,
            startMonth = 8,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "카카오 맵 API를 활용한 여행지 위치 정보 조회", url = null, isActive = true),
                ProjectDetail(content = "패키지 게시판 사업자 등록을 위한 사업자 등록번호 조회", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "https://github.com/Malvin222/Project_HITRIP", isActive = true)
                )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = eGovFrame),
                ProjectSkill(project = project1, skill = oracle),
            )
        )
        val project2 = Project(
            name = "물품 대여 사이트",
            description = "대여된 물품의 AS 예약을 위한 사이트",
            startYear = 2023,
            startMonth = 11,
            endYear = 2023,
            endMonth = 12,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "풀캘린더 라이브러리를 이용한 달력 기능 및 일정저장", url = null, isActive = true),
                ProjectDetail(content = "카카오 채널API를 사용한 카카오 채널상담", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "https://github.com/Malvin222/Rental_Web", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = mysql)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin",
            pw = "\$2a\$10\$COhz1izNGlKq4CziNKXX8ObnEgBgY6DUBTmCdq7XE4hukC4shX0OC"
        )
        accountRepository.save(account)
    }
}