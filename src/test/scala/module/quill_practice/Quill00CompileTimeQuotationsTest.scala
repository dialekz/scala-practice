//package module.quill_practice
//
//import component.ConfigComponent
//import module.quill_practice.model.Circle
//import org.scalatest.funsuite.AnyFunSuite
//import pureconfig.error.ConfigReaderFailures
//
//class Quill00CompileTimeQuotationsTest extends AnyFunSuite with AbstractQuillTest {
//
//  val ctx: BaseQuillContext =  for {
//    config <- new ConfigComponent().load()
//    context = new BaseQuillContext(config)
//  } yield context.
//
//  val solution  = new Quill00CompileTimeQuotations(ctx)
//
//  test("Test query filter by radius") {
//    val expected = Circle(radius = 0.5f)
//
//    Quill00CompileTimeQuotations.add(expected)
//
//    val result: ctx.QueryMirror[Circle] = ctx.run(Quill00CompileTimeQuotations.q)
//    assert(result.equals(expected))
//  }
//}
