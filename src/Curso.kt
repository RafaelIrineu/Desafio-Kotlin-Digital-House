class Curso(
    var nome: String,
    var codigoDoCurso: Int,
    var qtdMaxAlunos: Int
) {
    init {
        var professorTitular: ProfessorTitular
        var professorAdjunto: ProfessorAdjunto
        var listaAlunos = ArrayList<Aluno>()
    }
}