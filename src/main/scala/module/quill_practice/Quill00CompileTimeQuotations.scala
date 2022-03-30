package module.quill_practice

import io.getquill.{H2JdbcContext, Query, Quoted, SnakeCase}
import module.quill_practice.model.Circle

class Quill00CompileTimeQuotations(ctx: H2JdbcContext[SnakeCase]) extends BaseAdding {
  import ctx._

  val q: Quoted[Query[Circle]] = quote {
    query[Circle].filter(c => c.radius > 10)
  }
}
