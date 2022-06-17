public class Calculator {
    public int compute(int num1, int num2, char c) {
        switch (c){
            case  '+':
                return num1 + num2;
            case  '-':
                return  num1 - num2;
        }
        return 0;
    }
}
