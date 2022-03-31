package module.quill_practice

import module.quill_practice.model.Circle

class Quill00CompileTimeQuotationsTest extends AbstractQuillTestWithContext {

  private val solution = for {
    ctx <- context
    solution = new Quill00CompileTimeQuotations(ctx)
  } yield solution

  test("Test query filter by radius") {
    val expected = Circle(radius = 0.5f)

    for {
      s <- solution
      _ = s.add(expected)
      result = s.filterByRadius(0f)
      empty = s.filterByRadius(1f)
    } yield {
      assert(result.equals(List(expected)))
      assert(empty.isEmpty)
    }
  }
}
