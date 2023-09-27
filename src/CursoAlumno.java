import java.util.ArrayList;
import java.util.List;

public class CursoAlumno {
	private Integer id;
	private Alumno alumno;
	public static List<Nota> listaDeNotas;/// que reciba solo 3 notas , 1erParcial, 2doPArcial o algun recuperatorio
	private Curso cursoDelAlumno;

	public CursoAlumno(Integer id, Alumno alumno, Curso cursoDelAlumno) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.cursoDelAlumno = cursoDelAlumno;
		this.listaDeNotas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCursoDelAlumno() {
		return cursoDelAlumno;
	}

	public void setCursoDelAlumno(Curso cursoDelAlumno) {
		this.cursoDelAlumno = cursoDelAlumno;
	}

	public boolean estaAprobado() {
		if (calcularNotaFinal() >= 7)
			return true;
		return false;
	}

	public Boolean estaCursado() {
		/// los casos para que este recursado en este caso seria que la nota final sea
		/// >=4 && < 7
		Double notaFinal = calcularNotaFinal();
		if (notaFinal >= 4 && notaFinal < 7)
			return true;

		return false;
	}

	public Boolean registrarNota(Integer idComision, Integer idAlumno, Nota nota) {
		Curso curso = Universidad.buscarCurso(idComision);
		Alumno alumno = Universidad.buscarAlumno(idAlumno);
		Integer valorNota = validarValorNota(nota);
		TipoDeNota valorTipoNota = validarTipoNota(nota);
		if (curso != null && alumno != null && valorNota != null && valorTipoNota != null) {
			Boolean aproboCorrelativas = Universidad.verificarQueLasCorrelativasEstenAprobadas(curso.getId(),
					alumno.getDNI());
			if (aproboCorrelativas) {
				nota.setValorNota(valorNota);
			} else {
				if (valorNota >= 7) {
					nota.setValorNota(7);
				}
				nota.setValorNota(valorNota);
			}
			listaDeNotas.add(nota);
			return true;
		}
		return false;
	}

	public Boolean obtenerNota(Integer idAlumno, Integer idMateria) {
		Alumno alumno = Universidad.buscarAlumno(idAlumno);
		Materia materia = Universidad.buscarMateria(idMateria);
		if (alumno != null && materia != null) {
			if (listaDeNotas.isEmpty()) {
				return false;
			} else {
				for (Nota nota : listaDeNotas) {
					nota.getValorNota();
				}
				return true;
			}
		}
		return false;
	}

	/// metodo calcularNotafinal
	public Double calcularNotaFinal() {
		Integer nota1erParcial = null;
		Integer nota2doParcial = null;

		if (listaDeNotas.isEmpty()) {
			return null;
		} else {
			for (Nota nota : listaDeNotas) {
				switch (nota.getTipoDeNota()) {
				case RECUPERATORIO_1ERPARCIAL:
				case PRIMER_PARCIAL:
					nota1erParcial = nota.getValorNota();
					break;
				case RECUPERATORIO_2DOPARCIAL:
				case SEGUNDO_PARCIAL:
					nota2doParcial = nota.getValorNota();
					break;
				}
			}
		}

		// Verificar si falta alguna nota
		if (nota1erParcial == null || nota2doParcial == null) {
			return null; // No se puede calcular la nota final
		}
		// Calcular la nota final como promedio ponderado (50% - 50%)
		Double notaFinal = (nota1erParcial + nota2doParcial) / 2.0;
		return notaFinal;
	}

	public List<Nota> getListaDeNotas() {
		return listaDeNotas;
	}

	public void setListaDeNotas(List<Nota> listaDeNotas) {
		this.listaDeNotas = listaDeNotas;
	}

	public Boolean verificarQueNoPuedaRendir2Recuperatorios() {
		for (Nota nota : listaDeNotas) {
			if (nota.getTipoDeNota() == TipoDeNota.RECUPERATORIO_1ERPARCIAL
					|| nota.getTipoDeNota() == TipoDeNota.RECUPERATORIO_2DOPARCIAL)
				return false;
		}
		return true;
	}

	public Integer validarValorNota(Nota nota) {
		if (nota.getValorNota() >= 1 && nota.getValorNota() <= 10) {
			return nota.getValorNota();
		}
		return null;
	}

	public TipoDeNota validarTipoNota(Nota nota) {
		// Tipo de nota repetido, no se agrega
		if (listaDeNotas.isEmpty()) {
			return nota.getTipoDeNota();
		} else {
			for (Nota notaExistente : listaDeNotas) {
				if (notaExistente.getTipoDeNota().equals(nota.getTipoDeNota())) {
					return null;
				} else {
					if (listaDeNotas.size() < 3) {
						return nota.getTipoDeNota();
					}
					return null;
				}
			}
		}
		return null;
	}

	public Boolean calcularPromedioPorCurso(Integer idAlumno) {
		if (listaDeNotas.isEmpty()) {
			return false; // No hay notas para calcular el promedio
		} else {
			// Calcular el promedio de las notas
			double sumaNotas = 0.0;
			int cantidadNotas = 0;
			for (Nota nota : listaDeNotas) {
				Integer valorNota = nota.getValorNota();
				if (valorNota != null) {
					sumaNotas += valorNota;
					cantidadNotas++;
				}
			}
			if (cantidadNotas > 0) {
				double promedio = sumaNotas / cantidadNotas;
				return true;
			} else {
				return false;
			}
		}
	}
}