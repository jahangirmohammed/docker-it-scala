package whisk.docker

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{ Second, Seconds, Span }
import org.scalatest.{ BeforeAndAfterAll, FlatSpec, Matchers }

class MongodbServiceSpec extends FlatSpec with Matchers with BeforeAndAfterAll with ScalaFutures
    with DockerTestKit
    with DockerMongodbService {

  implicit val pc = PatienceConfig(Span(20, Seconds), Span(1, Second))

  "mongodb node" should "be ready with log line checker" in {
    mongodbContainer.isReady().futureValue shouldBe true
  }
}
