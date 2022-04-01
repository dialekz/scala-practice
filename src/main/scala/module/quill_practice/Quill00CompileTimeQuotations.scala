package module.quill_practice

import io.getquill._
import io.getquill.context.jdbc.JdbcContext
import module.quill_practice.model.Circle

class Quill00CompileTimeQuotations(ctx: JdbcContext[H2Dialect, SnakeCase.type]) extends AbstractAdding(ctx) {

  import ctx._

  def filterByRadius(radius: Float): List[Circle] = run(q(radius))

  private def q(radius: Float): Quoted[EntityQuery[Circle]] = quote {
    query[Circle].filter(_.radius > lift(radius))
  }
}
