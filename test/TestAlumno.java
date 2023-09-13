import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestAlumno {

	@Test
	public void testRegistrarAlumnoEnUniversidad() {
        Universidad universidad = new Universidad(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Mi Universidad");
        Alumno alumno = new Alumno("Juan", "Perez", 12345, 20);
        
        alumno.registrarEnUniversidad(universidad);
        
        assertTrue(universidad.getListaDeAlumno().contains(alumno));
	}

}
