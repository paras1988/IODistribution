import java.util
import java.util.Map

class DistributeIOCPU {

  def main(args: Array[String]): Unit = {
    val clusterId = 1
    val map = new util.HashMap[_, _]
    map.put("T1", 3)
    map.put("T2", 1)
    map.put("T3", 33)
    map.put("T4", 5)
    val totalIO = Integer.toUnsignedLong(2222)
    val totalCPU = Integer.toUnsignedLong(22223)
    new DistributeIOCPU().distributeIO(clusterId, map, totalIO)
    new DistributeIOCPU().distributeCPU(clusterId, map, totalCPU)
  }

  private def distributeIO(clusterId: Integer, tableVsFrq: util.Map[String, Integer], totalIO: Long): Unit = {
    var counter = 0
    import scala.collection.JavaConversions._
    for (entry <- tableVsFrq.entrySet) {
      counter += entry.getValue
    }
    val IO = totalIO / counter
    import scala.collection.JavaConversions._
    for (entry <- tableVsFrq.entrySet) {
      System.out.println(clusterId + " " + entry.getKey + " " + entry.getValue * IO)
    }
  }

  private def distributeCPU(clusterId: Integer, tableVsFrq: util.Map[String, Integer], totalCPU: Long): Unit = {
    var counter = 0
    import scala.collection.JavaConversions._
    for (entry <- tableVsFrq.entrySet) {
      counter += entry.getValue
    }
    val CPU = totalCPU / counter
    import scala.collection.JavaConversions._
    for (entry <- tableVsFrq.entrySet) {
      System.out.println(clusterId + " " + entry.getKey + " " + entry.getValue * CPU)
    }
  }
}
