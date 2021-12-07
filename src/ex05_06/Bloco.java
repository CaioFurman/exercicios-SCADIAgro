package ex05_06;

public class Bloco {
        private Funcionario funcionario;
        private Bloco next, prev;

        public Bloco(Funcionario funcionario) {
            this.funcionario = funcionario;
        }
        public Funcionario getFuncionario() {
            return funcionario;
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