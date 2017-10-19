// import scala.meta._
// import java.nio.file._

// import scala.util.control.NonFatal

// object Meta {
//   val CorpusLocation = "/Users/renucci/Documents/Projects/scala-repos/repos"

//   class XmlLitCounter extends Traverser {
//     var expr, patt = 0

//     override def apply(tree: Tree): Unit = tree match {
//       case xml: Term.Xml =>
//         xml.parts.foreach(apply)
//         expr += 1
//       case xml: Pat.Xml  =>
//         xml.parts.foreach(apply)
//         patt += 1
//       case _ =>
//         super.apply(tree)
//     }
//   }

//   private def collectRepoStats(repo: Path) = {
//     val counter = new XmlLitCounter()
//     val files = Files.walk(repo)
//     val scalaFiles = files.filter(_.toString.endsWith(".scala")) // toString needed for extension

//     scalaFiles.forEach { path =>
//       val file = path.toFile

//       try {
//         val source = file.parse[Source].get
//         counter.apply(source)
//       } catch {
//         case NonFatal(_) =>
//           println(s"Failed to parse ${file.getPath}")
//       }
//     }

//     counter
//   }

//   def main(args: Array[String]): Unit = {
//     val repos = Files.list(Paths.get(CorpusLocation)).filter(_.toFile.isDirectory)
//     repos.forEach { path =>
//       val count = collectRepoStats(path)
//       println(path)
//       println(s"Expr: ${count.expr}, Patt: ${count.patt}\n")
//     }
//   }
// }