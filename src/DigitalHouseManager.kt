import java.time.LocalDateTime

class DigitalHouseManager(val dataMatricula: LocalDateTime) {
    var listaAlunos: MutableList<Aluno> = mutableListOf()
    var listaProfessores: MutableList<Professor> = mutableListOf()
    var listaCursos: MutableList<Curso> = mutableListOf()
    var listaMatriculas: MutableList<Matricula> = mutableListOf()

    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaxAlunos: Int) {
        var curso = Curso(nome, codigoCurso, qtdMaxAlunos)
        listaCursos.add(curso)
    }

    fun excluirCurso(codigoCurso: Int) {
        for (curso in listaCursos) {
            if (codigoCurso == curso.codigoCurso)
                listaCursos.remove(curso)
        }
    }

    fun registrarProfessorAdjunto(
        nome: String,
        sobrenome: String,
        codigoProfessor: Int,
        horasDeMonitoria: Int) {

        var novoAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor, horasDeMonitoria)
        listaProfessores.add(novoAdjunto)
    }

    fun registrarProfessorTitular(
        nome: String,
        sobrenome: String,
        codigoProfessor: Int,
        especialidade: String) {

        var novoTitular = ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade)
        novoTitular.tempoDeCasa = 0
        listaProfessores.add(novoTitular)
    }

    fun excluirProfessor(codigoProfessor: Int) {
        for (professor in listaProfessores) {
            if (codigoProfessor == professor.codigoProfessor)
                listaProfessores.remove(professor)
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        var alunoNovo = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(alunoNovo)
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        var alunoMatricula: Aluno?
        alunoMatricula = listaAlunos[codigoAluno]
        var cursoMatricula: Curso?
        cursoMatricula = listaCursos[codigoCurso]

        try {
            if (alunoMatricula == null) {
                println("A matrícula está errada.")
            } else if (cursoMatricula == null) {
                println("O código do curso está errado.")
            } else if (alunoMatricula != null &&
                cursoMatricula != null &&
                cursoMatricula.listaAlunos.size < cursoMatricula.qtdMaxAlunos
            ) {

                var matricula = Matricula(alunoMatricula, cursoMatricula, dataMatricula)
                listaMatriculas.add(matricula)
                matricula.dataMatricula = LocalDateTime.now()
                println("A matrícula foi realizada.")

            } else {
                throw Exception("Não foi possível realizar a matrícula pois não há vagas.")
            }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    fun alocarProfessores(
        codigoCurso: Int,
        codigoProfessorTitular: Int,
        codigoProfessorAdjunto: Int) {

        var novoProfessorTitular: Professor?
        novoProfessorTitular = listaProfessores[codigoProfessorTitular]
        var novoProfessorAdjunto: Professor?
        novoProfessorAdjunto = listaProfessores[codigoProfessorAdjunto]
        var cursoProfessores: Curso?
        cursoProfessores = listaCursos[codigoCurso]

        try {
            if (novoProfessorAdjunto == null) {
                println("O código do professor está errado.")
            } else if (novoProfessorAdjunto == null) {
                println("O código do professor está errado.")
            } else if (cursoProfessores == null) {
                println("O código do curso está errado.")
            } else if (novoProfessorAdjunto != null &&
                novoProfessorTitular != null &&
                cursoProfessores != null
            ) {

                cursoProfessores.professorTitular = novoProfessorTitular as ProfessorTitular?
                cursoProfessores.professorAdjunto = novoProfessorAdjunto as ProfessorAdjunto?

            }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }
}