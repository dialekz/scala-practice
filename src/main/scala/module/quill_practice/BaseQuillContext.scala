package module.quill_practice

import com.typesafe.config.ConfigFactory
import component.ConfigComponent.AppConfig
import io.getquill._
import org.flywaydb.core.Flyway

import scala.jdk.CollectionConverters._

class BaseQuillContext(cfg: AppConfig) {
  lazy val ctx = new H2JdbcContext(SnakeCase, getConfig)

  private def getConfig = {
    lazy val memMap = Map(
      "dataSourceClassName" -> cfg.db.className,
      "dataSource.url" -> cfg.db.memurl,
      "dataSource.user" -> cfg.db.user,
      "dataSource.password" -> cfg.db.pass
    ).asJava

    lazy val diskMap = Map(
      "dataSourceClassName" -> cfg.db.className,
      "dataSource.url" -> cfg.db.diskurl,
      "dataSource.user" -> cfg.db.user,
      "dataSource.password" -> cfg.db.pass
    ).asJava

    if (cfg.db.h2Type == "memory") ConfigFactory.parseMap(memMap)
    else ConfigFactory.parseMap(diskMap)
  }

  def initH2Db: Int = {
    val dataSource = if (cfg.db.h2Type == "memory") cfg.db.memurl else cfg.db.diskurl
    Flyway
      .configure()
      .validateMigrationNaming(true)
      .dataSource(dataSource, cfg.db.user, cfg.db.pass)
      .load()
      .migrate()
  }
}
