package ac2_project.example.ac2_ca.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ac2_project.example.ac2_ca.Ac2CaApplication;

@SpringBootTest
class Ac2ApplicationTests {

	@Test
    void testMainMethod() {
        assertDoesNotThrow(() -> Ac2CaApplication.main(new String[]{}));
    }

}
