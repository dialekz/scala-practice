package module.quill_practice

import module.quill_practice.model.Circle
import org.scalatest.BeforeAndAfterAll

class Quill00CompileTimeQuotationsTest extends AbstractQuillTestWithContext with BeforeAndAfterAll {

  private val solution = for {
    ctx <- context
    solution = new Quill00CompileTimeQuotations(ctx)
  } yield solution

  private val expected = Circle(radius = 0.9f)
  private val expected1 = Circle(radius = 0.1f)
  private val expected2 = Circle(radius = 0.2f)

  override def beforeAll(): Unit =
    for {
      s <- solution
      _ = s.insertBatch(List(expected, expected1, expected2))
    } yield ()

  test("biggerThan should filter correct fresh inserted item") {
    for {
      s <- solution
      result = s.biggerThan(0.8f)
      empty = s.biggerThan(1f)
    } yield {
      assert(result.equals(List(expected)))
      assert(empty.isEmpty)
    }
  }

  // TODO literal-constants don't work
  //  test("biggerThanConstant should filter correct fresh inserted item") {
  //    for {
  //      s <- solution
  //      result = s.biggerThanConstant
  //      empty = s.biggerThanConstant
  //    } yield {
  //      assert(result.equals(List(expected)))
  //      assert(empty.isEmpty)
  //    }
  //  }

  test("findAllUsingLiftQuery should filter correct fresh inserted items") {
    for {
      s <- solution
      result = s.findAllUsingLiftQuery(List(0.1f, 0.2f))
      empty = s.findAllUsingLiftQuery(List(1f))
    } yield {
      assert(result.equals(List(expected1, expected2)))
      assert(empty.isEmpty)
    }
  }
}
