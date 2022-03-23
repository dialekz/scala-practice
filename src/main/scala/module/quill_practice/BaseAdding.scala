package module.quill_practice

import io.getquill.{H2JdbcContext, SnakeCase}
import io.getquill.mirrorContextWithQueryProbing._
import module.quill_practice.model.Circle

trait BaseAdding {

  def add(value: Circle)(implicit ctx: H2JdbcContext[SnakeCase]): Unit = ctx.run(quote {
    query[Circle].insertValue(lift(value))
  })
}
