
import java.sql.{ Connection,DriverManager,Statement }


object QueryData  {
  def Connect2sql(): Unit = {
  val url = "jdbc:mysql://8.135.50.38:30306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "myfreedom#"
  var connection: Connection = null
    try {
      //注册Driver
      Class.forName(driver)
      //得到连接
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      //执行查询语句，并返回结果
      val rs = statement.executeQuery("SELECT * FROM student")
      //打印返回结果
      while (rs.next) {
        val name = rs.getString("name")
        val id = rs.getString("id")
        //      println(name+"\t"+num)
        println("name = %s, num = %s".format(name, id))
      }

      println("查询数据完成！")


      /*//    执行插入操作
      val rs2 = statement.executeUpdate("INSERT INTO `persons` (`name`, `num`) VALUES ('徐志摩', '22')")
      println("插入数据完成")


      //    执行更新操作
      val rs3 = statement.executeUpdate("UPDATE persons set num=55 WHERE `name`=\"徐志摩\"")
      println("更新数据完成！")

      //    执行删除操作

      val rs4 = statement.executeUpdate("delete from persons WHERE `name`=\"徐志摩\"")
      println("删除数据完成！")

      //    执行调用存储过程操作
      val rs5 = statement.executeUpdate("call add_student(3)")
      println("调用存储过程完成！")
*/

    } catch {
      case e: Exception => e.printStackTrace
    } finally {
      //关闭连接，释放资源
      connection.close
    }

  }
  def main(args: Array[String]): Unit = {
  Connect2sql()
  }
}
