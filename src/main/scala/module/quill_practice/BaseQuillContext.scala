package module.quill_practice

import io.getquill._

object BaseQuillContext {
  implicit val ctx = new H2JdbcContext(SnakeCase, configPrefix = "ctx")
  //    new H2MonixJdbcContext(SnakeCase, "ctx", EffectWrapper.default)
}
