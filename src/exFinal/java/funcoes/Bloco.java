package funcoes;

import java.lang.constant.Constable;

public class Bloco {
        private Funcionario funcionario;
        private Bloco next, prev;
        private int index = 0;

        public Bloco(Funcionario funcionario) {
            this.funcionario = funcionario;
            this.index = index;
        }

        public int getIndex(){
            return index;
        }

        public void setIndex(int index) {
        this.index = index;
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