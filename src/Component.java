abstract class Component {
    protected String nazwa;

    public Component(String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract int cd(String nazwaKat);
    public abstract void dir();
    protected abstract boolean jestPlikiem();
    protected Katalogi poprzednia;
}

