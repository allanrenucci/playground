// import scala.reflect.macros.blackbox
// import scala.language.experimental.macros

// object Macro {
//   def foo: Int = macro fooImpl

//   def fooImpl(c: blackbox.Context): c.Tree = {
//     import c.universe._
//     q"""
//       {
//         def foo(implicit x: Int): Int = x
//         foo
//       }

//     """
//   }
// }
