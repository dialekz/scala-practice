package module.quill_practice

import io.getquill.mirrorContextWithQueryProbing.{query, quote, schemaMeta}
import io.getquill.{Query, Quoted}
import module.quill_practice.model.Circle

object Quill00CompileTimeQuotations extends BaseAdding {
  implicit val CircleSchemaMeta = schemaMeta[Circle]

  val q: Quoted[Query[Circle]] = quote {
    query[Circle].filter(c => c.radius > 10)
  }
}
