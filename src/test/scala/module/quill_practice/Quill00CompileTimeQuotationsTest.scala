package module.quill_practice

import module.quill_practice.BaseQuillContext.ctx
import module.quill_practice.model.Circle
import monix.eval.Task
import org.scalatest.funsuite.AnyFunSuite

class Quill00CompileTimeQuotationsTest extends AnyFunSuite {
  import BaseQuillContext._

  test("Test query filter by radius") {
    val expected = Circle(radius = 0.5f)

    Quill00CompileTimeQuotations.add(expected)

    val result: ctx.QueryMirror[Circle] = ctx.run(Quill00CompileTimeQuotations.q)
    assert(result.equals(expected))
  }
}
