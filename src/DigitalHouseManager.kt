import java.time.LocalDateTime

class DigitalHouseManager(val dataMatricula: LocalDateTime) {
        var listaAlunos: MutableList<Aluno> = mutableListOf<Aluno>()
        var listaProfessores: MutableList<Professor> = mutableListOf<Professor>()
        var listaCursos: MutableList<Curso> = mutableListOf<Curso>()
        var listaMatriculas: MutableList<Matricula> = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaxAlunos: Int){
        var curso = Curso(nome, codigoCurso, qtdMaxAlunos)
        listaCursos.add(curso)
    }

    fun excluirCurso(codigoCurso: Int) {
        var curso: Curso? = null
        if (curso != null) {
            listaCursos.remove(curso)
        }
    }

    fun registrarProfessorAdjunto(nome: String,
                                  sobrenome: String,
                                  codigoProfessor: Int,
                                  horasDeMonitoria: Int){
        var novoAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor,horasDeMonitoria)
        listaProfessores.add(novoAdjunto)
    }

    fun registrarProfessorTitular(nome: String,
                                  sobrenome: String,
                                  codigoProfessor: Int,
                                  especialidade: String) {
        var novoTitular = ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade)
        novoTitular.tempoDeCasa = 0
        listaProfessores.add(novoTitular)
    }

    fun excluirProfessor(codigoProfessor: Int){
        var codigo: Professor? = null
        if(codigo !=null){
            listaProfessores.remove(codigo)
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int){
        var alunoNovo = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(alunoNovo)
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso:Int){
        var alunoMatricula = listaAlunos[codigoAluno]
        var cursoMatricula = listaCursos[codigoCurso]
        var matricula = Matricula(alunoMatricula, cursoMatricula, dataMatricula)
        listaMatriculas.add(matricula)
    }

    //dificuldade na criação deste método....

    /*fun alocarProfessores(codigoCurso: Int,
                          codigoProfessorTitular: Int,
                          codigoProfessorAdjunto: Int){
        var novoProfessorTitular = listaProfessores[codigoProfessorTitular]
        var novoProfessorAdjunto = listaProfessores[codigoProfessorAdjunto]
        var cursoProfessores = listaCursos[codigoCurso]
        if(novoProfessorAdjunto != null && novoProfessorTitular != null){
            cursoProfessores.professorTitular = codigoProfessorTitular
        }
    }*/

}