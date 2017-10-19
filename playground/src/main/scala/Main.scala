import org.jline.reader
import org.jline.reader._
import org.jline.reader.impl.DefaultParser
import org.jline.reader.LineReader.Option
import org.jline.reader.Parser.ParseContext
import org.jline.reader.impl.history.DefaultHistory
import org.jline.terminal._
import org.jline.utils.AttributedString

import java.util.Arrays

class JLineTerminal {
  def readLine(): String = {
    val terminal = TerminalBuilder.terminal()
    val lineReader = LineReaderBuilder.builder()
      .terminal(terminal)
      .completer(new Completer)
      .parser(new Parser)
      .build()

    lineReader.readLine(">")
  }
}

class Parser extends reader.Parser {
  class DummyParsedLine(val cursor: Int, val line: String) extends ParsedLine {
    // using dummy values, not sure what they are used for
    def word = "}"
    def wordCursor = 0
    def wordIndex = 3
    // def words = java.util.Collections.emptyList[String]
    // def words = java.util.Collections.singletonList("List")
    def words = Arrays.asList("{", "List", ".", "}");
  }

  def parse(line: String, cursor: Int, context: ParseContext): ParsedLine = {
    new DummyParsedLine(cursor, line)
  }
}

class Completer extends reader.Completer {
  def complete(reader: LineReader, line: ParsedLine, candidates: java.util.List[Candidate]) = {
  val v = new Candidate(
      /* value    = */ "range",
      /* displ    = */ "range", // displayed value
      /* group    = */ null,  // can be used to group completions together
      /* descr    = */ null,  // TODO use for documentation?
      /* suffix   = */ null,
      /* key      = */ null,
      /* complete = */ false  // if true adds space when complete
    )
    println()
    println(line.cursor)
    println(line.line)
    candidates.add(new Candidate("range"))
  }
}


object Main {
	def main(args: Array[String]): Unit = {
    (new JLineTerminal).readLine()
	}
}