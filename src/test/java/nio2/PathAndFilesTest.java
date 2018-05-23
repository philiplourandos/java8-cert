package nio2;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathAndFilesTest {

    private static final Logger LOG = LogManager.getLogger(PathAndFilesTest.class);
    
    @Test
    public void validPathUsage() {
        Path required = Paths.get("target/test-classes/nio2/path1/path2/file1.txt");

        assertNotNull(required);
        assertTrue(Files.exists(required));

        // Not absolute path
        assertThrows(IllegalArgumentException.class, () -> Paths.get(new URI("target/test-classes/nio2/path1/path2/file1.txt")));

        final String currentDir = System.getProperty("user.dir");
        
        try {
            Path fileSchema = Paths.get(new URI(String.format("file://%s/target/test-classes/nio2/path1/path2/file1.txt", currentDir)));

            LOG.info("{}", fileSchema.toFile().getAbsolutePath());
            assertNotNull(fileSchema);
            assertTrue(Files.exists(fileSchema));
        } catch (URISyntaxException uri) {
            fail();
        }
    }
}
