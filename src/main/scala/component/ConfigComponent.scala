package component

import pureconfig.ConfigReader.Result
import pureconfig.generic.auto._
import pureconfig.ConfigSource

case class ConfigComponent() {
  import ConfigComponent._

  def load(): Result[AppConfig] = ConfigSource.default.load[AppConfig]
}

object ConfigComponent {
  case class AppConfig(db: DBConfig, server: ServerConfig)
  case class DBConfig(className: String, memurl: String, diskurl: String, user: String, pass: String)
  case class ServerConfig(url: String, port: Int)
}
