class Curso(
    var nome: String,
    var codigoCurso: Int,
    var qtdMaxAlunos: Int
) {
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    var listaAlunos: MutableList<Aluno> = mutableListOf()

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        for (c in 0..qtdMaxAlunos) {
            listaAlunos.add(umAluno)
            return true
        }
        return false
    }

    fun excluirAluno(umAluno: Aluno) {
        listaAlunos.remove(umAluno)
    }
}