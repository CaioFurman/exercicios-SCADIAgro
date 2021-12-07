package ex05_06;

import java.lang.constant.Constable;

public class Bloco {
        private Funcionario funcionario;
        private Bloco next, prev;

        public Bloco(Funcionario funcionario) {
            this.funcionario = funcionario;
        }

        public Constable funcionarioFormato() {
            return funcionario.Formatar();
        }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
            this.funcionario = funcionario;

        }

        public Bloco getNext() {
            return next;
        }

        public void setNext(Bloco next){
            this.next = next;
        }

        public Bloco getPrev() {
            return prev;
        }

        public void setPrev(Bloco prev){
            this.prev = prev;
        }
}