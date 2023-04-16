import inno.ppa.main
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Stream

class MainTest {

    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @MethodSource("pathStream")
    fun `test code examples`(filepath: Path) {
        println(filepath.toUri())
        val original = System.`in`
        val fips = FileInputStream(filepath.toFile())
        System.setIn(fips)
        main(filepath.toString())
        System.setIn(original)
        println()
    }

    companion object {
        private const val BASE_DIR = "src/test/resources"

        @JvmStatic
        fun pathStream(): Stream<Path> = getFilesStream(BASE_DIR)

        private fun getFilesStream(path: String) = Files.list(Paths.get(path))
    }
}
