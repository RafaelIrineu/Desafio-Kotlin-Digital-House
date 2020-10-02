class ProfessorTitular (nome: String,
                        sobrenome: String,
                        tempoDeCasa: Int,
                        codigoProfessor: Int,
                        especialidade: String): Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
    constructor(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String)
}