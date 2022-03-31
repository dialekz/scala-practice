package module.quill_practice

import component.ConfigComponent
import org.scalatest.funsuite.AnyFunSuite

abstract class AbstractQuillTestWithContext extends AnyFunSuite {

  protected val context = for {
    config <- new ConfigComponent().load()
    context = new BaseQuillContext(config)
    _ = context.initH2Db
  } yield context.ctx
}
