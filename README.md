# Trabajo Práctico Programación Básica 2 - *Sistema de Gestión Universitaria*
Este proyecto consiste en un sistema/simulación de una universidad donde se pueden llevar a cabo operaciones relacionadas con la inscripción de alumnos, profesores, cursos, materias y notas, entre otras funciones. El sistema está desarrollado en Java y se enfoca principalmente en la programación orientada a pruebas con JUnit.

## Clase TestAlumno
* testRegistrarAlumnoEnUniversidad: Verifica que se pueda registrar un alumno correctamente en la universidad.
* testQueNoSePuedaRegistrarAlumnoExistenteEnUniversidad: Comprueba que no se pueda registrar un alumno que ya existe en la universidad.
* testSacarPromedioDeUnAlumno: Evalúa la capacidad de calcular el promedio de un alumno.
* testQueNoPuedaSacarPromedioDeUnAlumnoSinNotas: Verifica que un alumno no pueda calcular su promedio si no tiene notas registradas.
## Clase TestCurso
* queSePuedaRegistrarUnCursoCorrectamente: Comprueba que se pueda registrar un curso de manera exitosa.
* queNoSePuedaRegistrarUnCursoQueYaEsteRegistrado: Asegura que no se pueda registrar un curso que ya esté en el sistema.
* queNoSePuedaRegistrarUnCursoQueTengaElMismoMateriaTurnoYCicloLectivo: Verifica que no se pueda registrar un curso con la misma materia, turno y ciclo lectivo.
* queNoSePuedaRegistrarUnCursoQueElCicloLectivoNoEsteRegistradoEnLaUniversidad: Asegura que no se pueda registrar un curso si el ciclo lectivo correspondiente no está registrado en la universidad.
## Clase TestCursoAlumno
* testearLasMateriasAprobadasPorUnAlumno: Verifica que se puedan obtener las materias aprobadas por un alumno.
* testearLasMateriasNoAprobadasPorUnAlumno: Comprueba que se puedan obtener las materias no aprobadas por un alumno.
* testAsignarAlumnoACurso: Evalúa la asignación de un alumno a un curso.
* testQueNoSePuedaInscribirElAlumnoAElMismoCurso: Asegura que un alumno no pueda inscribirse en el mismo curso más de una vez.
* testQueSePuedaSacarPromedioPorElCurso: Verifica que se pueda calcular el promedio de un curso.
* testQueNoSePuedaSacarPromedioPorElCursoSinNotas: Comprueba que no se pueda calcular el promedio de un curso si no hay notas registradas.
## Clase TestCursoProfesor
* testAgregarProfesorEnCurso: Evalúa la capacidad de agregar un profesor a un curso.
* testQueNoSePuedaAgregarProfesorRepetidoEnCurso: Asegura que no se pueda agregar el mismo profesor dos veces a un curso.
* testQueNoSePuedaAgregar2ProfesoresEnCursoConMenosDe20Alumnos: Verifica que no se puedan agregar 2 profesores a un curso con menos de 20 alumnos.
* testQueSePuedaAgregar2ProfesoresEnCursoConMasDe20Alumnos: Comprueba que se puedan agregar 2 profesores a un curso con más de 20 alumnos.
## Clase TestMateria
* queSePuedaRegistrarUnaMateriaCorrectamente: Verifica que se pueda registrar una materia de manera exitosa.
* queNoPuedaRegistrarUnaMateriaQueYaEsteRegistrada: Asegura que no se pueda registrar una materia que ya está en el sistema.
* queNoPuedaRegistrarUnaMateriaQueNoFueInicializada: Comprueba que no se pueda registrar una materia que no ha sido inicializada correctamente.
## Clase TestMateriasQueFaltanCursarDeUnAlumno
* queSePuedaObtenerCorrectamentaLaListaDeMateriasQueLeFaltanCursarAUnAlumno: Verifica que se pueda obtener la lista de materias que un alumno debe cursar.
* alumnoAproboTodasLasMaterias: (Nota: falta corregir este test, No llegamos a terminarlo por falta de tiempo).
* alumnoLeFaltanCursasTodasLasMaterias: Comprueba que se pueda determinar si un alumno debe cursar todas las materias.
* testNoObtenerMateriasDeUnAlumnoqueNoExista: Asegura que no se pueda obtener la lista de materias de un alumno que no existe en la universidad.
## Clase TestMetodosCorrelativas
* queSePuedaAgregarUnaCorrelativaAUnaMateria: Verifica que se pueda agregar una materia como correlativa a otra materia.
* queNoSePuedaAgregarUnaCorrelativaAUnaMateriaQueNoExiste: Asegura que no se pueda agregar una correlativa a una materia que no existe.
* queSePuedaEliminarCorrelativa: Comprueba que se pueda eliminar una correlativa de una materia.
* queNoSePuedaEliminarCorrelativaDeUnaMateriaQueNoExiste: Asegura que no se pueda eliminar una correlativa de una materia que no existe.
## Clase TestNota
* testQueSePuedaAgregarUnaNotaValida: Verifica que se pueda agregar una nota válida.
* testQueNoSePuedaAgregarUnaNotaInvalida: Asegura que no se pueda agregar una nota inválida.
* testQueNoSePuedaAgregarUnTipoDeNotaRepetida: Comprueba que no se pueda agregar un tipo de nota repetida.
* testQueSePuedaAgregarDosTiposDeNotasDistintas: Evalúa la capacidad de agregar dos tipos de notas diferentes.
* testQueSePuedaAgregarTresTiposDeNotasDistintas: Verifica que se pueda agregar tres tipos de notas diferentes.
* testQueNoSePuedaAgregarMasDeTresTiposDeNotasDistintas: Asegura que no se pueda agregar más de tres tipos de notas diferentes.
* testQueSePuedaObtenerUnaNota: Comprueba que se pueda obtener una nota.
* testQueNoSePuedaObtenerUnaNota: Asegura que no se pueda obtener una nota inexistente.
* testQueSePuedaObtenerMasDeUnaNota: Verifica que se puedan obtener varias notas.
* testQueNoPuedaCursarDosRecuperatorios: Asegura que un alumno no pueda cursar dos recuperatorios.
## Clase TestProfesor
* testQueSePuedaRegistrarProfesorEnUniversidad: Verifica que se pueda registrar un profesor en la universidad.
* testRegistrarProfesorExistenteEnUniversidad: Comprueba que no se pueda registrar un profesor que ya existe en la universidad.
## Clase TestRegistrarAula
* queSePuedaAsignarUnAulaAUnCurso: Evalúa la asignación de un aula a un curso.
* queNoSePuedaAsignarUnAulaQueNoEstaRegistradoAUnCurso: Asegura que no se pueda asignar un aula que no está registrada a un curso.
* queNoSePuedaAsignarUnAulaAUnCursoQueNoEstaRegistrado: Verifica que no se pueda asignar un aula a un curso que no está registrado en la universidad.
