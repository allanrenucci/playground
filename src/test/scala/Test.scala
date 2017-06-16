object Test {
	def main(args: Array[String]): Unit = {
		implicit val hello: Int = 1
    println(Macro.foo)
	}
}