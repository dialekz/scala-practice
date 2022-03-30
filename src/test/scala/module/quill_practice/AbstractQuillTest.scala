package module.quill_practice

import component.ConfigComponent
import org.scalatest.BeforeAndAfterAll

trait AbstractQuillTest extends BeforeAndAfterAll {

  override protected def beforeAll(): Unit = {
    for {
      config <- new ConfigComponent().load()
      context = new BaseQuillContext(config)
    } yield ()
  }
}
