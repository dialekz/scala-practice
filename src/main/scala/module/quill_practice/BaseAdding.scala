package module.quill_practice

import io.getquill.context.jdbc.JdbcContext
import io.getquill.{H2Dialect, SnakeCase}
import module.quill_practice.model.Circle

abstract class BaseAdding(ctx: JdbcContext[H2Dialect, SnakeCase.type]) {

  import ctx._

  def add(value: Circle): Long = run(query[Circle].insertValue(lift(value)))
}
