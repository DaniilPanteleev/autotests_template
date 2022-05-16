package autotests.template.generics;

public class CommonOutput<T> {

    T var;

    public CommonOutput(T var) {
        this.var = var;
    }

    public T getCurrentElement() {
        return var;
    }

    public void setCurrentElement(T var) {
        this.var = var;
    }

    protected void print() {
        System.out.println(var);
    }

}
