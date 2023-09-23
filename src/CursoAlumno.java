import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

public class CursoAlumno {
	private Integer id;
	private Alumno alumno;
	private List<Nota> listaDeNotas;///que reciba solo 3 notas , 1erParcial, 2doPArcial o algun recuperatorio  
	private Materia materia;
	
	public CursoAlumno(Alumno alumno, Materia materia) {
		super();
		this.alumno = alumno;
		this.listaDeNotas = new LinkedList<>();
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public boolean estaAprobado() {
		if(calcularNotaFinal() >= 7)
			return true;
		return false;
	}
	
	public Boolean estaCursado() {
		///los casos para que este recursado en este caso seria que la nota final sea >=4 && < 7 
		Integer notaFinal = calcularNotaFinal();
		if(notaFinal >= 4 && notaFinal < 7)
			return true;
		
		return false;
	}
	

	///metodo calcularNotafinal
	public Integer calcularNotaFinal() {
	    Integer nota1erParcial = null;
	    Integer nota2doParcial = null;

	    for (Nota nota : listaDeNotas) {
	        switch (nota.getTipoDeNota()) {
	            case RECUPERATORIO_1ERPARCIAL:
	                nota1erParcial = nota.getValorNota();
	                break;
	            case RECUPERATORIO_2DOPARCIAL:
	                nota2doParcial = nota.getValorNota();
	                break;
	            case PRIMER_PARCIAL:
	                nota1erParcial = nota.getValorNota();
	                break;
	            case SEGUNDO_PARCIAL:
	                nota2doParcial = nota.getValorNota();
	                break;
	        }
	    }

	    // Verificar si falta alguna nota
	    if (nota1erParcial == null || nota2doParcial == null) {
	        return 2; // Indicar que no se puede calcular la nota final
	    }

	    // Calcular la nota final redondeando hacia arriba
	    double notaFinal = (double) nota1erParcial / nota2doParcial;
	    return (int) Math.ceil(notaFinal);
	}

	
	public Boolean verificarQueNoPuedaRendir2Recuperatorios() {
		
		for (Nota nota : listaDeNotas) {
			if(nota.getTipoDeNota() == TipoDeNota.RECUPERATORIO_1ERPARCIAL || 
					nota.getTipoDeNota() == TipoDeNota.RECUPERATORIO_2DOPARCIAL)
				return false;
		}
		return true;
	}
}
