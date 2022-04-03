package module.quill_practice

import io.getquill._
import io.getquill.context.jdbc.JdbcContext
import module.quill_practice.model.Circle

class Quill00CompileTimeQuotations(ctx: JdbcContext[H2Dialect, SnakeCase.type]) extends AbstractAdding(ctx) {

  import ctx._

  // Quoting is implicit when writing a query in a run statement
  def biggerThan(radius: Float): List[Circle] = run(biggerThanQ(radius))

  private def biggerThanQ(radius: Float): Quoted[EntityQuery[Circle]] = quote {
    query[Circle].filter(_.radius > lift(radius)) // Need lift for parameter when using inside quote
  }


  // TODO literal-constants don't work:
  //  // Run query inline without quote -> don't need lift for parameter
  //  final val constantRadius: Float = 0.8f
  //  final val queryWithConstant: EntityQuery[Circle] = query[Circle].filter(_.radius > constantRadius)
  //  def biggerThanConstant: List[Circle] = run(queryWithConstant)


  def findAllUsingLiftQuery(radiusList: List[Float]): List[Circle] = run {
    query[Circle].filter(c => liftQuery(radiusList).contains(c.radius))
  }

  def insertBatch(circles: List[Circle]): List[Long] = run {
    liftQuery(circles).foreach(c => query[Circle].insertValue(c))
  }
}
