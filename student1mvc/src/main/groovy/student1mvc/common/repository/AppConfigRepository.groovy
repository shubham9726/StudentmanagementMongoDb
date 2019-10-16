package student1mvc.common.repository

import student1mvc.common.entity.AppConfigEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AppConfigRepository extends JpaRepository<AppConfigEntity, Long> {
}
